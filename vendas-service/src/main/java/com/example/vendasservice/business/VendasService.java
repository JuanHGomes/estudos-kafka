package com.example.vendasservice.business;

import com.example.vendasservice.messaging.model.VendaEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class VendasService {

    private final KafkaTemplate<String, VendaEvent> kafkaTemplate;

    public void novaVenda(VendaEvent venda){
        kafkaTemplate.send("vendas-topic", venda);
    }
}
