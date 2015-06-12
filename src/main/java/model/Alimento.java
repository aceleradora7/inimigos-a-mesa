package model;

/**
 * Created by aluno02 on 10/06/15.
 */
public class Alimento {

    private int codAlimento, codCategoria;
    private String nomeAlimento, urlImagem;
    private double quantidadeAcucarGramas, valorPercentualDiarioAcucar,
            quantidadeSodioMiligramas, valorPercentualSodio,
            quantidadeGorduraGramas, valorPercentualGordura,
            quantidadeCaloria;

    public Alimento(){
        
    }

    public Alimento(int codAlimento,int codCategoria, String nomeAlimento, String urlImagem,
                    double quantidadeAcucarGramas, double valorPercentualDiarioAcucar,
                    double quantidadeSodioMiligramas, double valorPercentualSodio,
                    double quantidadeGorduraGramas, double valorPercentualGordura,
                    double quantidadeCaloria) {


        this.codAlimento = codAlimento;
        this.codCategoria = codCategoria;
        this.nomeAlimento = nomeAlimento;
        this.urlImagem=urlImagem;
        this.quantidadeAcucarGramas = quantidadeAcucarGramas;
        this.valorPercentualDiarioAcucar = valorPercentualDiarioAcucar;
        this.quantidadeSodioMiligramas = quantidadeSodioMiligramas;
        this.valorPercentualSodio = valorPercentualSodio;
        this.quantidadeGorduraGramas = quantidadeGorduraGramas;
        this.valorPercentualGordura = valorPercentualGordura;
        this.quantidadeCaloria = quantidadeCaloria;
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }

    public int getCodCategoria() {
        return codCategoria;
    }

    public void setCodCategoria(int codCategoria) {
        this.codCategoria = codCategoria;
    }

    public int getCodAlimento() {
        return this.codAlimento;
    }

    public void setcodAlimento(int codAlimento) {
        this.codAlimento = codAlimento;
    }

    public String getNomeAlimento() {
        return nomeAlimento;
    }

    public void setnomeAlimento(String nomeAlimento) {
        this.nomeAlimento = nomeAlimento;
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
