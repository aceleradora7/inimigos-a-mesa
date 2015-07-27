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

        if (!verificaColherVazia(alimento.getExibicaoSodio())) {
            double sodio = Double.parseDouble(alimento.getExibicaoSodio());
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

        if (!verificaColherVazia(alimento.getExibicaoAcucar())) {
            double acucar = Double.parseDouble(alimento.getExibicaoAcucar());
            if (acucar != 0) {
                colher = (int) (acucar / GRAMAS_ACUCAR_COLHER);
            }
        }

        return colher;
    }

    public int calculaColherGordura() {
        int colher = 0;

        if (!verificaColherVazia(alimento.getExibicaoGordura())) {
            double gordura = Double.parseDouble(alimento.getExibicaoGordura());
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