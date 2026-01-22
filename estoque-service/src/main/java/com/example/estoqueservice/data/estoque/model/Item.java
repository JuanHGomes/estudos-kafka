package com.example.estoqueservice.data.estoque.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
@NoArgsConstructor
@Entity
public class Item {
    @Id
    private String id;

    @Column(unique = true)
    private String name;

    private Long quantidade;
}