package com.example.vendas_service.data.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Venda {
    private String id;
    private String nomeItem;
    private Long quantidade;
}
