package controller;

import DAO.AlimentoDAO;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


@Controller
public class ListaController {


    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String listar(Model model) {
        AlimentoDAO adao = new AlimentoDAO();

        model.addAttribute("lists", adao.alimentos);


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
