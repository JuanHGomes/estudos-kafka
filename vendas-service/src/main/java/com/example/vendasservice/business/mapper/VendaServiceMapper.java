package com.example.vendasservice.business.mapper;

import com.example.vendasservice.data.venda.model.Venda;
import com.example.vendasservice.messaging.model.VendaEvent;
import org.springframework.stereotype.Component;

@Component
public final class VendaServiceMapper {
    public VendaEvent toEvent(Venda venda){
        return VendaEvent.builder()
                .nomeItem(venda.getNomeItem())
                .quantidade(venda.getQuantidade())
                .build();
    }
}
