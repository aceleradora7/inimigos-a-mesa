package DAO;

import model.Alimento;

import java.util.ArrayList;
import java.util.List;

public class AlimentoDAO {

    public List<Alimento> alimentos = new ArrayList<Alimento>();


    public AlimentoDAO() {
        for (int i = 5; i > 0; i--) {
            Alimento a = new Alimento(i,i, "Alimento"+i,"../img/banana.png",i,i,i,i,i,i,i);
            alimentos.add(a);
        }
    }

//    public Alimento find(Alimento alimento) {
//        if (alimento.getNomeAlimento().equals("")){
//            return null;
//        } else {
//            for (Alimento a : alimentos) {
//                if (a.getNomeAlimento().toLowerCase().contains(alimento.getNomeAlimento().toLowerCase())) {
//                    return a;
//                }
//            }
//            return null;
//        }
//    }

    public ArrayList<Alimento> find(Alimento alimento) {
        ArrayList<Alimento> lista = new ArrayList<Alimento>();
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
