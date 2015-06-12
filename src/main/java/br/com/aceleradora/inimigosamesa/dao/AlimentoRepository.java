package br.com.aceleradora.inimigosamesa.dao;

import br.com.aceleradora.inimigosamesa.model.Alimento;
import org.springframework.data.repository.CrudRepository;

public interface AlimentoRepository extends CrudRepository<Alimento, Integer> {
}
