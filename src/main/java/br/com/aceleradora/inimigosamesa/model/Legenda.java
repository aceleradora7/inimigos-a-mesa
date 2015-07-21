package br.com.aceleradora.inimigosamesa.model;

public class Legenda {

    public static final String TRACO = "TR";
    public static final String NAO_AVALIADO = "NA";

    public static final String GRAMAS = " g";
    public static final String MILIGRAMAS = " mg";
    public static final String CALORIAS = " kcal";


    private Alimento alimento;

    public Legenda(Alimento alimento) {
        this.alimento = alimento;
    }

    public String getCalorias(){
        return traduzirLegenda(alimento.getCalorias(), CALORIAS);
    }

    public String getAcucar(){
        return traduzirLegenda(alimento.getAcucar(), GRAMAS);
    }

    public String getSodio(){
        return traduzirLegenda(alimento.getSodio(), MILIGRAMAS);
    }

    public String getGordura(){
        return traduzirLegenda(alimento.getGordura(), GRAMAS);
    }

    private String traduzirLegenda(String valor, String unidade) {

        if (valor == null  || valor.isEmpty()) {
            return NAO_AVALIADO;
        }

        double valorNumerico = Double.parseDouble(valor);

        return valorNumerico > 0 && valorNumerico <= 0.5 ? TRACO : valor + " " + unidade;
    }
}