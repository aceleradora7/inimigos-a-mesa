package br.com.aceleradora.comercomsaber.controller;

import br.com.aceleradora.comercomsaber.model.*;
import br.com.aceleradora.comercomsaber.service.AlimentoService;
import br.com.aceleradora.comercomsaber.service.CategoriaService;
import br.com.aceleradora.comercomsaber.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class AlimentoController {

    @Autowired
    private AlimentoService servicoAlimento;

    @Autowired
    private CategoriaService servicoCategoria;

    @Autowired
    private UsuarioService servicoUsuario;

    @RequestMapping(value = {"/alimentos"}, method = RequestMethod.GET)
    public void listar(
            @RequestParam(value = "busca", required = false) String busca,
            @RequestParam(value = "categoria", required = false, defaultValue = "0") int categoria,
            @RequestParam(value = "pagina", required = false, defaultValue = "1") int pagina,
            Model model) {

        try {
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            Usuario usarioAtual = servicoUsuario.buscaPorEmail(user.getUsername());
            model.addAttribute("nomeUsuario", usarioAtual.getNome());
        }catch (Exception e){
        }

        Sort sort = new Sort(Sort.Direction.ASC, "nome");
        List<Categoria> categorias = (List) servicoCategoria.buscaTodos(sort);
        model.addAttribute("categorias", categorias);

        pagina = pagina <= 0 ? 1 : pagina;

        Iterable<Alimento> alimentos;
        List<Categoria> listCategoria;
        if (busca != null) {

            listCategoria = servicoCategoria.buscaPorNome(busca);

            if (listCategoria.isEmpty()) {
                if (categoria != 0) {
                    alimentos = servicoAlimento.buscaPorNomeNaCategoria(busca, categoria, pagina);
                    System.out.println("aspas");
                } else {
                    alimentos = servicoAlimento.buscaPorNome(busca, pagina);
                }
            } else {
                alimentos = servicoAlimento.buscaPorCategoria(pagina, listCategoria.get(0).getCodigo());
            }
        } else if (categoria != 0) {
            alimentos = servicoAlimento.buscaPorCategoria(pagina, categoria);
        } else {
            alimentos = servicoAlimento.buscaTodos(pagina);
        }

        if (alimentos.iterator().hasNext()) {

            model.addAttribute("paginas", ((Page) alimentos));
            model.addAttribute("alimentos", alimentos);

        } else {
            model.addAttribute("erro", busca + " não foi encontrado :(");
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
        try {
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            Usuario usarioAtual = servicoUsuario.buscaPorEmail(user.getUsername());
            model.addAttribute("nomeUsuario", usarioAtual.getNome());
        }catch (Exception e){
        }

        return "detalhe";
    }

    @RequestMapping(value = "/cadastroAlimento", method = RequestMethod.GET)
    public String cadastrarAlimento(Model model, Alimento alimento) {
        if (alimento == null) {
            alimento = new Alimento();
        }
        try {
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            Usuario usarioAtual = servicoUsuario.buscaPorEmail(user.getUsername());
            model.addAttribute("nomeUsuario", usarioAtual.getNome());
        }catch (Exception e){

        }
        Sort sort = new Sort(Sort.Direction.ASC, "nome");
        model.addAttribute("alimento", alimento);
        model.addAttribute("categorias", servicoCategoria.buscaTodos(sort));

        return "formularioAlimento";

    }

    @RequestMapping(value = "/editarAlimento", method = RequestMethod.GET)
    public String editarAlimento(Model model, @RequestParam(value = "codigo", required = false) int codigo) {
        Alimento alimento = servicoAlimento.buscaPorCodigo(codigo);
        Sort sort = new Sort(Sort.Direction.ASC, "nome");
        model.addAttribute("categorias", servicoCategoria.buscaTodos(sort));
        model.addAttribute("alimento", alimento);
        try {
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            Usuario usarioAtual = servicoUsuario.buscaPorEmail(user.getUsername());
            model.addAttribute("nomeUsuario", usarioAtual.getNome());
        }catch (Exception e){

        }


        return "formularioAlimento";
    }

    @RequestMapping(value = "/deletarAlimento", method = RequestMethod.GET)
    public String deletarAlimento(Model model, @RequestParam(value = "codigo", required = false) String codigo) {
        Alimento alimento = servicoAlimento.buscaPorCodigo(Integer.parseInt(codigo));
        servicoAlimento.deletar(alimento);
        try {
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            Usuario usarioAtual = servicoUsuario.buscaPorEmail(user.getUsername());
            model.addAttribute("nomeUsuario", usarioAtual.getNome());
        }catch (Exception e){

        }

        return "redirect:/alimentos?alimentoDeletado";
    }

    @RequestMapping(value = "/gerenciarAlimento", method = RequestMethod.POST)
    public String gerenciarAlimento(Model model, Alimento alimento, BindingResult bindingResult) throws Exception {


        alimento = replaceVirgulaPonto(alimento);
        String validacao = validacao(model, alimento);

        if (validacao.equals("Salvar")) {
            if (alimento.getValorMaximoMedida() == null || alimento.getValorMaximoMedida().isEmpty()) {
                alimento.setValorMaximoMedida("10");
            }
            servicoAlimento.salvar(alimento);
            return "redirect:/detalhe/" + alimento.getCodigo();
        } else {
            return validacao;
        }

    }

    @RequestMapping("/calculadora")
    public String calculadora(Model model, HttpServletRequest request) {

        if (request.getSession().getAttribute("calculadora") == null) {
            request.getSession().setAttribute("calculadora", new Calculadora());
        }

        Calculadora calculadora = (Calculadora) request.getSession().getAttribute("calculadora");

        model.addAttribute("calculadora", calculadora);
        if (calculadora != null) {
            model.addAttribute("alimentos", calculadora.getListaDeAlimentos());
        }
        try {
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            Usuario usarioAtual = servicoUsuario.buscaPorEmail(user.getUsername());
            model.addAttribute("nomeUsuario", usarioAtual.getNome());
        }catch (Exception e){
        }
        
        return "calculadora";
    }

    @RequestMapping(value = "/adicionaAlimento", method = RequestMethod.GET)
    public String calculadora(Model model, @RequestParam(value = "codigo", required = false) int codigo, @RequestParam(value = "porcao", required = false) String porcao, HttpServletRequest request) {

        if (request.getSession().getAttribute("calculadora") == null) {
            request.getSession().setAttribute("calculadora", new Calculadora());
        }


        try {
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            Usuario usarioAtual = servicoUsuario.buscaPorEmail(user.getUsername());
            model.addAttribute("nomeUsuario", usarioAtual.getNome());
        }catch (Exception e){

        }

        Calculadora calculadora = (Calculadora) request.getSession().getAttribute("calculadora");

        Alimento alimento = servicoAlimento.buscaPorCodigo(codigo);

        alimento.recalculaNutrientesDaCalculadora(Double.parseDouble(porcao));

        calculadora.adicionaAlimento(alimento);

        request.getSession().setAttribute("calculadora", calculadora);


        model.addAttribute("calculadora", calculadora);

        return calculadora(model, request);
    }

    @RequestMapping(value = "/excluiAlimento", method = RequestMethod.GET)
    public String calc(Model model, @RequestParam(value = "codigo", required = false) int codigo, HttpServletRequest request){

        if(request.getSession().getAttribute("calculadora") == null){
            request.getSession().setAttribute("calculadora", new Calculadora());
        }

        try {
            User user = (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
            Usuario usarioAtual = servicoUsuario.buscaPorEmail(user.getUsername());
            model.addAttribute("nomeUsuario", usarioAtual.getNome());
        }catch (Exception e){

        }

        Calculadora calculadora = (Calculadora) request.getSession().getAttribute("calculadora");
        Alimento alimento = servicoAlimento.buscaPorCodigo(codigo);
        calculadora.excluiAlimento(alimento);

        request.getSession().setAttribute("calculadora", calculadora);
        model.addAttribute("calculadora", calculadora);

        return calculadora(model,request);
    }

    public boolean naoEhVazio(String valor) {
        return valor != null && !valor.isEmpty();
    }

    public boolean maiorQueBaseCalculo(String valor, String baseCalculo) {
        return Double.parseDouble(valor) > Double.parseDouble(baseCalculo);
    }

    public boolean maiorQueZero(boolean comIgual, String valor){
        if(!valor.equals("")) {
            return comIgual ? Double.parseDouble(valor) >= 0 : Double.parseDouble(valor) > 0;
        }
        return true;
    }

    public boolean validaAcucar(Alimento alimento) {
        return naoEhVazio(alimento.getAcucar()) && maiorQueBaseCalculo(alimento.getAcucar(), alimento.getPorcaoBaseCalculo());
    }

    public boolean validaGordura(Alimento alimento) {
        return naoEhVazio(alimento.getGordura()) &&
                maiorQueBaseCalculo(alimento.getGordura(), alimento.getPorcaoBaseCalculo());
    }

    public boolean validaSodio(Alimento alimento) {
        return naoEhVazio(alimento.getSodio()) &&
                maiorQueBaseCalculo(Double.parseDouble(alimento.getSodio()) / 1000 + "", alimento.getPorcaoBaseCalculo());
    }

    public String validacao(Model model, Alimento alimento) {
        if (alimento.getNome().isEmpty()) {
            model.addAttribute("erroNome", "true");
            return cadastrarAlimento(model, alimento);
        }

        model.addAttribute("erroNome", null);
        if (alimento.getCategoria() == null) {
            model.addAttribute("erroCategoria", "true");
            return cadastrarAlimento(model, alimento);
        }

        model.addAttribute("erroCategoria", null);
        if (alimento.validaValor(alimento.getPorcaoBaseCalculo())
                || alimento.getPorcaoBaseCalculo().isEmpty() || !maiorQueZero(false,alimento.getPorcaoBaseCalculo())) {
            model.addAttribute("erroPorcaoBase", "true");
            return cadastrarAlimento(model, alimento);
        }

        model.addAttribute("erroPorcaoBase", null);
        if (alimento.validaValor(alimento.getPorcaoExibicao()) || alimento.getPorcaoExibicao().isEmpty()
                || !maiorQueZero(false,alimento.getPorcaoExibicao())) {
            model.addAttribute("erroPorcaoExibicao", "true");
            return cadastrarAlimento(model, alimento);
        }

        model.addAttribute("erroPorcaoExibicao", null);
        if (alimento.getUnidadeBaseCalculo() == null) {
            model.addAttribute("erroUnidade", "true");
            return cadastrarAlimento(model, alimento);
        }

        model.addAttribute("erroUnidade", null);
        if (alimento.validaValor(alimento.getValorMedidaCaseira()) ||
        alimento.getValorMedidaCaseira().isEmpty() || !maiorQueZero(false,alimento.getValorMedidaCaseira())) {
            model.addAttribute("erroMedidaCaseira", "true");
            model.addAttribute("erroValorMedida", "true");
            return cadastrarAlimento(model, alimento);
        }

        model.addAttribute("erroValorMedida", null);
        model.addAttribute("erroMedidaCaseira", null);

        if (alimento.getUnidadeMedidaCaseira().isEmpty() || alimento.getUnidadeBaseCalculo().isEmpty()) {
            model.addAttribute("erroMedidaCaseira", "true");
            model.addAttribute("erroUnidadeMedida", "true");
            return cadastrarAlimento(model, alimento);
        }

        model.addAttribute("erroMedidaCaseira", null);
        model.addAttribute("erroUnidadeMedida", null);
        if (alimento.validaValor(alimento.getValorMaximoMedida()) || !maiorQueZero(false,alimento.getValorMaximoMedida())) {
            model.addAttribute("erroValorMaximo", "true");
            return cadastrarAlimento(model, alimento);
        }

        model.addAttribute("erroValorMaximo", null);
        if (alimento.validaValor(alimento.getCalorias()) || !maiorQueZero(true,alimento.getCalorias())) {
            model.addAttribute("erroCalorias", "true");
            return cadastrarAlimento(model, alimento);
        }

        model.addAttribute("erroCalorias", null);
        if (alimento.validaValor(alimento.getAcucar()) || !maiorQueZero(true,alimento.getAcucar())) {
            model.addAttribute("erroAcucar", "true");
            return cadastrarAlimento(model, alimento);
        }

        model.addAttribute("erroAcucar", null);
        if (validaAcucar(alimento)) {
            model.addAttribute("erroAcucarPorcao", "true");
            return cadastrarAlimento(model, alimento);
        }

        if (alimento.validaValor(alimento.getSodio()) || !maiorQueZero(true,alimento.getSodio())) {
            model.addAttribute("erroSodio", "true");
            return cadastrarAlimento(model, alimento);
        }

        model.addAttribute("erroSodio", null);
        if (validaSodio(alimento)) {
            model.addAttribute("erroSodioPorcao", "true");
            return cadastrarAlimento(model, alimento);
        }

        model.addAttribute("erroSodioPorcao", null);
        if (alimento.validaValor(alimento.getGordura()) || !maiorQueZero(true,alimento.getGordura())) {
            model.addAttribute("erroGordura", "true");
            return cadastrarAlimento(model, alimento);
        }

        model.addAttribute("erroGordura", null);
        if (validaGordura(alimento)) {
            model.addAttribute("erroGorduraPorcao", "true");
            return cadastrarAlimento(model, alimento);
        }

        model.addAttribute("erroGorduraPorcao", null);
        if (alimento.getFonte().isEmpty()) {
            model.addAttribute("erroFonte", "true");
            return cadastrarAlimento(model, alimento);
        }
        return "Salvar";
    }

    public Alimento replaceVirgulaPonto(Alimento alimento) {
        if(alimento.getPorcaoBaseCalculo()!=null){
            alimento.setPorcaoBaseCalculo(alimento.getPorcaoBaseCalculo().replace(',', '.'));
        }

        if(alimento.getPorcaoExibicao()!=null){
            alimento.setPorcaoExibicao(alimento.getPorcaoExibicao().replace(',', '.'));
        }

        if(alimento.getValorMedidaCaseira()!=null){
            alimento.setValorMedidaCaseira(alimento.getValorMedidaCaseira().replace(',', '.'));
        }

        if(alimento.getCalorias()!=null){
            alimento.setCalorias(alimento.getCalorias().replace(',', '.'));
        }

        if(alimento.getAcucar()!=null){
            alimento.setAcucar(alimento.getAcucar().replace(',', '.'));
        }

        if(alimento.getSodio()!=null){
            alimento.setSodio(alimento.getSodio().replace(',', '.'));
        }

        if(alimento.getGordura()!=null) {
            alimento.setGordura(alimento.getGordura().replace(',', '.'));
        }
        return alimento;
    }
}