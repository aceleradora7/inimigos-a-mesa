package br.com.aceleradora.inimigosamesa.dao;

import br.com.aceleradora.inimigosamesa.model.Usuario;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by aluno02 on 13/07/15.
 */
public interface UsuarioRepository extends CrudRepository<Usuario, Integer> {

    List<Usuario> findAll();

}
