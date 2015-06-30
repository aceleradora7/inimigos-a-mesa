package br.com.aceleradora.inimigosamesa.model;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "alimento")
public class Alimento implements Comparable<Alimento>, Serializable{

    @Id
    @GeneratedValue(strategy = GenerationType.TABLE)
    private int codigo;

    @JoinColumn(name = "cod_categoria", referencedColumnName = "codigo")
    @ManyToOne
    @JsonIgnore
    private Categoria categoria;

    private String nome;
    private String acucarGramas;
    private String percentualDiarioAcucar;
    private String sodioMiligramas;
    private String percentualDiarioSodio;
    private String gorduraGramas;
    private String percentualDiarioGordura;
    private String calorias;
    private String urlImagem;

    public Alimento() {

    }

    public Alimento(int codigo, Categoria categoria, String nome, String acucarGramas, String percentualDiarioAcucar, String sodioMiligramas, String percentualDiarioSodio, String gorduraGramas, String percentualDiarioGordura, String calorias, String urlImagem) {
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

    @JsonIgnore
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

    public String getAcucarGramas() {
        return acucarGramas;
    }

    public void setAcucarGramas(String acucarGramas) {
        this.acucarGramas=acucarGramas;
    }

    public String getPercentualDiarioAcucar() {
        return percentualDiarioAcucar;
    }

    public void setPercentualDiarioAcucar(String percentualDiarioAcucar) {
        this.percentualDiarioAcucar = percentualDiarioAcucar;
    }

    public String getSodioMiligramas() {
        return sodioMiligramas;
    }

    public void setSodioMiligramas(String sodioMiligramas) {
        this.sodioMiligramas = sodioMiligramas;
    }

    public String getPercentualDiarioSodio() {
        return percentualDiarioSodio;
    }

    public void setPercentualDiarioSodio(String percentualDiarioSodio) {
        this.percentualDiarioSodio = percentualDiarioSodio;
    }

    public String getGorduraGramas() {
        return gorduraGramas;
    }

    public void setGorduraGramas(String gorduraGramas) {

        this.gorduraGramas = gorduraGramas;
    }

    public String getPercentualDiarioGordura() {
        return percentualDiarioGordura;
    }

    public void setPercentualDiarioGordura(String percentualDiarioGordura) {
        this.percentualDiarioGordura = percentualDiarioGordura;
    }

    public String getCalorias() {
        return calorias;
    }

    public void setCalorias(String calorias) {
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