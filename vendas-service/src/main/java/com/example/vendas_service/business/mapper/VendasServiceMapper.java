package com.example.vendas_service.business.mapper;

import com.example.vendas_service.data.model.Venda;
import com.example.vendas_service.messaging.model.VendaEvent;
import org.springframework.stereotype.Component;

@Component
public class VendasServiceMapper {
    public VendaEvent toEvent(Venda venda){
        return VendaEvent.builder()
                .id(venda.getId())
                .nomeItem(venda.getNomeItem())
                .quantidade(venda.getQuantidade())
                .build();
    }
}
