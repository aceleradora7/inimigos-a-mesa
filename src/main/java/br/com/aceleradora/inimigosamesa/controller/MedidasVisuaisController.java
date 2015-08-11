package br.com.aceleradora.inimigosamesa.controller;

import br.com.aceleradora.inimigosamesa.model.Alimento;
import br.com.aceleradora.inimigosamesa.model.MedidasVisuais;
import org.cloudinary.json.JSONObject;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
public class MedidasVisuaisController {

    @RequestMapping(value = "/calculaColheres", method = RequestMethod.GET)
    public String calculaColheres(@RequestParam(value = "acucar", required = false) String acucar,
                                      @RequestParam(value = "sodio", required = false) String sodio,
                                      @RequestParam(value = "gordura", required = false) String gordura,
                                      @RequestParam(value = "porcaoExibicao", required = false) String porcaoExibicao) {

        Alimento alimento = new Alimento();
        MedidasVisuais medidasVisuais = new MedidasVisuais(alimento);

        alimento.setAcucar(acucar);
        alimento.setSodio(sodio);
        alimento.setGordura(gordura);
        alimento.setPorcaoBaseCalculo(porcaoExibicao);
        alimento.setPorcaoExibicao(porcaoExibicao);

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("acucar", medidasVisuais.calculaColherAcucar());
        jsonObject.put("sal", medidasVisuais.calculaColherSal());
        jsonObject.put("gordura", medidasVisuais.calculaColherGordura());

        return String.valueOf(jsonObject);
    }
}
