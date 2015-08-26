package br.com.aceleradora.comercomsaber.service;

import br.com.aceleradora.comercomsaber.dao.UsuarioRepository;
import br.com.aceleradora.comercomsaber.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository repositorioUsuario;

    public List<Usuario> buscaTodos(){
        return repositorioUsuario.findAll();
    }

    public void salvar(Usuario usuario) {
        repositorioUsuario.save(usuario);
    }

    public Usuario buscaPorEmail(String email){
        return repositorioUsuario.findOneByEmail(email);
    }

    public Usuario buscaPorCodigo(int codigo){
        return repositorioUsuario.findOneByCodigo(codigo);
    }

    public void deletar(Usuario usuario) { repositorioUsuario.delete(usuario);}
}
