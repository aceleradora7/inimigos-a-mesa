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

    public String getAcucarGramas(){
        return traduzirLegenda(alimento.getAcucarGramas(), GRAMAS);
    }

    public String getSodioMiligramas(){
        return traduzirLegenda(alimento.getSodioMiligramas(), MILIGRAMAS);
    }

    public String getGorduraGramas(){
        return traduzirLegenda(alimento.getGorduraGramas(), GRAMAS);
    }

    private String traduzirLegenda(String valor, String unidade) {

        if (valor == null  || valor.isEmpty()) {
            return NAO_AVALIADO;
        }

        double valorNumerico = Double.parseDouble(valor);

        return (valorNumerico > 0 && valorNumerico <= 0.5) ? TRACO : valor + " " + unidade;
    }
}