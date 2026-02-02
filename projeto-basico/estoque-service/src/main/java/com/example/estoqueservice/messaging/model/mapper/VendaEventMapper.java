package com.example.estoqueservice.messaging.model.mapper;

import com.example.estoqueservice.data.venda.model.Venda;
import com.example.estoqueservice.messaging.model.VendaEvent;
import org.springframework.stereotype.Component;

@Component
public class VendaEventMapper {
    public Venda toDomain(VendaEvent vendaEvent){
        return Venda.builder()
                .nomeItem(vendaEvent.getNomeItem())
                .quantidade(vendaEvent.getQuantidade())
                .build();
    }
}
