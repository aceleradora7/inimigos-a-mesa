package br.com.aceleradora.inimigosamesa.controller;

import br.com.aceleradora.inimigosamesa.model.Email;
import br.com.aceleradora.inimigosamesa.model.Formulario;
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

        Formulario formulario = new Formulario();
        model.addAttribute("formulario", formulario);

        return "contato";
    }

    @RequestMapping(value = "/contato", method = RequestMethod.POST)
    public String enviaContato(@ModelAttribute(value="formulario") Formulario formulario,
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
            email.enviar(formulario);
            model.addAttribute("sucesso", "E-mail enviado com sucesso!");
        }
        else
        {
            model.addAttribute("erroCaptcha", "Por favor verifique se você não é um robô.");
        }
        return "contato";
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

}