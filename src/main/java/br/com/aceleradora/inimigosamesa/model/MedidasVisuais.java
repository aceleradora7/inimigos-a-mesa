package br.com.aceleradora.inimigosamesa.model;

public class MedidasVisuais {

    private Alimento alimento;

    public MedidasVisuais(Alimento alimento) {
        this.alimento = alimento;
    }

    public double getColheresDeSal(){
        double colher = 0;

        if(alimento.getSodioMiligramas().isEmpty()){
            return colher;
        }

        double sodio = Double.parseDouble(alimento.getSodioMiligramas());
        double sal = ((sodio * 100) / 39) * 0.001;
        if (sal != 0) {
            colher = sal / 2.06;
        }

        return colher;
    }

    public double getColheresDeAcucar(){
        double colher = 0;

        if(alimento.getAcucarGramas().isEmpty()){
            return colher;
        }

        double acucar = Double.parseDouble(alimento.getAcucarGramas());
        if (acucar != 0) {
            colher = acucar / 1.76;
        }
        return colher;
    }

    public double getColheresDeGordura(){
        double colher = 0;

        if(alimento.getGorduraGramas().isEmpty()){
            return colher;
        }

        double gordura = Double.parseDouble(alimento.getGorduraGramas());
        if (gordura != 0) {
            colher = gordura / 2;
        }
        return colher;
    }
}