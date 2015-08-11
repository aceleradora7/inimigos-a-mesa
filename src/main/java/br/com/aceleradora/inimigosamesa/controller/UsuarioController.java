package br.com.aceleradora.inimigosamesa.controller;

import br.com.aceleradora.inimigosamesa.model.Email;
import br.com.aceleradora.inimigosamesa.model.Usuario;
import br.com.aceleradora.inimigosamesa.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
    public void recuperarSenha() {}

    @RequestMapping(value = "/emailRecuperar", method = RequestMethod.POST)
    public String emailRecuperarSenha(Model model, Usuario usuario) {

        Usuario usuarioBusca = servicoUsuario.buscaPorEmail(usuario.getEmail());
        if(usuarioBusca!=null) {
            Random random = new Random();
            String novaSenha = "";
            for(int i = 0; i<5;i++){
                int c = random.nextInt(26) + (byte)'a';
                novaSenha = novaSenha.concat(String.valueOf(((char) c)).concat(String.valueOf((int) (Math.random() * 9))));
            }
            usuarioBusca.setSenha(new BCryptPasswordEncoder().encode(novaSenha));
            servicoUsuario.salvar(usuarioBusca);
            usuarioBusca.setSenha(novaSenha);
            Email email = new Email();
            email.enviar(usuarioBusca);
            model.addAttribute("sucesso", "true");
        }else{
            model.addAttribute("erroEmailNaoExiste","true");
        }

        return "login";
    }

    @RequestMapping(value = "/emailRecuperar", method = RequestMethod.GET)
    public String emailRecuperar() { return "login"; }


    @RequestMapping(value = "/cadastrarUsuario", method = RequestMethod.GET)
    public String cadastrarNovoAdministrador(Model model, Usuario usuario){

        if(usuario==null){
            usuario = new Usuario();
        }
        model.addAttribute("usuario", usuario);

        return "formularioUsuario";
    }

    @RequestMapping(value = "/editarUsuario", method = RequestMethod.GET)
    public String editarAlimento(Model model) {

        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        Usuario usuario = servicoUsuario.buscaPorEmail(user.getUsername());
        model.addAttribute("usuario", usuario);

        return "formularioUsuario";
    }


    @RequestMapping(value = "/gerenciarUsuario", method = RequestMethod.POST)
    public String gererenciarUsuario(Model model, Usuario usuario){

        String validacao = validacao(model, usuario);
        if(validacao.equals("Salvar")){
            usuario.setSenha(new BCryptPasswordEncoder().encode(usuario.getSenha()));
            servicoUsuario.salvar(usuario);
            return "redirect:/";
        }else{
            return validacao;
        }
    }


    @RequestMapping(value = "/formularioDeletarUsuario", method = RequestMethod.GET)
    public String buscarTodosUsuarios(Model model) {

        List<Usuario> usuarios = servicoUsuario.buscaTodos();
        User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();

        for (int i = 0; i < usuarios.size(); i++) {
            if(usuarios.get(i).getEmail().equals(user.getUsername())){
                usuarios.remove(usuarios.get(i));
            }
        }

        model.addAttribute("usuarios", usuarios);
        model.addAttribute("usuario",new Usuario());

        return "formularioDeletarUsuario";
    }

    @RequestMapping(value = "/deletarUsuario", method = RequestMethod.GET)
    public String deletarUsuario(Model model, @RequestParam(value = "codigo", required = false) String codigo){

        Usuario usuario = servicoUsuario.buscaPorCodigo(Integer.parseInt(codigo));
        servicoUsuario.deletar(usuario);
        model.addAttribute("espacoSucessoUsuarioDeletado","true");

        return buscarTodosUsuarios(model);
    }


    public String validacao(Model model, Usuario usuario){

        if(usuario.getNome().isEmpty() || !nomeUsuario(usuario.getNome())){
            model.addAttribute("erroNome", "true");

            return cadastrarNovoAdministrador(model, usuario);
        }else{
            model.addAttribute("erroNome", null);
            if (!emailPadrao(usuario.getEmail())) {
                model.addAttribute("erroEmailPadrao", "true");

                return cadastrarNovoAdministrador(model, usuario);
            }else{
                model.addAttribute("erroEmailPadrao", null);
                Usuario usuarioPesquisado = null;

                if(usuario.getCodigo()==0){
                    usuarioPesquisado = servicoUsuario.buscaPorEmail(usuario.getEmail());
                }
                if(usuarioPesquisado!=null){
                    model.addAttribute("erroEmailExiste", "true");

                    return cadastrarNovoAdministrador(model, usuario);
                }else{
                    model.addAttribute("erroEmailExiste", null);
                    if (usuario.getSenha().length() < 4) {
                        model.addAttribute("erroSenhaTamanho", "true");

                        return cadastrarNovoAdministrador(model, usuario);
                    } else{
                        model.addAttribute("erroSenhaTamanho", null);
                        if (!usuario.getSenha().equals(usuario.getRepetirSenha())) {
                            model.addAttribute("erroSenhaDiferente", "true");

                            return cadastrarNovoAdministrador(model, usuario);
                        }else{
                            model.addAttribute("erroSenhaDiferente", null);
                        }
                    }
                }
            }
        }

        return "Salvar";
    }

    public boolean emailPadrao(String email) {
        Pattern p = Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@([\\w-]+\\.)+[a-zA-Z]{2,3}$");
        Matcher m = p.matcher(email.trim());
        if (!m.find()) {
            return false;
        }
        return true;
    }

    public boolean nomeUsuario(String nome) {
        Pattern p = Pattern.compile("^[\\p{L} \\.'\\-]+$");
        Matcher m = p.matcher(nome.trim());
        if (!m.find()) {
            return false;
        }
        return true;
    }
}
