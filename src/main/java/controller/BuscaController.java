package controller;

import model.Alimento;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class BuscaController {


    @RequestMapping(value="/busca", method=RequestMethod.GET)
    public String busca(Alimento alimento) {
        return "busca";
    }


    @RequestMapping(value="/busca", method=RequestMethod.POST)
    public String populaAlimento(Alimento alimento, BindingResult bindingResult, Model model) {

        //Buscar no AlimentoDao

        return "busca";

    }

}
