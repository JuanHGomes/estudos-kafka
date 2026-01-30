package com.example.credit_request_service.business;

import com.example.credit_request_service.data.SolicitacaoCreditoRepository;
import com.example.credit_request_service.data.model.SolicitacaoCredito;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class SolicitacaoCreditoService {
    private final SolicitacaoCreditoRepository solicitacaoCreditoRepository;

    public void processarNovaSolicitacao(SolicitacaoCredito solicitacao){

        solicitacaoCreditoRepository.salvarSolicitacao(solicitacao);

    }
}
