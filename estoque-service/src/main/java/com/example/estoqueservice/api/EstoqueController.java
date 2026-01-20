package com.example.estoqueservice.api;

import com.example.estoqueservice.business.model.Item;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/estoque")
public class EstoqueController {

    private static final EstoqueService estoqueService;

    public ResponseEntity<Void> retirarItem(Item item, Long quantidade){

    }
}
