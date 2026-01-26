package com.example.vendasservice.data.venda.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Builder
@Getter
@Setter
@Document(collection = "vendas")
public class VendaDocument {

    @Id
    private ObjectId id;
    private String nomeItem;
    private Long quantidade;
}
