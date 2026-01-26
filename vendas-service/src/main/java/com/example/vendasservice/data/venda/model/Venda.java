package com.example.vendasservice.data.venda.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Venda {
    private String nomeItem;
    private Long quantidade;
}
