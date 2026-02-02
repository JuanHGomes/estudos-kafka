package com.example.vendas_service.business;

import com.example.vendas_service.business.mapper.VendasServiceMapper;
import com.example.vendas_service.data.VendasRepository;
import com.example.vendas_service.data.model.Venda;
import com.example.vendas_service.messaging.VendasProducer;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

@Slf4j
@RequiredArgsConstructor
@Service
public class VendasService {

    private final VendasRepository repository;
    private final VendasProducer kafkaSender;

    public Venda novaVenda(Venda venda){
       log.info("Salvando venda no mongodb: [{}]", venda);
       Venda novaVendaSalva = repository.salvarNovaVenda(venda);

       kafkaSender.publicarVenda(venda);

       return novaVendaSalva;
    }


}
