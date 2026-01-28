package com.example.vendas_service.api.model;

import lombok.Builder;

@Builder
public record VendaResponse(
        String id,
        String nomeItem,
        Long quantidade
){
}
