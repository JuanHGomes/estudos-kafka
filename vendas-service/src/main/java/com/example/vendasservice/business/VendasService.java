package com.example.vendasservice.business;

import com.example.vendasservice.business.mapper.VendaServiceMapper;
import com.example.vendasservice.data.venda.VendaRepository;
import com.example.vendasservice.data.venda.model.Venda;
import com.example.vendasservice.messaging.model.VendaEvent;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class VendasService {

    private final KafkaTemplate<String, VendaEvent> kafkaTemplate;
    private final VendaServiceMapper mapper;
    private final VendaRepository vendaRepository;
    private static final String TOPICO = "vendas-topic";

    public void novaVenda(Venda venda){
        log.info("Nova venda recebida com sucesso: []", venda);

        vendaRepository.salvar(venda);

        VendaEvent vendaEvent = mapper.toEvent(venda);
        kafkaTemplate.send(TOPICO, vendaEvent);
        log.info("Venda enviada ao kafka. Payload: []", vendaEvent);
    }
}
