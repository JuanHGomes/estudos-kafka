package com.example.vendas_service.api.mapper;

import com.example.vendas_service.api.model.VendaRequest;
import com.example.vendas_service.api.model.VendaResponse;
import com.example.vendas_service.data.model.Venda;
import org.springframework.stereotype.Component;

@Component
public class VendaApiMapper {
    public Venda toDomain(VendaRequest request){
        return Venda.builder()
                .nomeItem(request.nomeItem())
                .quantidade(request.quantidade())
                .build();
    }

    public VendaResponse toResponse(Venda venda){
        return VendaResponse.builder()
                .id(venda.getId())
                .nomeItem(venda.getNomeItem())
                .quantidade(venda.getQuantidade())
                .build();
    }

}
