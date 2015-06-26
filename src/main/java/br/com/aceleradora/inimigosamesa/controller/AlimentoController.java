package br.com.aceleradora.inimigosamesa.controller;

import br.com.aceleradora.inimigosamesa.dao.AlimentoRepository;
import br.com.aceleradora.inimigosamesa.dao.CategoriaRepository;
import br.com.aceleradora.inimigosamesa.model.Alimento;
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
            @RequestParam(value="busca", required = false) String busca,
            @RequestParam(value = "opcao-ordenar", required = false, defaultValue = ORDENACAO_CRESCENTE) String tipoDeOrdenacao,
            @RequestParam(value = "categoria", required = false, defaultValue = "0") int categoria,
            Model model) {

        List<Alimento> alimentos;

        if(busca != null){
            alimentos = busca(busca);
        }else{
            alimentos = (List) ((categoria == 0) ? repositorioAlimento.findAll() : buscaPorCategoria(categoria));
        }


        if(alimentos.isEmpty()){
            model.addAttribute("erro", "Nenhum alimento encontrado.");
        }else{
            ordenar(alimentos, tipoDeOrdenacao);
            model.addAttribute("alimentos", alimentos);
        }

        return "lista";
    }

    public List<Alimento> buscaPorCategoria(int codigoCategoria){
        return repositorioCategoria.findOne(codigoCategoria).getAlimentos();
    }

    public List<Alimento> busca(String busca) {
        return repositorioAlimento.findByNomeLikeIgnoreCase(busca + "%");
    }

    @RequestMapping(value = "/detalhe/{codigo}")
    public String detalhe(Model model, @PathVariable("codigo") int codigo) {

        Alimento alimento = repositorioAlimento.findOne(codigo);
        legendar(alimento);
        model.addAttribute("alimentoDetalhe", alimento);

        return "detalhe";
    }


    private void ordenar(List<Alimento> alimentos, String tipoDeOrdenacao) {

        Collections.sort(alimentos);

        if (tipoDeOrdenacao.equals(ORDENACAO_DECRESCENTE)) {
            Collections.reverse(alimentos);
        }
    }

    private void legendar(Alimento alimento) {
        alimento.setCalorias(traduzirLegenda(alimento.getCalorias()));
        alimento.setAcucarGramas(traduzirLegenda(alimento.getAcucarGramas()));
        alimento.setSodioMiligramas(traduzirLegenda(alimento.getSodioMiligramas()));
        alimento.setGorduraGramas(traduzirLegenda(alimento.getGorduraGramas()));
    }

    private String traduzirLegenda(String valor) {

        if (valor == null) {
            return Alimento.NAO_AVALIADO;
        }

        double valorNumerico = Double.parseDouble(valor);

        return (valorNumerico > 0 && valorNumerico <= 0.5) ? Alimento.TRACO : valor;
    }

}