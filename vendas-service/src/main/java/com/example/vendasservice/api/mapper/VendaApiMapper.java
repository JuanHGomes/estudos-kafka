package com.example.vendasservice.api.mapper;

import com.example.vendasservice.api.model.VendaRequest;
import com.example.vendasservice.data.venda.model.Venda;
import org.springframework.stereotype.Component;

@Component
public final class VendaApiMapper {
    public Venda toDomain(VendaRequest request){
       return Venda.builder()
               .nomeItem(request.nomeItem())
               .quantidade(request.quantidade())
               .build();
    }
}
