package br.com.aceleradora.inimigosamesa.controller;

import br.com.aceleradora.inimigosamesa.model.*;
import br.com.aceleradora.inimigosamesa.service.AlimentoService;
import br.com.aceleradora.inimigosamesa.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;
import java.util.List;

@Controller
public class AlimentoController {

    @Autowired
    private AlimentoService servicoAlimento;

    @Autowired
    private CategoriaService servicoCategoria;

    @RequestMapping(value = {"/grid"}, method = RequestMethod.GET)
    public void listar(
            @RequestParam(value = "busca", required = false) String busca,
            @RequestParam(value = "categoria", required = false, defaultValue = "0") int categoria,
            @RequestParam(value = "pagina", required = false, defaultValue = "1") int pagina,
            Model model) {

        Sort sort = new Sort(Sort.Direction.ASC, "nome");
        List<Categoria> categorias = (List) servicoCategoria.buscaTodos(sort);
        model.addAttribute("categorias",categorias);

        pagina = pagina <= 0 ? 1 : pagina;

        Iterable<Alimento> alimentos;
        List<Categoria> listCategoria;
        if(busca != null) {

            listCategoria = servicoCategoria.buscaPorNome(busca);

            if (listCategoria.isEmpty()) {
                if(categoria != 0) {
                    alimentos = servicoAlimento.buscaPorNomeNaCategoria(busca, categoria, pagina);
                    System.out.println("aspas");
                } else {
                    alimentos = servicoAlimento.buscaPorNome(busca, pagina);
                }
            } else {
                alimentos = servicoAlimento.buscaPorCategoria(pagina, listCategoria.get(0).getCodigo());
            }
        }
        else if(categoria != 0){
            alimentos = servicoAlimento.buscaPorCategoria(pagina,categoria);
        }

        else {
            alimentos = servicoAlimento.buscaTodos(pagina);
        }

        if(alimentos.iterator().hasNext()){
            
            model.addAttribute("paginas", ((Page) alimentos));
            model.addAttribute("alimentos", alimentos);

        }else{
            model.addAttribute("erro", busca+" não foi encontrado.");
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
    public String cadastrarAlimento(Model model, Alimento alimento){
        if(alimento == null){
         alimento = new Alimento();
        }
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
    public String gerenciarAlimento(Model model, Alimento alimento, BindingResult bindingResult) throws Exception {

        String validacao = validacao(model, alimento);

        if(validacao.equals("Salvar")){
            servicoAlimento.salvar(alimento);
            return "redirect:/detalhe/"+alimento.getCodigo();
        }else{
            return validacao;
        }

    }

    @RequestMapping("/calculadora")
    public String calculadora(Model model, HttpServletRequest request){
        model.addAttribute("alimento", new Alimento());
        Calculadora calculadora = (Calculadora)  request.getSession().getAttribute("calculadora");
        if(calculadora!=null) {
            model.addAttribute("alimentos", calculadora.getListaDeAlimentos());
        }
        return "calculadora";
    }

    @RequestMapping(value = "/adicionaAlimento", method = RequestMethod.GET)
    public String calculadora(Model model, @RequestParam(value = "codigo", required = false) int codigo, HttpServletRequest request){

        if(request.getSession().getAttribute("calculadora") == null){
            request.getSession().setAttribute("calculadora", new Calculadora());
        }

        Calculadora calculadora = (Calculadora) request.getSession().getAttribute("calculadora");

        Alimento alimento = servicoAlimento.buscaPorCodigo(codigo);

        calculadora.adicionaAlimento(alimento);
        request.getSession().setAttribute("calculadora", calculadora);

        model.addAttribute("alimento", alimento);

        System.out.println(calculadora.getListaDeAlimentos().size());
        System.out.println(calculadora.getListaDeAlimentos().get(0).getNome());
        return calculadora(model,request);
    }

    public String validacao(Model model, Alimento alimento){
        if(alimento.getNome().isEmpty()){
            model.addAttribute("erroNome", "Preencha o campo com o nome do alimento.");
            return cadastrarAlimento(model,alimento);
        }
        else if(alimento.getCategoria()==null) {
            model.addAttribute("erroCategoria","Selecione uma categoria.");
            return cadastrarAlimento(model,alimento);
        }
        else if( alimento.validaValor(alimento.getPorcaoBaseCalculo()) || alimento.getUnidadeBaseCalculo()==null){
            model.addAttribute("erroPorcaoBaseCalculo","Preencha o campo com números e marque a unidade da porção. ");
            return cadastrarAlimento(model,alimento);
        }
        else if(alimento.validaValor(alimento.getPorcaoExibicao()) || alimento.getUnidadeExibicao()==null){
            model.addAttribute("erroPorcaoExibicao","Preencha o campo com números e marque a unidade da porção.");
            return cadastrarAlimento(model,alimento);
        }
        else if(alimento.validaValor(alimento.getMedidaCaseira())){
            model.addAttribute("erroMedidaCaseira","Preencha o campo.");
            return cadastrarAlimento(model,alimento);
        }


        else if (alimento.validaValor(alimento.getCalorias())) {
            model.addAttribute("erroCalorias","O campo calorias só pode conter caracteres numéricos!");
            return cadastrarAlimento(model,alimento);
        } else if(alimento.validaValor(alimento.getAcucar())){
            model.addAttribute("erroAcucar","O campo açucar só pode conter caracteres numéricos!");
            return cadastrarAlimento(model,alimento);
        } else if(alimento.validaValor(alimento.getSodio())) {
            model.addAttribute("erroSodio","O campo sodio só pode conter caracteres numéricos!");
            return cadastrarAlimento(model,alimento);
        } else if(alimento.validaValor(alimento.getGordura())) {
            model.addAttribute("erroGordura","O campo gordura só pode conter caracteres numéricos!");
            return cadastrarAlimento(model,alimento);
        }
        return "Salvar";
    }
}