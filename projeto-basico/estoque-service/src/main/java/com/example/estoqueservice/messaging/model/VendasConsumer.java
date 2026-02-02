package com.example.estoqueservice.messaging.model;

import com.example.estoqueservice.business.EstoqueService;
import com.example.estoqueservice.data.venda.model.Venda;
import com.example.estoqueservice.messaging.model.mapper.VendaEventMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class VendasConsumer {
    private final EstoqueService estoqueService;
    private final VendaEventMapper mapper;

    @Transactional
    @KafkaListener(topics = "VENDAS_TOPIC", groupId = "estoque-group")
    public void kafkaListener(VendaEvent vendaEvent){
        log.info("Venda recebida: [{}], iniciando fluxo de estoque", vendaEvent);

        Venda venda = mapper.toDomain(vendaEvent);

        estoqueService.novaVenda(venda);
    }
}
