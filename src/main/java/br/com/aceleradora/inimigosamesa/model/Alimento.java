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

    @Transient
    private String idCategoria;

    private String nome;
    //@Column ( nullable = true )
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

    public Alimento() {
    }

    public Alimento(String idCategoria, String nome, String acucar, String sodio, String gordura, String calorias, String porcaoBaseCalculo, String unidadeBaseCalculo, String porcaoExibicao, String unidadeExibicao, String urlImagemPequena, String urlImagemGrande, String observacao, Categoria categoria) {
        this.idCategoria = idCategoria;
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

    public String getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(String idCategoria) {
        this.idCategoria = idCategoria;
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

    @Override
    public int compareTo(Alimento o) {
        return this.getNome().compareTo(o.getNome());
    }



    public double calculaExibicaoCalorias(){

        if (Double.parseDouble(getPorcaoExibicao()) == 100) {

            double calculoExibicaoCaloria = Double.parseDouble(getCalorias());
            return calculoExibicaoCaloria;

        } else if (Double.parseDouble(getPorcaoExibicao()) < 100) {

            double numerador = 100/Double.parseDouble(getPorcaoExibicao());
            double calculoExibicaoCaloria = Double.parseDouble(getCalorias())/numerador;
            return calculoExibicaoCaloria;
        } else {

            double numerador = Double.parseDouble(getPorcaoExibicao())/100;
            double calculoExibicaoCaloria = Double.parseDouble(getCalorias())*numerador;
            return calculoExibicaoCaloria;
        }
    }
    public String getExibicaoCalorias() {

        String caloriasExibicao = String.valueOf(calculaExibicaoCalorias());
        return caloriasExibicao;
    }

    public double calculaExibicaoAcucar(){

        if (Double.parseDouble(getPorcaoExibicao()) == 100) {

            double calculoExibicaoAcucar = Double.parseDouble(getAcucar());
            return calculoExibicaoAcucar;

        } else if (Double.parseDouble(getPorcaoExibicao()) < 100) {

            double numerador = 100/Double.parseDouble(getPorcaoExibicao());
            double calculoExibicaoAcucar = Double.parseDouble(getAcucar())/numerador;
            return calculoExibicaoAcucar;
        } else {

            double numerador = Double.parseDouble(getPorcaoExibicao())/100;
            double calculoExibicaoAcucar = Double.parseDouble(getAcucar())*numerador;
            return calculoExibicaoAcucar;
        }
    }
    public String getExibicaoAcucar(){

        String acucarExibicao = String.valueOf(calculaExibicaoAcucar());
        return acucarExibicao;
    }

    public double calculaExibicaoSodio(){
        if (Double.parseDouble(getPorcaoExibicao()) == 100) {

            double calculoExibicaoSodio = Double.parseDouble(getSodio());
            return calculoExibicaoSodio;

        } else if (Double.parseDouble(getPorcaoExibicao()) < 100) {

            double numerador = 100/Double.parseDouble(getPorcaoExibicao());
            double calculoExibicaoSodio = Double.parseDouble(getCalorias())/numerador;
            return calculoExibicaoSodio;
        } else {

            double numerador = Double.parseDouble(getPorcaoExibicao())/100;
            double calculoExibicaoSodio = Double.parseDouble(getCalorias())*numerador;
            return calculoExibicaoSodio;
        }
    }
    public String getExibicaoSodio() {

        String sodioExibicao = String.valueOf(calculaExibicaoSodio());
        return sodioExibicao;
    }

    public double calculaExibicaoGordura(){

        if (Double.parseDouble(getPorcaoExibicao()) == 100) {

            double calculoExibicaoGordura = Double.parseDouble(getGordura());
            return calculoExibicaoGordura;

        } else if (Double.parseDouble(getPorcaoExibicao()) < 100) {

            double numerador = 100/Double.parseDouble(getPorcaoExibicao());
            double calculoExibicaoGordura = Double.parseDouble(getCalorias())/numerador;
            return calculoExibicaoGordura;
        } else {

            double numerador = Double.parseDouble(getPorcaoExibicao())/100;
            double calculoExibicaoGordura = Double.parseDouble(getCalorias())*numerador;
            return calculoExibicaoGordura;
        }
    }
    public String getExibicaoGordura() {

        String gordurasExibicao = String.valueOf(calculaExibicaoGordura());
        return gordurasExibicao;
    }
}