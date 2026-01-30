package com.example.estoqueservice.business;


import com.example.estoqueservice.data.estoque.repository.EstoqueRepository;
import com.example.estoqueservice.messaging.model.VendaEvent;
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
    public void atualizarEstoque(VendaEvent venda){
        estoqueRepository.diminuirEstoque(venda.getNomeItem(), venda.getQuantidade());
    }
}
