package controller;

import DAO.AlimentoDAO;
import model.Alimento;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;


@Controller
public class BuscaController {

    @RequestMapping(value = "/busca", method = RequestMethod.GET)
    public String busca(Alimento alimento) {
        return "busca";
    }

    @RequestMapping(value = "/busca", method = RequestMethod.POST)
    public String populaAlimento(Alimento alimento, BindingResult bindingResult, Model model) {

        AlimentoDAO adao = new AlimentoDAO();
        List<Alimento> resultadoBusca = adao.find(alimento);
        for (Alimento a : resultadoBusca){
            System.out.println(a.getNomeAlimento() + "cotroller");
        }
        model.addAttribute("resultadoBusca", resultadoBusca);

        return "busca";

    }

}
