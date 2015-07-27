package br.com.aceleradora.inimigosamesa.model;

public class MedidasVisuais {

    private Alimento alimento;

    public static final double GRAMAS_SAL_COLHER = 2.06;
    public static final double GRAMAS_ACUCAR_COLHER = 1.76;
    public static final double ML_GORDURA_COLHER = 2;

    public MedidasVisuais(Alimento alimento) {
        this.alimento = alimento;
    }

    public int calculaColherSal() {
        int colher = 0;

        if (!verificaColherVazia(alimento.getSodio())) {
            double sodio = Double.parseDouble(alimento.getSodio());
            double sal = converteSodioEmSal(sodio);
            if (sal != 0) {
                colher = (int) (sal / GRAMAS_SAL_COLHER);
            }
        }
        return colher;
    }

    public double converteSodioEmSal(double sodio) {
        return ((sodio * 100) / 39) * 0.001;
    }

    public int calculaColherAcucar() {
        int colher = 0;

        if (!verificaColherVazia(alimento.getAcucar())) {
            double acucar = Double.parseDouble(alimento.getAcucar());
            if (acucar != 0) {
                colher = (int) (acucar / GRAMAS_ACUCAR_COLHER);
            }
        }

        return colher;
    }

    public int calculaColherGordura() {
        int colher = 0;

        if (!verificaColherVazia(alimento.getGordura())) {
            double gordura = Double.parseDouble(alimento.getGordura());
            if (gordura != 0) {
                colher = (int) (gordura / ML_GORDURA_COLHER);
            }
        }
        return colher;
    }

    public boolean verificaColherVazia(String valor) {
        if (valor == null || valor.equals("")) {
            return true;
        }
        return false;
    }

    public int getColheresDeSal() {
        return calculaColherSal();
    }

    public int getColheresDeAcucar() {
        return calculaColherAcucar();
    }

    public int getColheresDeGordura() {
        return calculaColherGordura();
    }

}