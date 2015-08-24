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

    public void adicionaAlimento(Alimento alimento){

        for (int i = 0; i < listaDeAlimentos.size(); i++) {
            if (listaDeAlimentos.get(i).getCodigo() == alimento.getCodigo()){
                excluiAlimento(listaDeAlimentos.get(i));
                break;
            }
        }
            listaDeAlimentos.add(alimento);
            somaAlimentoCalculadora(alimento);
            calculaColherCalculadora();
    }

    public boolean excluiAlimento(Alimento alimento) {

        for (int i =0; i<listaDeAlimentos.size();i++){
            if (listaDeAlimentos.get(i).getCodigo() == alimento.getCodigo()) {
                subtraiAlimentoCalculadora(listaDeAlimentos.get(i));
                calculaColherCalculadora();
                listaDeAlimentos.remove(i);
                return true;
            }
        }
        return false;
    }

    public void somaAlimentoCalculadora(Alimento alimento){

        if (naoEhVazio(alimento.getCalorias())) {
            caloriasTotal += Double.parseDouble(alimento.getCalorias());
        }
        if (naoEhVazio(alimento.getGordura())) {
            gorduraTotal += Double.parseDouble(alimento.getGordura());
        }
        if (naoEhVazio(alimento.getSodio())) {
            sodioTotal += Double.parseDouble(alimento.getSodio());
        }
        if (naoEhVazio(alimento.getAcucar())) {
            acucarTotal += Double.parseDouble(alimento.getAcucar());
        }
        if (naoEhVazio(alimento.getSodio())) {
            salTotal += MedidasVisuais.converteSodioEmSal(Double.parseDouble(alimento.getSodio()));
        }
    }



    public void subtraiAlimentoCalculadora(Alimento alimento){

        if (naoEhVazio(alimento.getCalorias())) {
            caloriasTotal -= Double.parseDouble(alimento.getCalorias());
        }
        if (naoEhVazio(alimento.getGordura())) {
            gorduraTotal -= Double.parseDouble(alimento.getGordura());
        }
        if (naoEhVazio(alimento.getSodio())) {
            sodioTotal -= Double.parseDouble(alimento.getSodio());
        }
        if (naoEhVazio(alimento.getAcucar())) {
            acucarTotal -= Double.parseDouble(alimento.getAcucar());
        }
        if (naoEhVazio(alimento.getSodio())) {
            salTotal -= MedidasVisuais.converteSodioEmSal(Double.parseDouble(alimento.getSodio()));
        }
    }

    public void calculaColherCalculadora() {

        MedidasVisuais medidasVisuais = new MedidasVisuais();
        colherSal = medidasVisuais.calculaColherSal(sodioTotal);
        colherAcucar = medidasVisuais.calculaColherAcucar(acucarTotal);
        colherGordura = medidasVisuais.calculaColherGordura(gorduraTotal);
    }

    public double formataDouble(double x){
        DecimalFormat formatoDecimalDuasCasas = new DecimalFormat("0.00");
        String valorNumericoFormato = formatoDecimalDuasCasas.format(x);
        valorNumericoFormato = valorNumericoFormato.replace(",",".");
        return Double.parseDouble(valorNumericoFormato);
    }

    public boolean naoEhVazio(String valor) {
        return valor != null && !valor.isEmpty();
    }
}
