package com.example.teste_mongo;

import org.springframework.data.mongodb.repository.MongoRepository;

public interface TesteDAO extends MongoRepository<Teste, String> {
}
