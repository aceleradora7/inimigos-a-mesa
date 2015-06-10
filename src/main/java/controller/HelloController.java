package controller;

import DAO.AlimentoDAO;
import model.Alimento;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import javax.validation.Valid;


@Controller
public class HelloController {

    @RequestMapping("/")
    public String index(){
        return "index";
    }

    @RequestMapping("/greeting")
    public String greeting(@RequestParam(value="name", required=false ,defaultValue="World") String name, Model model){
        model.addAttribute("name", name);
        return "greeting";
    }

    @RequestMapping("/informacao")
    public String info(){
        return "info";
    }

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
