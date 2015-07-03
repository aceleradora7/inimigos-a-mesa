package br.com.aceleradora.inimigosamesa.service;

import br.com.aceleradora.inimigosamesa.dao.CategoriaRepository;
import br.com.aceleradora.inimigosamesa.model.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

@Service
public class CategoriaService {

    @Autowired
    private CategoriaRepository categoriaRepository;

    public Iterable<Categoria> buscaTodos(Sort sort){
        return categoriaRepository.findAll(sort);
    }


}
