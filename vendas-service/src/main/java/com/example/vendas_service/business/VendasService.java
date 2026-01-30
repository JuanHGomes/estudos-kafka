package com.example.vendas_service.business;

import com.example.vendas_service.business.mapper.VendasServiceMapper;
import com.example.vendas_service.data.VendasRepository;
import com.example.vendas_service.data.model.Venda;
import com.example.vendas_service.messaging.VendasProducer;
import com.example.vendas_service.messaging.model.VendaEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class VendasService {

    private final String VENDAS_TOPIC = "VENDAS_TOPIC";

    private final VendasRepository repository;
    private final VendasProducer kafkaSender;
    private final VendasServiceMapper mapper;

    public Venda novaVenda(Venda venda){
       Venda novaVendaSalva = repository.salvarNovaVenda(venda);

       kafkaSender.publicarVenda(venda);

       return novaVendaSalva;
    }


}
