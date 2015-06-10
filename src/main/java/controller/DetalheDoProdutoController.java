package controller;

import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by aluno03 on 10/06/15.
 */
public class DetalheDoProdutoController {
    @RequestMapping("/detalheDoProduto")
    public String info(){
        return "info";
    }
}
