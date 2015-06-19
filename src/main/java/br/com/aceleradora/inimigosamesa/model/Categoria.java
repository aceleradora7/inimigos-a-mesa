package br.com.aceleradora.inimigosamesa.model;

import javax.persistence.*;
import java.util.List;

@Entity(name = "categoria")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="codcategoria")
    private int codigo;

    @Column(name="nomecategoria")
    private String nome;

    @OneToMany(mappedBy = "categoria")
    private List<Alimento> alimentos;

    public Categoria(){

    }

    public Categoria(int codigo, String nome) {
        this.codigo = codigo;
        this.nome = nome;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public List<Alimento> getAlimentos() {
        return alimentos;
    }

    public void setAlimentos(List<Alimento> alimentos) {
        this.alimentos = alimentos;
    }
}
