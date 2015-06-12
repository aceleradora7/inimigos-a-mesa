package br.com.aceleradora.inimigosamesa.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by aluno03 on 10/06/15.
 */
@Controller
public class DetalheDoProdutoController {
    @RequestMapping("/detalheDoProduto")
    public String detalheDoProduto(){
        return "detalheDoProduto";
    }
}
