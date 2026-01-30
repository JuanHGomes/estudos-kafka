package com.example.vendas_service.api.model;

import java.time.LocalDate;

public record VendaRequest(
        String codigo,
        Long quantidade,
        LocalDate dataEntrega
) {
}
