package com.example.vendasservice.data.venda;

import com.example.vendasservice.data.venda.model.VendaDocument;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface VendaDAO extends MongoRepository<VendaDocument, ObjectId> {
}
