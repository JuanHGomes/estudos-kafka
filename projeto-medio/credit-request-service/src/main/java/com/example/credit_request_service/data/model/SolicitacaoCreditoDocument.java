package com.example.credit_request_service.data.model;

import lombok.Builder;
import lombok.Getter;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDate;

@Builder
@Getter
@Document(collection = "solicitacoes")
public class SolicitacaoCreditoDocument {
    private String id;
    private SolicitacaoCredito.Cliente cliente;
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
