package br.com.aceleradora.inimigosamesa.model;

public enum Role {

    USER("USER"), ADMIN("ADMIM");
    private String value;
    private Role(String value) {
        this.value = value;
    }
    public String getValue() {
        return value;
    }
}