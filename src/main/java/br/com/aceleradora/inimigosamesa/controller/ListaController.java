package br.com.aceleradora.inimigosamesa.controller;

import br.com.aceleradora.inimigosamesa.dao.AlimentoDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.Collections;


@Controller
public class ListaController {


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String listar(Model model) {

        AlimentoDAO alimentodao = new AlimentoDAO();

        model.addAttribute("lists", alimentodao.alimentos);

        return "lista";
    }

    @RequestMapping(value = "/", method = RequestMethod.POST)
    public String listar_POST(Model model, @RequestParam(value = "opcao-ordenar", required = false) String tipoOrdenar) {

        AlimentoDAO alimentodao = new AlimentoDAO();

        if (tipoOrdenar != null) {
            if (tipoOrdenar.equals("cre")) {
                Collections.sort(alimentodao.alimentos);
            }
        }

        if (tipoOrdenar != null) {
            if (tipoOrdenar.equals("decre")) {
                Collections.sort(alimentodao.alimentos);
                Collections.reverse(alimentodao.alimentos);
            }
        }

        model.addAttribute("lists", alimentodao.alimentos);

        return "lista";
    }
}
