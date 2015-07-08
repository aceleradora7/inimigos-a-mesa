package br.com.aceleradora.inimigosamesa.model;

public class FormularioEmail {
    private String nome;
    private String emailRemetente;
    private String assunto;
    private String mensagem;


    public FormularioEmail(String nome, String emailRemetente, String assunto, String mensagem) {
        this.nome = nome;
        this.emailRemetente = emailRemetente;
        this.assunto = assunto;
        this.mensagem = mensagem;
    }

    public FormularioEmail(){

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmailRemetente() {
        return emailRemetente;
    }

    public void setEmailRemetente(String emailRemetente) { this.emailRemetente = emailRemetente; }

    public String getAssunto() {
        return assunto;
    }

    public void setAssunto(String assunto) {
        this.assunto = assunto;
    }

    public String getMensagem() {
        return mensagem;
    }

    public void setMensagem(String mensagem) {
        this.mensagem = mensagem;
    }
}
