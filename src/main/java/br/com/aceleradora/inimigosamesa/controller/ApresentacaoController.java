package br.com.aceleradora.inimigosamesa.controller;

import br.com.aceleradora.inimigosamesa.model.Alimento;
import br.com.aceleradora.inimigosamesa.model.Email;
import br.com.aceleradora.inimigosamesa.model.FormularioEmail;
import br.com.aceleradora.inimigosamesa.model.RecaptchaResult;
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
    public String home(){ return "home"; }

    @RequestMapping("/home")
    public String home2(){
        return "home";
    }

    @RequestMapping("/home3")
    public String home3(){
        return "home3";
    }

    @RequestMapping("/sobre")
    public String sobre(){
        return "sobre";
    }

    @RequestMapping("/sobre2")
    public String sobre2(){
        return "sobre2";
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

        return "contato";
    }


}