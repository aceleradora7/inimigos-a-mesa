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
    @Column(name="acucar_gramas")
    private String acucar;
    private String porcaoAlimento;
    @Column(name="sodio_miligramas")
    private String sodio;
    private String unidade;
    @Column(name = "gordura_gramas")
    private String gordura;
    private String percentualDiarioGordura;
    private String calorias;
    private String urlImagem;

    public Alimento() {
    }

    public Alimento(int codigo, Categoria categoria, String nome, String acucar, String porcaoAlimento, String sodio, String unidade, String gordura, String percentualDiarioGordura, String calorias, String urlImagem) {
        this.codigo = codigo;
        this.categoria = categoria;
        this.nome = nome;
        this.acucar = acucar;
        this.porcaoAlimento = porcaoAlimento;
        this.sodio = sodio;
        this.unidade = unidade;
        this.gordura = gordura;
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

    public String getAcucar() {
        return acucar;
    }


    public void setAcucar(String acucar) {
        this.acucar = acucar;

    }

    public String getPorcaoAlimento() {
        return porcaoAlimento;
    }

    public void setPorcaoAlimento(String porcaoAlimento) {
        this.porcaoAlimento = porcaoAlimento;
    }

    public String getSodio() {
        return sodio;
    }

    public void setSodio(String sodio) {
        this.sodio = sodio;
    }

    public String getUnidade() {
        return unidade;
    }

    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }

    public String getGordura() {
        return gordura;
    }

    public void setGordura(String gordura) {

        this.gordura = gordura;
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

    public String getIdCategoria() {
        return idCategoria;
    }

    public void setIdCategoria(String idCategoria) {
        this.idCategoria = idCategoria;
    }

    @Override
    public int compareTo(Alimento o) {
        return this.getNome().compareTo(o.getNome());
    }


}