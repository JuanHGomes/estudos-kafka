package com.example.vendas_service.api.model;

public record VendaRequest(
        String nomeItem,
        Long quantidade
) {
}
