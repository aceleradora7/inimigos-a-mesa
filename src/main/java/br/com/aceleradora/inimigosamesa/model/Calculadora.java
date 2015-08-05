package br.com.aceleradora.inimigosamesa.model;

import java.util.ArrayList;
import java.util.List;

public class Calculadora {

    public List<Alimento> listaDeAlimentos = new ArrayList<>();

    public List<Alimento> getListaDeAlimentos() {
        return listaDeAlimentos;
    }

    public void setListaDeAlimentos(List<Alimento> listaDeAlimentos) {
        this.listaDeAlimentos = listaDeAlimentos;
    }

    public boolean adicionaAlimento(Alimento alimento){

        boolean contem = false;
        for (Alimento ali : listaDeAlimentos){

            if (ali.getCodigo() == alimento.getCodigo()){
                contem = true;
                return false;
            }
        }
        if (contem == false){
            listaDeAlimentos.add(alimento);
        }
        return true;
    }
}
