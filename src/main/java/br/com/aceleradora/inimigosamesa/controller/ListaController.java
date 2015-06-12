package br.com.aceleradora.inimigosamesa.controller;

import br.com.aceleradora.inimigosamesa.dao.AlimentoDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;


@Controller
public class ListaController {


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String listar(Model model,
                         @RequestParam(value = "ordem-crescente", required = false) boolean ordenar,
                         @RequestParam(value = "opcao-ordenar", required = false) String tipoOrdenar) {

        AlimentoDAO alimentodao = new AlimentoDAO();

        if(ordenar){
            Collections.sort(alimentodao.alimentos);
        }

        model.addAttribute("lists", alimentodao.alimentos);

        return "lista";
    }


    /*@RequestMapping("/greeting")
    public String greeting(@RequestParam(value="name", required=false ,defaultValue="World") String name, Model model){
        model.addAttribute("name", name);
        return "greeting";
    }

    @RequestMapping("/informacao")
    public String info(){
        return "info";
    }*/



}
