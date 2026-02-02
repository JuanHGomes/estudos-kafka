package com.example.estoqueservice.business;


import com.example.estoqueservice.business.enums.MotivoRecusa;
import com.example.estoqueservice.data.estoque.repository.EstoqueRepository;
import com.example.estoqueservice.data.venda.model.Venda;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class EstoqueService {
    private final EstoqueRepository estoqueRepository;

    @Transactional
    public void novaVenda(Venda venda) {
        boolean isQuantidadeDisponivel = verificarEstoque(venda);

        if(!isQuantidadeDisponivel){
          venda.setMotivoRecusa(MotivoRecusa.FALTA_ESTOQUE);
        }

        atualizarEstoque(venda);
    }

    @Transactional
    public void atualizarEstoque(Venda venda){
        log.info("Diminuindo o estoque");
        estoqueRepository.diminuirEstoque(venda.getNomeItem(), venda.getQuantidade());
    }


    @Transactional
    public boolean verificarEstoque(Venda venda){
        log.info("Confirmando disponibilidade do item no estoque: {}", venda.getNomeItem());

        Long quantidade = estoqueRepository.getQuantidade(venda.getNomeItem());

        if(quantidade < venda.getQuantidade()){
            Long quantidadeFaltante = quantidade - venda.getQuantidade();
            log.info("Quantidade em estoque insuficiente, quantidade atual: {}, quantidade faltante: {}", quantidade, quantidadeFaltante);
            return  false;
        }

        log.info("Quantidade em estoque suficiente, seguindo para dminiuição no estoque.");
        return true;

    }
}
