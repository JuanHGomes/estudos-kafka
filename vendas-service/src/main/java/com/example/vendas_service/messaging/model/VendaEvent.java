package com.example.vendas_service.messaging.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class VendaEvent {
    private String id;
    private String nomeItem;
    private Long quantidade;
}
