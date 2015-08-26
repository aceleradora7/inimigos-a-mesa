package br.com.aceleradora.comercomsaber.service;

import br.com.aceleradora.comercomsaber.dao.CategoriaRepository;
import br.com.aceleradora.comercomsaber.model.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public List<Categoria> buscaPorNome(String nome) {
        return categoriaRepository.findByNome(nome);
    }

    public Iterable<Categoria> buscaTodos(Sort sort){
        return categoriaRepository.findAll(sort);
    }

}
