package br.com.aceleradora.inimigosamesa.model;

import java.util.ArrayList;
import java.util.List;

public class Calculadora {

    public static List<Alimento> listaDeAlimentos = new ArrayList<>();

    public List<Alimento> getListaDeAlimentos() {
        return listaDeAlimentos;
    }

    public void setListaDeAlimentos(List<Alimento> listaDeAlimentos) {
        this.listaDeAlimentos = listaDeAlimentos;
    }

    public void adicionaAlimento(Alimento alimento){

        listaDeAlimentos.add(alimento);
    }
}
