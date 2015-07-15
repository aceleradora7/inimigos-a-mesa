package br.com.aceleradora.inimigosamesa.service;

import br.com.aceleradora.inimigosamesa.dao.UsuarioRepository;
import br.com.aceleradora.inimigosamesa.model.Usuario;
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
}
