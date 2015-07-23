package br.com.aceleradora.inimigosamesa.controller;

import br.com.aceleradora.inimigosamesa.model.Email;
import br.com.aceleradora.inimigosamesa.model.FormularioEmail;
import br.com.aceleradora.inimigosamesa.model.RecaptchaResult;
import br.com.aceleradora.inimigosamesa.model.Usuario;
import br.com.aceleradora.inimigosamesa.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;

@Controller
public class ApresentacaoController {

    @Autowired
    private UsuarioService servicoUsuario;

    @RequestMapping("/")
    public String home(){
        return "index";
    }

    @RequestMapping("/sobre")
    public String sobre(){
        return "sobre";
    }

    public String tutorial(){
        return "tutorial";
    }

    @RequestMapping(value = "/contato", method = RequestMethod.GET)
    public String contato(Model model){

        FormularioEmail formularioEmail = new FormularioEmail();
        model.addAttribute("formularioEmail", formularioEmail);

        return "contato";
    }

    @RequestMapping(value = "/contato", method = RequestMethod.POST)
    public String enviaContato(@ModelAttribute(value="formularioEmail") FormularioEmail formularioEmail,
    @RequestParam(value="g-recaptcha-response",required = true) String response, Model model){

        StringBuilder builder = new StringBuilder();
        builder.append("https://www.google.com/recaptcha/api/siteverify");
        builder.append("?secret=");
        builder.append("6Lf3XAkTAAAAALT5KTgNMygdZg7Bo-lO0p_RcO48");
        builder.append("&response=");
        builder.append(response);
        RestTemplate restTemplate = new RestTemplate();
        RecaptchaResult resultado = restTemplate.getForObject(builder.toString(), RecaptchaResult.class);
        if(resultado.success) {
            Email email = new Email();
            email.enviar(formularioEmail);
            model.addAttribute("sucesso", "E-mail enviado com sucesso!");

            return "contato";

        }
        else
        {
            model.addAttribute("erroCaptcha", "Por favor verifique se você não é um robô.");
        }

        return "/contato";
    }

    @RequestMapping(value = "/login", method = RequestMethod.GET)
    public String login(Model model) {
        model.addAttribute("usuario", new Usuario());
        return "login";
    }

    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public void loginPost(Usuario usuario) {

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


}