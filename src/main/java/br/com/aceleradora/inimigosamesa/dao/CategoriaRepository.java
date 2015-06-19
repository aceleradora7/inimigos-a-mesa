package br.com.aceleradora.inimigosamesa.dao;

import br.com.aceleradora.inimigosamesa.model.Categoria;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface CategoriaRepository extends CrudRepository<Categoria, Integer>{

    public Categoria findFirstByNomeLikeIgnoreCase(@Param("nome") String nome);
}
