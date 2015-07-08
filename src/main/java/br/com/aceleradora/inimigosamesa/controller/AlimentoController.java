package br.com.aceleradora.inimigosamesa.controller;

import br.com.aceleradora.inimigosamesa.dao.AlimentoRepository;
import br.com.aceleradora.inimigosamesa.dao.CategoriaRepository;
import br.com.aceleradora.inimigosamesa.model.Alimento;
import br.com.aceleradora.inimigosamesa.model.Categoria;
import br.com.aceleradora.inimigosamesa.model.Legenda;
import br.com.aceleradora.inimigosamesa.model.MedidasVisuais;
import br.com.aceleradora.inimigosamesa.service.AlimentoService;
import br.com.aceleradora.inimigosamesa.service.CategoriaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class AlimentoController {

    private static final String ORDENACAO_CRESCENTE = "ASC";
    private static final String ORDENACAO_DECRESCENTE = "DESC";

    @Autowired
    private AlimentoService servicoAlimento;

    @Autowired
    private CategoriaService servicoCategoria;

    @Autowired
    private AlimentoRepository alimentoRepository;

    @Autowired
    private CategoriaRepository categoriaRepository;

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
            model.addAttribute("ultimaPagina", ((Page) alimentos).getTotalPages());
            model.addAttribute("paginaAtual", pagina);
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
        model.addAttribute("alimento", alimento);
        model.addAttribute("categorias", categoriaRepository.findAll());

        return "cadastroAlimento";

    }

    @RequestMapping(value = "/cadastroAlimento", method = RequestMethod.POST)
    public String cadastrarAlimentoFormulario(Model model, Alimento alimento){
        Categoria c = new Categoria();
        System.out.println(alimento.getIdCategoria());
        c.setCodigo(Integer.parseInt(alimento.getIdCategoria()));
        alimento.setCategoria(c);
        alimentoRepository.save(alimento);


        return "cadastroAlimento";
    }

}