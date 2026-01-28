package com.example.vendas_service.data.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
@Builder
@Document(collection = "vendas")
public class VendaDocument {
    @Id
    private String id;
    @Indexed(unique = true)
    private String nomeItem;
    private Long quantidade;
}
