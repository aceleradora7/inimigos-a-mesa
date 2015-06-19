package br.com.aceleradora.inimigosamesa.controller;

import br.com.aceleradora.inimigosamesa.dao.CategoriaRepository;
import br.com.aceleradora.inimigosamesa.model.Categoria;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class CategoriaController {

    @Autowired
    CategoriaRepository categoriaRepository;


    @RequestMapping(value = "/cadastrarCategoria", method = RequestMethod.POST)
    public String cadastrar(Categoria categoria, Model model){
        if(categoriaRepository.save(categoria) == null) {
            model.addAttribute("mensagemDeRetorno", "Não foi possivel cadastrar categoria");
        } else {
            model.addAttribute("mensagemDeRetorno", "Cadastro realizado com sucesso");
        }
        return "categoria";
    }

    @RequestMapping(value="/cadastrarCategoria", method = RequestMethod.GET)
    public String categoria(Model model){
        model.addAttribute("categoria", new Categoria());
        return "categoria";
    }

}
