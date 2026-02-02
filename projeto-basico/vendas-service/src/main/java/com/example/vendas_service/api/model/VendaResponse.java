package com.example.vendas_service.api.model;

import com.example.vendas_service.api.enums.MotivoRecusa;
import lombok.Builder;

@Builder
public record VendaResponse(
        String id,
        String nomeItem,
        Long quantidade,
        MotivoRecusa motivoRecusa
){
}
