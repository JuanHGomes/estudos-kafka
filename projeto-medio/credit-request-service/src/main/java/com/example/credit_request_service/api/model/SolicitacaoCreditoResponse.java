package com.example.credit_request_service.api.model;

import com.example.credit_request_service.data.model.SolicitacaoCredito;
import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;

public class SolicitacaoCreditoResponse {
    private String id;
    private Cliente cliente;
    private String contaDeposito;
    private LocalDate dataSolicitacao;
    private BigDecimal valorCredito;

    @Builder
    @Getter
    public class Cliente{
        private String nome;
        private String Cpf;
    }
}
