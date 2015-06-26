package br.com.aceleradora.inimigosamesa.controller;

import br.com.aceleradora.inimigosamesa.dao.AlimentoRepository;
import br.com.aceleradora.inimigosamesa.dao.CategoriaRepository;
import br.com.aceleradora.inimigosamesa.model.Alimento;
import br.com.aceleradora.inimigosamesa.model.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Collections;
import java.util.List;

@Controller
public class AlimentoController {

    private static final String ORDENACAO_CRESCENTE = "cre";
    private static final String ORDENACAO_DECRESCENTE = "decre";

    @Autowired
    private AlimentoRepository repositorioAlimento;

    @Autowired
    private CategoriaRepository repositorioCategoria;


    @RequestMapping(value = "/lista", method = RequestMethod.GET)
    public String listar(
            @RequestParam(value = "opcao-ordenar", required = false, defaultValue = ORDENACAO_CRESCENTE) String tipoDeOrdenacao,
            @RequestParam(value = "categoria", required = false, defaultValue = "0") int categoria,
            Alimento alimento,
            Model model) {

        List<Alimento> alimentos;

        alimentos = (List) ((categoria == 0) ? repositorioAlimento.findAll() :
                    repositorioCategoria.findOne(categoria).getAlimentos());

        ordenar(alimentos, tipoDeOrdenacao);

        model.addAttribute("alimentos", alimentos);

        return "lista";
    }


    @RequestMapping(value = "/busca", method = RequestMethod.GET)
    public String busca(Alimento alimento, Model model) {

        List<Alimento> alimentosBanco = repositorioAlimento.findByNomeLikeIgnoreCase(alimento.getNome() + "%");

        if (!alimentosBanco.isEmpty()) {
            model.addAttribute("alimentos", alimentosBanco);
        } else {
            model.addAttribute("erro", "Nenhum alimento encontrado!");
        }

        return "lista";
    }

    @RequestMapping(value = "/buscaCategoria", method = RequestMethod.GET)
    public String buscaPorCategoria(@RequestParam(value = "categoria") String parametros,
                                    Model model) {
        model.addAttribute("alimento", new Alimento());

        String divideparametros[] = parametros.split("-");

        Categoria categoria = repositorioCategoria.findOne(Integer.parseInt(divideparametros[0]));


        if (categoria == null) {
            model.addAttribute("erro", "Nenhuma categoria encontrada!");
            return "lista";
        }

        List<Alimento> alimentosCategoria = categoria.getAlimentos();

        ordenar(alimentosCategoria, divideparametros[1]);

        if (alimentosCategoria.isEmpty()) {
            model.addAttribute("erro", "Nenhum alimento encontrado!");
            return "lista";
        }

        model.addAttribute("alimentos", alimentosCategoria);
        return "lista";
    }


    @RequestMapping(value = "/detalhe/{codigo}")
    public String detalhe(Model model, @PathVariable("codigo") int codigo) {

        Alimento alimento = repositorioAlimento.findOne(codigo);
        legendar(alimento);
        model.addAttribute("alimento", alimento);

        return "detalhe";
    }


    private void ordenar(List<Alimento> alimentos, String tipoDeOrdenacao) {

        Collections.sort(alimentos);

        if (tipoDeOrdenacao.equals(ORDENACAO_DECRESCENTE)) {
            Collections.reverse(alimentos);
        }
    }

    private void legendar(Alimento alimento) {
        alimento.setCalorias(traduzirLegenda(alimento.getCalorias(), Alimento.CALORIAS));
        alimento.setAcucarGramas(traduzirLegenda(alimento.getAcucarGramas(), Alimento.GRAMAS));
        alimento.setSodioMiligramas(traduzirLegenda(alimento.getSodioMiligramas(), Alimento.MILIGRAMAS));
        alimento.setGorduraGramas(traduzirLegenda(alimento.getGorduraGramas(), Alimento.GRAMAS));
    }

    private String traduzirLegenda(String valor, String unidadeDeMedida) {

        if (valor == null) {
            return Alimento.NAO_AVALIADO;
        }

        double valorNumerico = Double.parseDouble(valor);

        return (valorNumerico > 0 && valorNumerico <= 0.5) ? Alimento.TRACO : valor.concat(unidadeDeMedida);
    }

}