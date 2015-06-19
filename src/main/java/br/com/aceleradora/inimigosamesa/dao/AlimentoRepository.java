package br.com.aceleradora.inimigosamesa.dao;

import br.com.aceleradora.inimigosamesa.model.Alimento;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface AlimentoRepository extends CrudRepository<Alimento, Integer> {

    List<Alimento> findByNomeLikeIgnoreCase(String nome);
}
