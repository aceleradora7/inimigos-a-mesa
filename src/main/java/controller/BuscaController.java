package controller;

import DAO.AlimentoDAO;
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

        AlimentoDAO adao = new AlimentoDAO();
        Alimento abusca = adao.find(alimento);

        if(abusca!=null) {
            model.addAttribute("nome", "Nome: "+ abusca.getNomeAlimento());
            model.addAttribute("acucar", "Açucar: "+ abusca.getQuantidadeAcucarGramas());
            model.addAttribute("sodio", "Sódio: "+ abusca.getQuantidadeSodioMiligramas());
            model.addAttribute("gordura", "Gordura: "+ abusca.getQuantidadeGorduraGramas());
        }else{
            model.addAttribute("nome", "Alimento não encontrado!");
        }
        return "busca";

    }

}
