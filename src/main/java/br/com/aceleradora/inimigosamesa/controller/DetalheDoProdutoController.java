package br.com.aceleradora.inimigosamesa.controller;

import br.com.aceleradora.inimigosamesa.dao.AlimentoDAO;
import br.com.aceleradora.inimigosamesa.dao.AlimentoRepository;
import br.com.aceleradora.inimigosamesa.model.Alimento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Collections;
import java.util.List;

@Controller
public class DetalheDoProdutoController {

    @RequestMapping(value = "/detalheDoProduto")
    public String listar(Model model, @RequestParam(value = "nomeAlimento", required = false) String nome) {

        Alimento a = new Alimento();
        a.setnomeAlimento(nome);

        AlimentoDAO adao = new AlimentoDAO();
        List<Alimento> lista= adao.find(a);

        model.addAttribute("alimento", lista.get(0));

        return "detalheDoProduto";
    }

}
