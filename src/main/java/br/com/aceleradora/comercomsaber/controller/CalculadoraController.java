package br.com.aceleradora.comercomsaber.controller;

import br.com.aceleradora.comercomsaber.model.Alimento;
import br.com.aceleradora.comercomsaber.model.Calculadora;
import br.com.aceleradora.comercomsaber.model.Usuario;
import br.com.aceleradora.comercomsaber.service.AlimentoService;
import br.com.aceleradora.comercomsaber.service.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpServletRequest;

@Controller
public class CalculadoraController {

    @Autowired
    private AlimentoService servicoAlimento;

    @Autowired
    private UsuarioService servicoUsuario;

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
        model.addAttribute("nomeUsuario",servicoUsuario.getNomeUsuarioLogado());
        return "calculadora";
    }

    @RequestMapping(value = "/adicionaAlimento", method = RequestMethod.GET)
    public String adicionaNaCalculadora(Model model, @RequestParam(value = "codigo", required = false) int codigo, @RequestParam(value = "porcao", required = false) String porcao, HttpServletRequest request) {
        if (request.getSession().getAttribute("calculadora") == null) {
            request.getSession().setAttribute("calculadora", new Calculadora());
        }

        Calculadora calculadora = (Calculadora) request.getSession().getAttribute("calculadora");
        Alimento alimento = servicoAlimento.buscaPorCodigo(codigo);
        alimento.recalculaNutrientesDaCalculadora(Double.parseDouble(porcao));
        calculadora.adicionaAlimento(alimento);
        request.getSession().setAttribute("calculadora", calculadora);

        model.addAttribute("calculadora", calculadora);
        model.addAttribute("nomeUsuario",servicoUsuario.getNomeUsuarioLogado());

        return calculadora(model, request);
    }

    @RequestMapping(value = "/excluiAlimento", method = RequestMethod.GET)
    public String calc(Model model, @RequestParam(value = "codigo", required = false) int codigo, HttpServletRequest request){
        if(request.getSession().getAttribute("calculadora") == null){
            request.getSession().setAttribute("calculadora", new Calculadora());
        }
        Calculadora calculadora = (Calculadora) request.getSession().getAttribute("calculadora");
        Alimento alimento = servicoAlimento.buscaPorCodigo(codigo);
        calculadora.excluiAlimento(alimento);
        request.getSession().setAttribute("calculadora", calculadora);

        model.addAttribute("calculadora", calculadora);
        model.addAttribute("nomeUsuario",servicoUsuario.getNomeUsuarioLogado());

        return calculadora(model,request);
    }

}
