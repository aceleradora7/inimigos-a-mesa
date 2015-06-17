package br.com.aceleradora.inimigosamesa.dao;

import br.com.aceleradora.inimigosamesa.model.Alimento;
import br.com.aceleradora.inimigosamesa.model.Categoria;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component

public class AlimentoDAO {

    private List<Alimento> alimentos = new ArrayList<Alimento>();

    public AlimentoDAO() {
        alimentos.add(new Alimento(0, 1, "Banana", "../img/banana.png", 10, 10, 100, 100, 1000, 100, 100));
        alimentos.add(new Alimento(1, 1, "Laranja", "../img/laranja.png", 10, 10, 100, 100, 1000, 100, 100));
        alimentos.add(new Alimento(0, 1, "Maça", "../img/maca.png", 10, 10, 100, 100, 1000, 1000, 100));
        alimentos.add(new Alimento(0, 1, "Morango", "../img/morango.png", 10, 10, 100, 100, 1000, 100, 100));
        alimentos.add(new Alimento(0, 7, "Nescau", "../img/nescau.png", 10, 10, 100, 100, 1000, 100, 100));
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

    public List<Alimento> findPorCategoria(Categoria categoria) {
        List<Alimento> lista = new ArrayList<Alimento>();
        for (Alimento a : alimentos) {
            if (a.getCodCategoria() == categoria.getCodCategoria()) {
                lista.add(a);
            }

        }
        return lista;
    }

    public List<Alimento> getAlimentos() {
        return alimentos;
    }

    public void setAlimentos(List<Alimento> alimentos) {
        this.alimentos = alimentos;
    }
}
