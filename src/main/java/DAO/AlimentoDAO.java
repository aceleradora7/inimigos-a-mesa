package DAO;

import model.Alimento;

import java.util.ArrayList;

/**
 * Created by aluno02 on 10/06/15.
 */
public class AlimentoDAO {

    public ArrayList<Alimento> alimentos = new ArrayList<Alimento>();


    public AlimentoDAO() {
        for (int i = 0; i < 5; i++) {
            Alimento a = new Alimento(i, "Alimento"+i,i,i,i,i,i,i,i);
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
