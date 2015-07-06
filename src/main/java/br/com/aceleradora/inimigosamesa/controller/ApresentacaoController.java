package br.com.aceleradora.inimigosamesa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

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

}