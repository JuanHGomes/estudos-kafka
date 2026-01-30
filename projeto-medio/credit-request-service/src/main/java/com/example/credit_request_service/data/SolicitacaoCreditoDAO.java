package com.example.credit_request_service.data;

import com.example.credit_request_service.data.model.SolicitacaoCreditoDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface SolicitacaoCreditoDAO extends MongoRepository<SolicitacaoCreditoDocument, String> {
}
