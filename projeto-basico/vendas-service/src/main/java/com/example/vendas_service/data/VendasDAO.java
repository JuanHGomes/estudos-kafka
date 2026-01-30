package com.example.vendas_service.data;

import com.example.vendas_service.data.model.VendaDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VendasDAO extends MongoRepository<VendaDocument, String> {
}
