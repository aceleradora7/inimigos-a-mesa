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

    public Alimento find(Alimento alimento) {
        for (Alimento a : alimentos) {
            if (a.getNomeAlimento().equals(alimento.getNomeAlimento())) {
                return a;
            }
        }
        return null;
    }


}
