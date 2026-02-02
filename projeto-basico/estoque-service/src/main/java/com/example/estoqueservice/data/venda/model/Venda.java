package com.example.estoqueservice.data.venda.model;

import com.example.estoqueservice.business.enums.MotivoRecusa;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Venda {
    private String nomeItem;
    private Long quantidade;
    private MotivoRecusa motivoRecusa;
}
