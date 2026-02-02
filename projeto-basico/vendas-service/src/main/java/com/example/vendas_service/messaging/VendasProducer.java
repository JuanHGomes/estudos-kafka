package com.example.vendas_service.messaging;

import com.example.vendas_service.data.model.Venda;
import com.example.vendas_service.messaging.mapper.VendaEventMapper;
import com.example.vendas_service.messaging.model.VendaEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Slf4j
@RequiredArgsConstructor
@Component
public class VendasProducer {
    private final VendaEventMapper mapper;
    private final KafkaTemplate<String, VendaEvent> kafkaTemplate;
    private static final String KAFKA_TOPIC = "VENDAS_TOPIC";

    public void publicarVenda(Venda venda){
        log.info("Enviando mensagegem para o tópico {}, payload: {}",KAFKA_TOPIC, venda);
        VendaEvent event = mapper.toEvent(venda);

        kafkaTemplate.send(KAFKA_TOPIC, event);
    }
}
