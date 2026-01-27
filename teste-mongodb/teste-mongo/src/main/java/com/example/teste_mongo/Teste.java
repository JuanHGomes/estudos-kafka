package com.example.teste_mongo;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "teste")
public class Teste {
    @Id
    private String id;
}
