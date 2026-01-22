package com.example.vendasservice.api;

import com.example.vendasservice.business.VendasService;
import com.example.vendasservice.messaging.model.VendaEvent;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/vendas")
public class VendasController {

    private final VendasService vendasService;

    @PostMapping()
    public ResponseEntity<Void> realizarVenda(@RequestBody VendaEvent venda){
        vendasService.novaVenda(venda);
        return ResponseEntity.ok().build();
    }
}
