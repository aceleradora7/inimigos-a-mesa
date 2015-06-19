package br.com.aceleradora.inimigosamesa.controller;

import br.com.aceleradora.inimigosamesa.dao.AlimentoRepository;
import br.com.aceleradora.inimigosamesa.dao.CategoriaRepository;
import br.com.aceleradora.inimigosamesa.model.Alimento;
import br.com.aceleradora.inimigosamesa.model.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AlimentoController {

    @Autowired
    private AlimentoRepository repositorioAlimento;

    @Autowired
    private CategoriaRepository repositorioCategoria;



    @RequestMapping(value = "/lista", method = RequestMethod.GET)
    public String listar(
            @RequestParam(value = "opcao-ordenar", required = false, defaultValue = "cre") String tipoDeOrdenacao,
            Alimento alimento,
            Model model) {

        model.addAttribute("alimentos", repositorioAlimento.findAll());

        return "lista";
    }


    @RequestMapping(value = "/busca", method = RequestMethod.GET)
    public String busca(Alimento alimento, Model model) {


        List<Alimento> alimentosBanco = repositorioAlimento.findByNome(alimento.getNome());

        if (!alimentosBanco.isEmpty()) {
            model.addAttribute("alimentos", alimentosBanco);
        } else {
            model.addAttribute("erro", "Nenhum alimento encontrado!");
        }

        return "lista";
    }

    @RequestMapping(value = "/buscaCategoria", method = RequestMethod.GET)
    public String buscaPorCategoria(@RequestParam(value = "categoria") String nome, Model model) {
        model.addAttribute("alimento", new Alimento());

        Categoria categoria = repositorioCategoria.findFirstByNomeLikeIgnoreCase(nome);

        if(categoria == null){
            model.addAttribute("erro", "Nenhuma categoria encontrada!");
            return "lista";
        }

        List<Alimento> alimentosCategoria = categoria.getAlimentos();

        if(alimentosCategoria.isEmpty()){
            model.addAttribute("erro", "Nenhum alimento encontrado!");
            return "lista";
        }

        model.addAttribute("alimentos", alimentosCategoria);
        return "lista";
    }

    @RequestMapping(value = "/detalhe")
    public String detalhe(Model model, @RequestParam(value = "nomeAlimento", required = false) String nome){

        List<Alimento> lista= repositorioAlimento.findByNome(nome);

        model.addAttribute("alimento", lista.get(0));

        return "detalhe";
    }
}