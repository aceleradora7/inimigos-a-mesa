package br.com.aceleradora.inimigosamesa.controller;

import br.com.aceleradora.inimigosamesa.dao.AlimentoRepository;
import br.com.aceleradora.inimigosamesa.model.Alimento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BuscaController{

@Autowired
private AlimentoRepository repositorioAlimento;

        @RequestMapping(value = "/autoCompletar", method = RequestMethod.GET)
        public List<Alimento> autocompletar(@RequestParam(value="textoDigitado") String textoDigitado) {
            return repositorioAlimento.buscaAlimentoPorNomeSemAcentos(textoDigitado + "%");
        }


}
