package com.example.vendasservice.api.model;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record VendaRequest(
        @NotEmpty String nomeItem,
        @NotNull Long quantidade
        ) {
}
