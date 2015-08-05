package br.com.aceleradora.inimigosamesa.model;

import javax.persistence.*;

@Entity(name = "usuario")
public class Usuario {

    @Id
    @SequenceGenerator(initialValue = 1, allocationSize = 1, name = "geradorId", sequenceName = "usuario_codigo_seq")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "geradorId")
    private int codigo;

    private String nome;
    @Column(name = "email", unique = true)
    private String email;
    private String senha;

    @Enumerated(EnumType.STRING)
    private Role role;

    public Usuario(String nome, String email, String senha, Role role, int codigo) {
        this.nome = nome;
        this.email = email;
        this.senha = senha;
        this.role = role;
        this.codigo = codigo;
    }

    public Usuario(String email, String senha, Role role) {
        this.email = email;
        this.senha = senha;
        this.role = role;
    }

    public Usuario() {

    }

    public int getCodigo() { return codigo; }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }
}

