package br.com.aceleradora.inimigosamesa.model;

public class MedidasVisuais {

    private Alimento alimento;

    public MedidasVisuais(Alimento alimento) {
        this.alimento = alimento;
    }

    public int getColheresDeSal(){
        int colher = 0;

        if(alimento.getSodio()==null){
            return colher;
        }

        double sodio = Double.parseDouble(alimento.getSodio());
        double sal = ((sodio * 100) / 39) * 0.001;
        if (sal != 0) {
            colher = (int)(sal / 2.06);
        }
        return colher;
    }

    public int getColheresDeAcucar(){
        int colher = 0;

        if(alimento.getAcucar()==null){
            return colher;
        }

        double acucar = Double.parseDouble(alimento.getAcucar());
        if (acucar != 0) {
            colher = (int)( acucar / 1.76);
        }
        return colher;
    }

    public int getColheresDeGordura(){
        int colher = 0;

        if(alimento.getGordura()==null){
            return colher;
        }

        double gordura = Double.parseDouble(alimento.getGordura());
        if (gordura != 0) {
            colher = (int)(gordura / 2);
        }
        return colher;
    }
}