package com.example.vendas_service_2;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/vendas")
public class VendasController {

    private final VendasDAO dao;

    public VendasController(VendasDAO dao){
        this.dao = dao;
    }

    @PostMapping()
    public ResponseEntity<Void> novaVenda(){

        dao.save(new VendaDocumento("teste", 1L));
        return ResponseEntity.ok().build();
    }
}
