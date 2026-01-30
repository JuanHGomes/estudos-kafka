package com.example.credit_request_service.data.model;

import lombok.Builder;
import lombok.Getter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
@Getter
public class SolicitacaoCredito {
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
