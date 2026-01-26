package com.example.vendasservice.data.venda;

import com.example.vendasservice.data.venda.mapper.VendaRepositoryMapper;
import com.example.vendasservice.data.venda.model.Venda;
import com.example.vendasservice.data.venda.model.VendaDocument;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@RequiredArgsConstructor
@Repository
public class VendaRepository {

    private final VendaDAO dao;
    private final VendaRepositoryMapper mapper;

    public void salvar(Venda venda){
        VendaDocument vendaDocument = mapper.toDocument(venda);

        dao.save(vendaDocument);
    }
}
