package br.com.aceleradora.inimigosamesa.controller;

import br.com.aceleradora.inimigosamesa.model.Alimento;
import br.com.aceleradora.inimigosamesa.model.Legenda;
import br.com.aceleradora.inimigosamesa.model.MedidasVisuais;
import br.com.aceleradora.inimigosamesa.service.AlimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.HandlerMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class AlimentoController {

    private static final String ORDENACAO_CRESCENTE = "ASC";
    private static final String ORDENACAO_DECRESCENTE = "DESC";

    @Autowired
    private AlimentoService servicoAlimento;

    @RequestMapping(value = {"/grid"}, method = RequestMethod.GET)
    public String listar(
            @RequestParam(value = "busca", required = false) String busca,
            @RequestParam(value = "opcao-ordenar", required = false, defaultValue = ORDENACAO_CRESCENTE) String tipoDeOrdenacao,
            @RequestParam(value = "categoria", required = false, defaultValue = "0") int categoria,
            @RequestParam(value = "pagina", required = false, defaultValue = "1") int pagina,
            HttpServletRequest request,
            Model model) {

        pagina = (pagina <= 0)? 1 : pagina;        

        Iterable<Alimento> alimentos;
        if(busca != null){
            alimentos = servicoAlimento.buscaPorNome(busca, pagina, tipoDeOrdenacao);
        }

        else if(categoria != 0){
            alimentos = servicoAlimento.buscaPorCategoria(pagina,categoria, tipoDeOrdenacao);
        }

        else {
            alimentos = servicoAlimento.buscaTodos(pagina,tipoDeOrdenacao);
        }

        if(alimentos.iterator().hasNext()){
            model.addAttribute("ultimaPagina", ((Page) alimentos).getTotalPages());
            model.addAttribute("paginaAtual", pagina);
            model.addAttribute("alimentos", alimentos);
        }else{
            model.addAttribute("erro", "Nenhum alimento encontrado.");
        }

        return "grid";
    }

    @RequestMapping(value = {"/lista"}, method = RequestMethod.GET)
    public String grid(
            @RequestParam(value = "busca", required = false) String busca,
            @RequestParam(value = "opcao-ordenar", required = false, defaultValue = ORDENACAO_CRESCENTE) String tipoDeOrdenacao,
            @RequestParam(value = "categoria", required = false, defaultValue = "0") int categoria,
            @RequestParam(value = "pagina", required = false, defaultValue = "1") int pagina,
            HttpServletRequest request,
            Model model) {

        pagina = (pagina <= 0)? 1 : pagina;        

        Iterable<Alimento> alimentos;
        if(busca != null){
            alimentos = servicoAlimento.buscaPorNome(busca, pagina, tipoDeOrdenacao);
        }

        else if(categoria != 0){
            alimentos = servicoAlimento.buscaPorCategoria(pagina,categoria, tipoDeOrdenacao);
        }

        else {
            alimentos = servicoAlimento.buscaTodos(pagina,tipoDeOrdenacao);
        }

        if(alimentos.iterator().hasNext()){
            model.addAttribute("ultimaPagina", ((Page) alimentos).getTotalPages());
            model.addAttribute("paginaAtual", pagina);
            model.addAttribute("alimentos", alimentos);
        }else{
            model.addAttribute("erro", "Nenhum alimento encontrado.");
        }

        return "lista";
    }

    @RequestMapping(value = "/detalhe/{codigo}")
    public String detalhe(Model model, @PathVariable("codigo") int codigo) {

        Alimento alimento = servicoAlimento.buscaPorCodigo(codigo);
        MedidasVisuais medidas = servicoAlimento.getMedidasVisuais(alimento);
        Legenda legendas = servicoAlimento.getLegendas(alimento);

        model.addAttribute("alimento", alimento);
        model.addAttribute("medidas", medidas);
        model.addAttribute("legenda", legendas);

        return "detalhe";
    }
}