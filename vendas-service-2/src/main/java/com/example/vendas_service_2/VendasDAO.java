package com.example.vendas_service_2;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

@Component
public interface VendasDAO extends MongoRepository<VendaDocumento, String> {
}
