package br.com.aceleradora.comercomsaber.service;

import br.com.aceleradora.comercomsaber.dao.UsuarioRepository;
import br.com.aceleradora.comercomsaber.model.Usuario;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
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

    public String getNomeUsuarioLogado() {
        try {
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            Usuario usarioAtual = buscaPorEmail(user.getUsername());
            return usarioAtual.getNome();
        } catch (Exception e) {
            return "";
        }
    }

    public String getEmailUsuarioLogado() {
        try {
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            return (user.getUsername());
        } catch (Exception e) {
            return "";
        }
    }
}
