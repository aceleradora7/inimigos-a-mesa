package br.com.aceleradora.inimigosamesa.model;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "alimento")
public class Alimento implements Comparable<Alimento>, Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "codalimento")
    private int codigo;

    @JoinColumn(name = "codcategoria", referencedColumnName = "codcategoria")
    @ManyToOne
    private Categoria categoria;

    @Column(name = "nomealimento")
    private String nome;

    @Column(name = "quantidadeacucargramas")
    private double acucarGramas;

    @Column(name = "valorpercentualacucardiario")
    private double percentualDiarioAcucar;

    @Column(name = "quantidadesodiomiligramas")
    private double sodioMiligramas;

    @Column(name = "valorpercentualsodiodiario")
    private double percentualDiarioSodio;

    @Column(name = "quantidadegorduragramas")
    private double gorduraGramas;

    @Column(name = "valorpercentualgorduradiaria")
    private double percentualDiarioGordura;

    @Column(name = "quantidadecalorias")
    private double calorias;

    private String urlImagem;

    public Alimento() {

    }

    public Alimento(int codigo, Categoria categoria, String nome, double acucarGramas, double percentualDiarioAcucar, double sodioMiligramas, double percentualDiarioSodio, double gorduraGramas, double percentualDiarioGordura, double calorias, String urlImagem) {
        this.codigo = codigo;
        this.categoria = categoria;
        this.nome = nome;
        this.acucarGramas = acucarGramas;
        this.percentualDiarioAcucar = percentualDiarioAcucar;
        this.sodioMiligramas = sodioMiligramas;
        this.percentualDiarioSodio = percentualDiarioSodio;
        this.gorduraGramas = gorduraGramas;
        this.percentualDiarioGordura = percentualDiarioGordura;
        this.calorias = calorias;
        this.urlImagem = urlImagem;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getAcucarGramas() {
        return acucarGramas;
    }

    public void setAcucarGramas(double acucarGramas) {
        this.acucarGramas = acucarGramas;
    }

    public double getPercentualDiarioAcucar() {
        return percentualDiarioAcucar;
    }

    public void setPercentualDiarioAcucar(double percentualDiarioAcucar) {
        this.percentualDiarioAcucar = percentualDiarioAcucar;
    }

    public double getSodioMiligramas() {
        return sodioMiligramas;
    }

    public void setSodioMiligramas(double sodioMiligramas) {
        this.sodioMiligramas = sodioMiligramas;
    }

    public double getPercentualDiarioSodio() {
        return percentualDiarioSodio;
    }

    public void setPercentualDiarioSodio(double percentualDiarioSodio) {
        this.percentualDiarioSodio = percentualDiarioSodio;
    }

    public double getGorduraGramas() {
        return gorduraGramas;
    }

    public void setGorduraGramas(double gorduraGramas) {
        this.gorduraGramas = gorduraGramas;
    }

    public double getPercentualDiarioGordura() {
        return percentualDiarioGordura;
    }

    public void setPercentualDiarioGordura(double percentualDiarioGordura) {
        this.percentualDiarioGordura = percentualDiarioGordura;
    }

    public double getCalorias() {
        return calorias;
    }

    public void setCalorias(double calorias) {
        this.calorias = calorias;
    }

    public String getUrlImagem() {
        return urlImagem;
    }

    public void setUrlImagem(String urlImagem) {
        this.urlImagem = urlImagem;
    }

    @Override
    public int compareTo(Alimento o) {
        return this.getNome().compareTo(o.getNome());
    }
}