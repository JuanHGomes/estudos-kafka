package com.example.teste_mongo;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teste")
@RequiredArgsConstructor
public class TesteController {
    private final TesteDAO dao;
    @PostMapping()
    public ResponseEntity<Void> teste(){
        dao.save(new Teste());
        return ResponseEntity.ok().build();
    }
}
