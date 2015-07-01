package br.com.aceleradora.inimigosamesa.dao;

import br.com.aceleradora.inimigosamesa.model.Alimento;
import br.com.aceleradora.inimigosamesa.model.Categoria;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AlimentoRepository extends JpaRepository<Alimento, Integer> {

    Page<Alimento> findByNomeLikeIgnoreCase(String nome, Pageable paginacao);

    List<Alimento> findByNomeLikeIgnoreCase(String nome);

    Page<Alimento> findByCategoria(Categoria categoria, Pageable paginacao);

}
