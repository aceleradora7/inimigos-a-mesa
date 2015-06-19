package br.com.aceleradora.inimigosamesa.dao;

import br.com.aceleradora.inimigosamesa.model.Alimento;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AlimentoRepository extends CrudRepository<Alimento, Integer> {
    
    List<Alimento> findByNomeLikeIgnoreCase(String nome);
}
