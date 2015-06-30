package br.com.aceleradora.inimigosamesa.dao;

import br.com.aceleradora.inimigosamesa.model.Alimento;
import br.com.aceleradora.inimigosamesa.model.Categoria;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AlimentoRepository extends CrudRepository<Alimento, Integer> {

    List<Alimento> findByNomeLikeIgnoreCase(String nome, Sort ordenacao);

    List<Alimento> findByCategoria(Categoria categoria, Sort ordenacao);

    List<Alimento> findAll(Sort sort);
}
