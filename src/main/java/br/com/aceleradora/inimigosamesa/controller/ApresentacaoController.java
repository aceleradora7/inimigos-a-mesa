package br.com.aceleradora.inimigosamesa.controller;

import br.com.aceleradora.inimigosamesa.model.Alimento;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ApresentacaoController {

    @RequestMapping("/")
    public String home(Alimento alimento){
        return "index";
    }

    public String sobre(){
        return "sobre";
    }

    public String tutorial(){
        return "tutorial";
    }

}
