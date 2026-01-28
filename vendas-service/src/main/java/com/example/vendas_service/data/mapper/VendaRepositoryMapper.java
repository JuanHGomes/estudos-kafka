package com.example.vendas_service.data.mapper;

import com.example.vendas_service.data.model.Venda;
import com.example.vendas_service.data.model.VendaDocument;
import org.springframework.stereotype.Component;

@Component
public class VendaRepositoryMapper {
    public Venda toDomain(VendaDocument document){
        return Venda.builder()
                .id(document.getId())
                .nomeItem(document.getNomeItem())
                .quantidade(document.getQuantidade())
                .build();
    }

    public VendaDocument toDocument(Venda venda){
        return VendaDocument.builder()
                .nomeItem(venda.getNomeItem())
                .quantidade(venda.getQuantidade())
                .build();
    }
}
