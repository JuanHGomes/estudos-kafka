package com.example.estoqueservice.api;

import com.example.estoqueservice.business.EstoqueService;
import com.example.estoqueservice.business.model.Item;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/estoque")
public class EstoqueController {

    private final EstoqueService estoqueService;

    @PostMapping("/retirar/{nomeItem}/{quantidade}")
    public void retirarItem(@PathVariable String nomeItem, @PathVariable Long quantidade){
        return estoqueService.retiratItem(nomeItem, quantidade);
    }
}
