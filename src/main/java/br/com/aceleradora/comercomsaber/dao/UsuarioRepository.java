package br.com.aceleradora.comercomsaber.dao;

import br.com.aceleradora.comercomsaber.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Integer> {

    List<Usuario> findAll();
    Usuario findOneByEmail(String email);
    Usuario findOneByCodigo(int codigo);

}