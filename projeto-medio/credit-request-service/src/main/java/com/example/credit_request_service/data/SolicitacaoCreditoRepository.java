package com.example.credit_request_service.data;

import com.example.credit_request_service.data.model.SolicitacaoCredito;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class SolicitacaoCreditoRepository {
    private final SolicitacaoCreditoDAO dao;
    private final

    public void salvarSolicitacao(SolicitacaoCredito solicitacao) {

        return dao.save(solicitacao);
    }
}
