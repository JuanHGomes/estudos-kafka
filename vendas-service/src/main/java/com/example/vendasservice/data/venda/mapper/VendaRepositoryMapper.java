package com.example.vendasservice.data.venda.mapper;

import com.example.vendasservice.data.venda.model.Venda;
import com.example.vendasservice.data.venda.model.VendaDocument;
import org.springframework.stereotype.Component;

@Component
public class VendaRepositoryMapper {
    public VendaDocument toDocument(Venda venda){
        return VendaDocument.builder()
                .nomeItem(venda.getNomeItem())
                .quantidade(venda.getQuantidade())
                .build();
    }
}
