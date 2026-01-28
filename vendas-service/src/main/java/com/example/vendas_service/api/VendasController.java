package com.example.vendas_service.api;

import com.example.vendas_service.api.mapper.VendaApiMapper;
import com.example.vendas_service.api.model.VendaRequest;
import com.example.vendas_service.api.model.VendaResponse;
import com.example.vendas_service.business.VendasService;
import com.example.vendas_service.data.model.Venda;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/vendas")
public class VendasController {
    private final VendasService vendaService;
    private final VendaApiMapper mapper;

    @PostMapping()
    public ResponseEntity<VendaResponse> novaVenda(@RequestBody VendaRequest request){
        Venda novaVenda = mapper.toDomain(request);
        VendaResponse vendaResponse =  mapper.toResponse(vendaService.novaVenda(novaVenda));

        return ResponseEntity.ok().body(vendaResponse);
    }
}
