package com.example.estoqueservice.messaging.model;

import com.example.estoqueservice.business.EstoqueService;
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

    @Transactional
    @KafkaListener(topics = "VENDAS_TOPIC", groupId = "estoque-group")
    public void kafkaListener(VendaEvent venda){
        log.info("Venda recebida: [{}]", venda);

        estoqueService.atualizarEstoque(venda);
    }
}
