package br.com.aceleradora.inimigosamesa.dao;

import br.com.aceleradora.inimigosamesa.model.Alimento;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface AlimentoRepository extends CrudRepository<Alimento, Integer> {


    List<Alimento> findByNomeLikeIgnoreCase(String nome);

    @Query(value = "SELECT * FROM alimento WHERE lower(unaccent(nome)) LIKE lower(unaccent(:busca));", nativeQuery = true)
    List<Alimento> buscaAlimentoPorNomeSemAcentos(@Param(value = "busca") String busca);
}
