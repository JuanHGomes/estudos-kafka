package com.example.estoqueservice.data.estoque.repository;


import com.example.estoqueservice.data.estoque.model.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EstoqueRepository extends JpaRepository<Item, String>{
    Optional<Item> findByName(String name);

    @Modifying
    @Query("update Item i set i.quantidade = i.quantidade - :quantidade where i.id = :id and i.quantidade >= :quantidade")
    int diminuirEstoque(@Param("id")String id, @Param("quantidade")Long quantidade);
}
