package br.com.aceleradora.inimigosamesa.model;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;

@Entity(name = "alimento")
public class Alimento implements Comparable<Alimento>, Serializable {

    @Id
    @SequenceGenerator(initialValue = 1, allocationSize = 1, name = "geradorId", sequenceName = "alimento_codigo_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "geradorId")
    private int codigo;

    @JoinColumn(name = "cod_categoria", referencedColumnName = "codigo")
    @ManyToOne
    @JsonIgnore
    private Categoria categoria;

    private String nome;

    private String acucar;
    private String sodio;
    private String gordura;
    private String calorias;


    private String porcaoBaseCalculo;
    private String unidadeBaseCalculo;
    private String porcaoExibicao;
    private String unidadeExibicao;
    private String urlImagemPequena;
    private String urlImagemGrande;
    private String observacao;
    private String medidaCaseira;
    private String fonte;

    public Alimento() {
    }

    public Alimento( String nome, String acucar, String sodio, String gordura, String calorias, String porcaoBaseCalculo, String unidadeBaseCalculo, String porcaoExibicao, String unidadeExibicao, String urlImagemPequena, String urlImagemGrande, String observacao, Categoria categoria, String medidaCaseira, String fonte) {
        this.nome = nome;
        this.acucar = acucar;
        this.sodio = sodio;
        this.gordura = gordura;
        this.calorias = calorias;
        this.porcaoBaseCalculo = porcaoBaseCalculo;
        this.unidadeBaseCalculo = unidadeBaseCalculo;
        this.porcaoExibicao = porcaoExibicao;
        this.unidadeExibicao = unidadeExibicao;
        this.urlImagemPequena = urlImagemPequena;
        this.urlImagemGrande = urlImagemGrande;
        this.observacao = observacao;
        this.categoria = categoria;
        this.medidaCaseira = medidaCaseira;
        this.fonte = fonte;
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

    public String getAcucar() {
        return acucar;
    }

    public void setAcucar(String acucar) {
        this.acucar = acucar;
    }

    public String getSodio() {
        return sodio;
    }

    public void setSodio(String sodio) {
        this.sodio = sodio;
    }

    public String getGordura() {
        return gordura;
    }

    public void setGordura(String gordura) {
        this.gordura = gordura;
    }

    public String getCalorias() {
        return calorias;
    }

    public void setCalorias(String calorias) {
        this.calorias = calorias;
    }

    public String getPorcaoBaseCalculo() {
        return porcaoBaseCalculo;
    }

    public void setPorcaoBaseCalculo(String porcaoBaseCalculo) {
        this.porcaoBaseCalculo = porcaoBaseCalculo;
    }

    public String getUnidadeBaseCalculo() {
        return unidadeBaseCalculo;
    }

    public void setUnidadeBaseCalculo(String unidadeBaseCalculo) {
        this.unidadeBaseCalculo = unidadeBaseCalculo;
    }

    public String getPorcaoExibicao() {
        return porcaoExibicao;
    }

    public void setPorcaoExibicao(String porcaoExibicao) {
        this.porcaoExibicao = porcaoExibicao;
    }

    public String getUnidadeExibicao() {
        return unidadeExibicao;
    }

    public void setUnidadeExibicao(String unidadeExibicao) {
        this.unidadeExibicao = unidadeExibicao;
    }

    public String getUrlImagemPequena() {
        return urlImagemPequena;
    }

    public void setUrlImagemPequena(String urlImagemPequena) {
        this.urlImagemPequena = urlImagemPequena;
    }

    public String getUrlImagemGrande() {
        return urlImagemGrande;
    }

    public void setUrlImagemGrande(String urlImagemGrande) {
        this.urlImagemGrande = urlImagemGrande;
    }

    public String getObservacao() {
        return observacao;
    }

    public void setObservacao(String observacao) {
        this.observacao = observacao;
    }

    public String getMedidaCaseira() { return medidaCaseira; }

    public void setMedidaCaseira(String medidaCaseira) { this.medidaCaseira = medidaCaseira; }

    public String getFonte() { return fonte; }

    public void setFonte(String fonte) { this.fonte = fonte; }

    @Override
    public int compareTo(Alimento o) {
        return this.getNome().compareTo(o.getNome());
    }

    public String calculaExibicao(String valor) {
        if (valor == null || valor.equals("") || Double.parseDouble(porcaoExibicao) == Double.parseDouble(porcaoBaseCalculo)) {
            return valor;
        } else {
            double calculoExibicaoSodio = 0.0;
           if (Double.parseDouble(porcaoExibicao) < Double.parseDouble(porcaoBaseCalculo)) {
                double numerador = Double.parseDouble(porcaoBaseCalculo) / Double.parseDouble(porcaoExibicao);
               calculoExibicaoSodio = Double.parseDouble(valor) / numerador;
            } else {
                double numerador = Double.parseDouble(porcaoExibicao) / Double.parseDouble(porcaoBaseCalculo);
                calculoExibicaoSodio = Double.parseDouble(valor) * numerador;
            }
            return String.valueOf(calculoExibicaoSodio);
        }
    }


    public String getExibicaoCalorias() {
        return calculaExibicao(calorias);
    }

    public String getExibicaoAcucar() {
        return calculaExibicao(acucar);
    }

    public String getExibicaoSodio() {
        return calculaExibicao(sodio);
    }

    public String getExibicaoGordura() {
        return calculaExibicao(gordura);
    }

    public  boolean temLetraPorcaoBaseCalculo(){
        if(getPorcaoBaseCalculo()!=null && !getPorcaoBaseCalculo().isEmpty()){
            try {
                Double.parseDouble(getPorcaoBaseCalculo());
            }catch(Exception e){
                return true;
            }
        }
        return false;
    }

    public  boolean temLetraPorcaoExibicao(){
        if(getPorcaoExibicao()!=null && !getPorcaoExibicao().isEmpty()){
            try {
                Double.parseDouble(getPorcaoExibicao());
            }catch(Exception e){
                return true;
            }
        }
        return false;
    }

    public  boolean temLetraAcucar(){
        if(getAcucar()!=null && !getAcucar().isEmpty())
        {
            try{
                Double.parseDouble(getAcucar());
            }catch (Exception e){
                return true;
            }
        }
        return false;
    }

    public  boolean temLetraCalorias(){
        if(getCalorias()!=null && !getCalorias().isEmpty()){
            try{
                Double.parseDouble(getCalorias());
            }catch (Exception e){
                return true;
            }
        }
        return false;
    }

    public  boolean temLetraSodio(){
        if(getSodio()!=null && !getSodio().isEmpty()){
            try{
                Double.parseDouble(getSodio());
            }catch (Exception e){
                return true;
            }
        }
        return false;
    }

    public  boolean temLetraGordura(){
        if(getGordura()!=null && !getGordura().isEmpty()){
            try{
                Double.parseDouble(getGordura());
            }catch (Exception e){
                return true;
            }
        }
        return false;
    }
}