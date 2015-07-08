package br.com.aceleradora.inimigosamesa.model;

public class MedidasVisuais {

    private Alimento alimento;

    public MedidasVisuais(Alimento alimento) {
        this.alimento = alimento;
    }

    public double getColheresDeSal(){
        double colher = 0;

        if(alimento.getSodio().isEmpty()){
            return colher;
        }

        double sodio = Double.parseDouble(alimento.getSodio());
        double sal = ((sodio * 100) / 39) * 0.001;
        if (sal != 0) {
            colher = sal / 2.06;
        }

        return colher;
    }

    public double getColheresDeAcucar(){
        double colher = 0;

        if(alimento.getAcucar().isEmpty()){
            return colher;
        }

        double acucar = Double.parseDouble(alimento.getAcucar());
        if (acucar != 0) {
            colher = acucar / 1.76;
        }
        return colher;
    }

    public double getColheresDeGordura(){
        double colher = 0;

        if(alimento.getGordura().isEmpty()){
            return colher;
        }

        double gordura = Double.parseDouble(alimento.getGordura());
        if (gordura != 0) {
            colher = gordura / 2;
        }
        return colher;
    }
}