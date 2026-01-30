package com.example.vendas_service.data;

import com.example.vendas_service.data.mapper.VendaRepositoryMapper;
import com.example.vendas_service.data.model.Venda;
import com.example.vendas_service.data.model.VendaDocument;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class VendasRepository {

    private final VendasDAO dao;
    private final VendaRepositoryMapper mapper;

    public Venda salvarNovaVenda(Venda venda){

        VendaDocument vendaDocument = dao.save(mapper.toDocument(venda));
        Venda vendaSalva = mapper.toDomain(vendaDocument);

        return vendaSalva;
    }
}
