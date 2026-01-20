package com.example.estoqueservice.data.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.Getter;
import org.springframework.data.annotation.Id;

@Getter
@Entity
public class Item {
    @Id
    private String id;

    @Column(unique = true)
    private String name;

    private Long quantidade;

}
