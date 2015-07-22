package br.com.aceleradora.inimigosamesa.controller;

import br.com.aceleradora.inimigosamesa.model.Usuario;
import br.com.aceleradora.inimigosamesa.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

/**
 * Created by aluno02 on 22/07/15.
 */
@Controller
public class UsuarioController {

    @Autowired
    private UsuarioService servicoUsuario;

    @RequestMapping(value = "/formularioDeletarUsuario")
    public void buscarTodosUsuarios(Model model) {
        List<Usuario> usuarios = servicoUsuario.buscaTodos();
        model.addAttribute("usuarios", usuarios);
    }
}
