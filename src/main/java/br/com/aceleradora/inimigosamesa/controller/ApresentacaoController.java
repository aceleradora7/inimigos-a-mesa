package br.com.aceleradora.inimigosamesa.controller;

import br.com.aceleradora.inimigosamesa.model.RecaptchaResult;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.client.RestTemplate;
import org.springframework.ui.Model;

@Controller
public class ApresentacaoController {

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

    @RequestMapping("/contato")
    public String contato(){
        return "contato";
    }

    @RequestMapping(value = "/contato", method = RequestMethod.POST)
    public String enviaContato(@RequestParam(value="g-recaptcha-response",required = true) String response, Model model){
        StringBuilder builder = new StringBuilder();
        builder.append("https://www.google.com/recaptcha/api/siteverify");
        builder.append("?secret=");
        builder.append("6Lf3XAkTAAAAALT5KTgNMygdZg7Bo-lO0p_RcO48");
        builder.append("&response=");
        builder.append(response);
        RestTemplate restTemplate = new RestTemplate();
        RecaptchaResult resultado = restTemplate.getForObject(builder.toString(), RecaptchaResult.class);
        if(resultado.success) {
            //ok
        }
        else
        {
            model.addAttribute("erroCaptcha", true);
        }
        return "contato";
    }

}