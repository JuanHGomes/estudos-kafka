package com.example.vendas_service.messaging;

import com.example.vendas_service.data.model.Venda;
import com.example.vendas_service.messaging.mapper.VendaEventMapper;
import com.example.vendas_service.messaging.model.VendaEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class VendasProducer {
    private final VendaEventMapper mapper;
    private final KafkaTemplate<String, VendaEvent> kafkaTemplate;
    private static final String KAFKA_TOPIC = "VENDAS_TOPIC";

    public void publicarVenda(Venda venda){
        VendaEvent event = mapper.toEvent(venda);

        kafkaTemplate.send(KAFKA_TOPIC, event);
    }
}
