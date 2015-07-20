package br.com.aceleradora.inimigosamesa.controller;

import br.com.aceleradora.inimigosamesa.model.Alimento;
import br.com.aceleradora.inimigosamesa.model.Categoria;
import br.com.aceleradora.inimigosamesa.model.Legenda;
import br.com.aceleradora.inimigosamesa.model.MedidasVisuais;
import br.com.aceleradora.inimigosamesa.service.AlimentoService;
import br.com.aceleradora.inimigosamesa.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

@Controller
public class AlimentoController {

    private static final String ORDENACAO_CRESCENTE = "ASC";
    private static final String ORDENACAO_DECRESCENTE = "DESC";

    @Autowired
    private AlimentoService servicoAlimento;

    @Autowired
    private CategoriaService servicoCategoria;

    @RequestMapping(value = {"/lista", "/grid"}, method = RequestMethod.GET)
    public void listar(
            @RequestParam(value = "busca", required = false) String busca,
            @RequestParam(value = "opcao-ordenar", required = false, defaultValue = ORDENACAO_CRESCENTE) String tipoDeOrdenacao,
            @RequestParam(value = "categoria", required = false, defaultValue = "0") int categoria,
            @RequestParam(value = "pagina", required = false, defaultValue = "1") int pagina,
            Model model) {

        Sort sort = new Sort(Sort.Direction.ASC, "nome");
        List<Categoria> categorias = (List) servicoCategoria.buscaTodos(sort);
        model.addAttribute("categorias",categorias);

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
            
            model.addAttribute("paginas", ((Page) alimentos));
            model.addAttribute("alimentos", alimentos);

        }else{
            model.addAttribute("erro", "Nenhum alimento encontrado.");
        }
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

    @RequestMapping(value = "/cadastroAlimento", method = RequestMethod.GET)
    public String cadastrarAlimento(Model model){
        Alimento alimento = new Alimento();
        Sort sort = new Sort(Sort.Direction.ASC, "nome");
        model.addAttribute("alimento", alimento);
        model.addAttribute("categorias", servicoCategoria.buscaTodos(sort));

        return "formularioAlimento";

    }

    @RequestMapping(value = "/editarAlimento", method = RequestMethod.GET)
    public String editarAlimento(Model model, @RequestParam(value = "codigo", required = false) int codigo){
        Alimento alimento = servicoAlimento.buscaPorCodigo(codigo);
        Sort sort = new Sort(Sort.Direction.ASC, "nome");
        model.addAttribute("categorias", servicoCategoria.buscaTodos(sort));
        model.addAttribute("alimento", alimento);


        return "formularioAlimento";
    }


    @RequestMapping(value = "/deletarAlimento", method = RequestMethod.GET)
    public String deletarAlimento(Model model, @RequestParam(value = "codigo", required = false) String codigo){
        Alimento alimento = servicoAlimento.buscaPorCodigo(Integer.parseInt(codigo));
        servicoAlimento.deletar(alimento);

        return "redirect:/grid";
    }

    @RequestMapping(value = "/gerenciarAlimento", method = RequestMethod.POST)
    public String gerenciarAlimento(Model model, Alimento alimento){

        if(alimento.getUrlImagemPequena().isEmpty()){
            alimento.setUrlImagemPequena("http://res.cloudinary.com/dq5mndrjt/image/upload/c_fit,w_108/v1436535224/lkt8uygy36ldiig3xglo.png");
        }
        if(alimento.getUrlImagemGrande().isEmpty()){
            alimento.setUrlImagemGrande("http://res.cloudinary.com/dq5mndrjt/image/upload/c_fit,w_390/v1436535224/lkt8uygy36ldiig3xglo.png");
        }
        servicoAlimento.salvar(alimento);

        return "redirect:/detalhe/"+alimento.getCodigo();
    }



}