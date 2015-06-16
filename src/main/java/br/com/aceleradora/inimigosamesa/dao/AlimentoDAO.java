package br.com.aceleradora.inimigosamesa.dao;

import br.com.aceleradora.inimigosamesa.model.Alimento;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component

public class AlimentoDAO {

    public List<Alimento> alimentos = new ArrayList<Alimento>();


    public AlimentoDAO() {
        for (int i = 5; i > 0; i--) {
            Alimento a = new Alimento(i, i, "Alimento" + i, "../img/banana.png", i, i, i, i, i, i, i);
            alimentos.add(a);
        }
    }

    public List<Alimento> find(Alimento alimento) {
        List<Alimento> lista = new ArrayList<Alimento>();
        if (alimento.getNomeAlimento().equals("")) {
            return lista;
        } else {
            for (Alimento a : alimentos) {
                if (a.getNomeAlimento().toLowerCase().contains(alimento.getNomeAlimento().toLowerCase())) {
                    lista.add(a);
                }
            }
        }
        return lista;
    }
}
