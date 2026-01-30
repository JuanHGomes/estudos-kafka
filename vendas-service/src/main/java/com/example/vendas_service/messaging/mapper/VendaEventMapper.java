package com.example.vendas_service.messaging.mapper;

import com.example.vendas_service.data.model.Venda;
import com.example.vendas_service.messaging.model.VendaEvent;
import org.springframework.stereotype.Component;

@Component
public class VendaEventMapper {
    public VendaEvent toEvent(Venda venda){
        return VendaEvent.builder()
                .nomeItem(venda.getNomeItem())
                .quantidade(venda.getQuantidade())
                .build();

    }
}
