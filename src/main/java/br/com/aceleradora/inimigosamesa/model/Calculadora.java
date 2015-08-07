package br.com.aceleradora.inimigosamesa.model;


import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class Calculadora {

    private double caloriasTotal = 0.0;
    private double gorduraTotal = 0.0;
    private double acucarTotal = 0.0;
    private double sodioTotal = 0.0;
    private double salTotal = 0.0;
    public List<Alimento> listaDeAlimentos;
    private int colherSal = 0;
    private int colherGordura = 0;
    private int colherAcucar = 0;

    public Calculadora() {
        listaDeAlimentos = new ArrayList<>();
    }

    public List<Alimento> getListaDeAlimentos() {
        return listaDeAlimentos;
    }

    public void setListaDeAlimentos(List<Alimento> listaDeAlimentos) {
        this.listaDeAlimentos = listaDeAlimentos;
    }

    public double getCaloriasTotal() {

        return formataDouble(caloriasTotal);
    }

    public double getGorduraTotal() {
        return formataDouble(gorduraTotal);
    }

    public double getAcucarTotal() {
        return formataDouble(acucarTotal);
    }

    public double getSodioTotal() {
        return sodioTotal;
    }

    public double getSalTotal() {
        return formataDouble(salTotal);
    }

    public int getColherSal() { return colherSal; }

    public int getColherGordura() { return colherGordura; }

    public int getColherAcucar() {
        return colherAcucar;
    }

    public void setSalTotal(double salTotal) {
        this.salTotal = salTotal;
    }

    public boolean adicionaAlimento(Alimento alimento){

        boolean contem = false;
        for (Alimento ali : listaDeAlimentos){

            if (ali.getCodigo() == alimento.getCodigo()){
                contem = true;
                return false;
            }
        }
        if (contem == false){
            listaDeAlimentos.add(alimento);
            somaAlimentoCalculadora(alimento);
            somaColherCalculadora();
        }
        return true;
    }

    public void somaAlimentoCalculadora(Alimento alimento){

        if (alimento.getCalorias() != null && !alimento.getCalorias().isEmpty()) {
            caloriasTotal += Double.parseDouble(alimento.getCalorias());
        }
        if (alimento.getGordura() != null && !alimento.getGordura().isEmpty()) {
            gorduraTotal += Double.parseDouble(alimento.getGordura());
        }
        if (alimento.getSodio() != null && !alimento.getSodio().isEmpty()) {
            sodioTotal += Double.parseDouble(alimento.getSodio());
        }
        if (alimento.getAcucar() != null && !alimento.getAcucar().isEmpty()) {
            acucarTotal += Double.parseDouble(alimento.getAcucar());
        }
        if (alimento.getSodio() != null && !alimento.getSodio().isEmpty()) {
            salTotal += MedidasVisuais.converteSodioEmSal(Double.parseDouble(alimento.getSodio()));
        }
    }

    public void somaColherCalculadora() {

        MedidasVisuais medidasVisuais = new MedidasVisuais();

        colherSal = medidasVisuais.calculaColherSal(sodioTotal);
        colherAcucar = medidasVisuais.calculaColherAcucar(acucarTotal);
        colherGordura = medidasVisuais.calculaColherGordura(gorduraTotal);
    }

    public double formataDouble(double x){
        String b = ""+x;
        if(b.length()>=b.indexOf('.')+3){
            return Double.parseDouble(b.substring(0,b.indexOf('.')+3));
        }
        else{
            return Double.parseDouble(b);
        }
    }

}
