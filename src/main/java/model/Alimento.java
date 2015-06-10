package model;

/**
 * Created by aluno02 on 10/06/15.
 */
public class Alimento {

    private String id;
    private String nome;
    private double acucar;
    private double sodio;
    private double gordura;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getAcucar() {
        return acucar;
    }

    public void setAcucar(double acucar) {
        this.acucar = acucar;
    }

    public double getSodio() {
        return sodio;
    }

    public void setSodio(double sodio) {
        this.sodio = sodio;
    }

    public double getGordura() {
        return gordura;
    }

    public void setGordura(double gordura) {
        this.gordura = gordura;
    }
}
