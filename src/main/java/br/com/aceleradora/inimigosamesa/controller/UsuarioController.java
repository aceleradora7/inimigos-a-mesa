package br.com.aceleradora.inimigosamesa.controller;

import br.com.aceleradora.inimigosamesa.model.Usuario;
import br.com.aceleradora.inimigosamesa.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by aluno02 on 22/07/15.
 */
@Controller
public class UsuarioController {

    @Autowired
    private UsuarioService servicoUsuario;

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "login";
    }


    @RequestMapping(value = "/recuperarSenha")
    public void recuperarSenha() {

    }

    @RequestMapping(value = "/emailRecuperar", method = RequestMethod.POST)
    public String emailRecuperarSenha() {

        return "login";

    }

    @RequestMapping(value = "/emailRecuperar", method = RequestMethod.GET)
    public String emailRecuperar() {

        return "login";

    }


    @RequestMapping(value = "/formularioUsuario", method = RequestMethod.GET)
    public String cadastrarNovoAdministrador(Model model){
        Usuario usuario = new Usuario();
        model.addAttribute("usuario", usuario);

        return "formularioUsuario";
    }

    @RequestMapping(value = "/formularioUsuario", method = RequestMethod.POST)
    public String gererenciarUsuario(Model model, Usuario usuario){
        servicoUsuario.salvar(usuario);
        return "redirect:/index";
    }

    @RequestMapping(value = "/formularioDeletarUsuario")
    public void buscarTodosUsuarios(Model model) {
        List<Usuario> usuarios = servicoUsuario.buscaTodos();
        model.addAttribute("usuarios", usuarios);
    }
}
