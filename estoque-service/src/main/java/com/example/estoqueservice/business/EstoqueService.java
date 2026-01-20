package com.example.estoqueservice.business;


import com.example.estoqueservice.data.model.Item;
import com.example.estoqueservice.data.repository.EstoqueRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class EstoqueService {

    private final EstoqueRepository estoqueRepository;

    public Long retiratItem(String nomeItem, Long quantidade){
         Item item = estoqueRepository.findByName(nomeItem)
                 .orElseGet(() -> {
                     log.info("O item [{}] não foi localizado.", nomeItem);
                     return 0;
                 });

         estoqueRepository.diminuirEstoque(nomeItem, quantidade);

    }
}
