package com.example.vendasservice.api;

import com.example.vendasservice.api.mapper.VendaApiMapper;
import com.example.vendasservice.api.model.VendaRequest;
import com.example.vendasservice.business.VendasService;
import com.example.vendasservice.data.venda.model.Venda;
import com.example.vendasservice.messaging.model.VendaEvent;
import jakarta.validation.Valid;
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
    private final VendaApiMapper mapper;

    @PostMapping()
    public ResponseEntity<Void> realizarVenda(@RequestBody @Valid VendaRequest vendaEvent){
        Venda venda = mapper.toDomain(vendaEvent);
        vendasService.novaVenda(venda);
        return ResponseEntity.ok().build();
    }
}
