package DAO;

import model.Alimento;

import java.util.ArrayList;

/**
 * Created by aluno02 on 10/06/15.
 */
public class AlimentoDAO {

    public ArrayList<Alimento> alimentos = new ArrayList<Alimento>();

    public AlimentoDAO(){
        for (int i = 0; i < 5 ; i++) {
            alimentos.get(i).setNome("Alimento" + i);
            alimentos.get(i).setQuantidadeAcucarGramas(i);
        }
    }

    public Alimento find(Alimento alimento){
        for(Alimento a : alimentos) {
            if (a.getNome().equals(alimento.getNome())) {
                return a;
            }
        }
        return null;
    }



}
