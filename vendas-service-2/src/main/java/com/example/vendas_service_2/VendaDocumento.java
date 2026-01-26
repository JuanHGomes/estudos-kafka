package com.example.vendas_service_2;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "vendas")
public class VendaDocumento {
    @Id
    private String id;
    private String nomeItem;
    private Long quantidade;

    public VendaDocumento(String nomeItem, Long quantidade) {
        this.nomeItem = nomeItem;
        this.quantidade = quantidade;
    }
}
