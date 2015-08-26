package br.com.aceleradora.comercomsaber.controller;

import br.com.aceleradora.comercomsaber.model.Alimento;
import br.com.aceleradora.comercomsaber.service.AlimentoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BuscaController{

@Autowired
private AlimentoService servicoAlimento;

    @RequestMapping(value = "/autoCompletar", method = RequestMethod.GET)
    public Iterable<Alimento> autocompletar(@RequestParam(value="textoDigitado") String textoDigitado) {
        return servicoAlimento.buscaPorNome(textoDigitado);
    }
}
