package br.com.aceleradora.comercomsaber.model;
import br.com.aceleradora.comercomsaber.util.Numeric;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.io.Serializable;
import java.text.DecimalFormat;

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
    private String valorMedidaCaseira;
    private String unidadeMedidaCaseira;
    private String fonte;
    private String valorMaximoMedida;

    public Alimento() {}

    public Alimento( String nome, String acucar, String sodio, String gordura, String calorias, String porcaoBaseCalculo, String unidadeBaseCalculo, String porcaoExibicao, String unidadeExibicao, String urlImagemPequena, String urlImagemGrande, String observacao, Categoria categoria, String valorMedidaCaseira, String unidadeMedidaCaseira, String fonte, String valorMaximoMedida) {
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
        this.valorMedidaCaseira = valorMedidaCaseira;
        this.unidadeMedidaCaseira = unidadeMedidaCaseira;
        this.fonte = fonte;
        this.valorMaximoMedida = valorMaximoMedida;
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

    public String getCalorias() { return calorias;}

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

    public String getFonte() {
        return fonte;
    }

    public void setFonte(String fonte) {
        this.fonte = fonte;
    }

    public String getValorMedidaCaseira() {
        return valorMedidaCaseira;
    }

    public void setValorMedidaCaseira(String valorMedidaCaseira) {
        this.valorMedidaCaseira = valorMedidaCaseira;
    }

    public String getUnidadeMedidaCaseira() {
        return unidadeMedidaCaseira;
    }

    public void setUnidadeMedidaCaseira(String unidadeMedidaCaseira) { this.unidadeMedidaCaseira = unidadeMedidaCaseira; }

    public String getValorMaximoMedida() {
        return valorMaximoMedida;
    }

    public void setValorMaximoMedida(String valorMaximoMedida) {
        this.valorMaximoMedida = valorMaximoMedida;
    }

    @Override
    public int compareTo(Alimento o) {
        return this.getNome().compareTo(o.getNome());
    }

    private String calculaExibicao(String valor) {

        if (valor == null || valor.equals("") || Double.parseDouble(porcaoExibicao) == Double.parseDouble(porcaoBaseCalculo)) {
            return valor;
        }else{
            double calculoExibicao = 0.0;
            if (Double.parseDouble(porcaoExibicao) < Double.parseDouble(porcaoBaseCalculo)) {
                calculoExibicao = Double.parseDouble(valor) / (Double.parseDouble(porcaoBaseCalculo) / Double.parseDouble(porcaoExibicao));
            }else{
                calculoExibicao = Double.parseDouble(valor) * (Double.parseDouble(porcaoExibicao) / Double.parseDouble(porcaoBaseCalculo));
            }
            return Numeric.formataNumeroDuasCasasDecimais(calculoExibicao);
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

    public void recalculaNutrientesDaCalculadora(double porcaoNova){
        if(calorias!=null && !calorias.isEmpty()){
            calorias = ""+(Double.parseDouble(calorias)*porcaoNova)/Double.parseDouble(porcaoBaseCalculo);
        }
        if(acucar!=null && !acucar.isEmpty()){
            acucar = ""+(Double.parseDouble(acucar)*porcaoNova)/Double.parseDouble(porcaoBaseCalculo);
        }
        if(gordura!=null && !gordura.isEmpty()){
            gordura = ""+(Double.parseDouble(gordura)*porcaoNova)/Double.parseDouble(porcaoBaseCalculo);
        }
        if(sodio!=null && !sodio.isEmpty()){
            sodio = ""+(Double.parseDouble(sodio)*porcaoNova)/Double.parseDouble(porcaoBaseCalculo);
        }
        porcaoExibicao = ""+porcaoNova;
    }
}