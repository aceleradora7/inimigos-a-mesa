package br.com.aceleradora.inimigosamesa.controller;

import br.com.aceleradora.inimigosamesa.dao.AlimentoRepository;
import br.com.aceleradora.inimigosamesa.model.Alimento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class AlimentoController {

    @Autowired
    AlimentoRepository repositorio;

    @RequestMapping("/testaBanco")
    @ResponseBody
    public String testeBanco(@RequestParam(value="nome", required = false, defaultValue = "Banana") String nome){
        try{

            Alimento alimento = new Alimento();
            alimento.setnomeAlimento(nome);

            repositorio.save(alimento);

        }catch(Exception ex){
            ex.printStackTrace();
            return "Erro: " + ex.getMessage() + "<br /> ";
        }

      return "OK";
    }
}