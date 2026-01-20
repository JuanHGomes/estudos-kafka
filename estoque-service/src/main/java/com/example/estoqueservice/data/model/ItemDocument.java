package com.example.estoqueservice.data.model;

import lombok.experimental.FieldNameConstants;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;


@FieldNameConstants
@Document(collection = "estoque")
public class ItemDocument {
    @Id
    private String id;

    @Indexed(unique = true)
    private String name;

    private Long quantidade;

}
