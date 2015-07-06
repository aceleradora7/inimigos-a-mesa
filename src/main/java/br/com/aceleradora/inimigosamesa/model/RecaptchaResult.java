package br.com.aceleradora.inimigosamesa.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RecaptchaResult {
    public boolean success;
}
