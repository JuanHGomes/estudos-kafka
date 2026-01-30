package com.example.credit_request_service.api;

import com.example.credit_request_service.api.model.SolicitacaoCreditoRequest;
import com.example.credit_request_service.api.model.SolicitacaoCreditoResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/solicitacao")
public class SolicitacaoCreditoController {

    public ResponseEntity<SolicitacaoCreditoResponse> novaSolicitacao(SolicitacaoCreditoRequest request){
    }
}
