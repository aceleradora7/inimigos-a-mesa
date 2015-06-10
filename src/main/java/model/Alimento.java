package model;

/**
 * Created by aluno02 on 10/06/15.
 */
public class Alimento {

    private int cod;
    private String nome;
    private double quantidadeAcucarGramas, valorPercentualDiarioAcucar,
                quantidadeSodioMiligramas, valorPercentualSodio,
                quantidadeGorduraGramas, valorPercentualGordura,
                quantidadeCaloria;

    public Alimento(int cod, String nome,
                    double quantidadeAcucarGramas, double valorPercentualDiarioAcucar,
                    double quantidadeSodioMiligramas, double valorPercentualSodio,
                    double quantidadeGorduraGramas, double valorPercentualGordura,
                    double quantidadeCaloria) {


        this.cod = cod;
        this.nome = nome;
        this.quantidadeAcucarGramas = quantidadeAcucarGramas;
        this.valorPercentualDiarioAcucar = valorPercentualDiarioAcucar;
        this.quantidadeSodioMiligramas = quantidadeSodioMiligramas;
        this.valorPercentualSodio = valorPercentualSodio;
        this.quantidadeGorduraGramas = quantidadeGorduraGramas;
        this.valorPercentualGordura = valorPercentualGordura;
        this.quantidadeCaloria = quantidadeCaloria;
    }

    public int getCod() {
        return cod;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getQuantidadeAcucarGramas() {
        return quantidadeAcucarGramas;
    }

    public void setQuantidadeAcucarGramas(double quantidadeAcucarGramas) {
        this.quantidadeAcucarGramas = quantidadeAcucarGramas;
    }

    public double getValorPercentualDiarioAcucar() {
        return valorPercentualDiarioAcucar;
    }

    public void setValorPercentualDiarioAcucar(double valorPercentualDiarioAcucar) {
        this.valorPercentualDiarioAcucar = valorPercentualDiarioAcucar;
    }

    public double getQuantidadeSodioMiligramas() {
        return quantidadeSodioMiligramas;
    }

    public void setQuantidadeSodioMiligramas(double quantidadeSodioMiligramas) {
        this.quantidadeSodioMiligramas = quantidadeSodioMiligramas;
    }

    public double getValorPercentualSodio() {
        return valorPercentualSodio;
    }

    public void setValorPercentualSodio(double valorPercentualSodio) {
        this.valorPercentualSodio = valorPercentualSodio;
    }

    public double getQuantidadeGorduraGramas() {
        return quantidadeGorduraGramas;
    }

    public void setQuantidadeGorduraGramas(double quantidadeGorduraGramas) {
        this.quantidadeGorduraGramas = quantidadeGorduraGramas;
    }

    public double getValorPercentualGordura() {
        return valorPercentualGordura;
    }

    public void setValorPercentualGordura(double valorPercentualGordura) {
        this.valorPercentualGordura = valorPercentualGordura;
    }

    public double getQuantidadeCaloria() {
        return quantidadeCaloria;
    }

    public void setQuantidadeCaloria(double quantidadeCaloria) {
        this.quantidadeCaloria = quantidadeCaloria;
    }
}
