package com.example.credit_request_service.data.mapper;

import com.example.credit_request_service.data.model.SolicitacaoCredito;
import com.example.credit_request_service.data.model.SolicitacaoCreditoDocument;
import org.springframework.stereotype.Component;

@Component
public class SolicitacaoCreditoRepositoryMapper {

    public SolicitacaoCreditoDocument toDocument(SolicitacaoCredito solicitacao){
        return SolicitacaoCreditoDocument.builder()
                .cliente(solicitacao.getCliente())
                .contaDepotio(solicitacao.getContaDepotio())
                .dataSolicitacao(solicitacao.getDataSolicitacao())
                .
    }
}
