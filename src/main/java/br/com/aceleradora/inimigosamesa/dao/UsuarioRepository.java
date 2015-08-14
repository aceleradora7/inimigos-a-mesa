package br.com.aceleradora.inimigosamesa.dao;

import br.com.aceleradora.inimigosamesa.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    List<Usuario> findAll();
    Usuario findOneByEmail(String email);
    Usuario findOneByCodigo(int codigo);

}