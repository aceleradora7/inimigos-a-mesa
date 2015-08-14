package br.com.aceleradora.inimigosamesa.dao;

import br.com.aceleradora.inimigosamesa.model.Categoria;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoriaRepository extends CrudRepository<Categoria, Integer>{

    @Query(Consultas.Categoria.FIND_BY_NOME)
    List<Categoria> findByNome(@Param("nome") String nome);

    List<Categoria> findAll(Sort sort);
}