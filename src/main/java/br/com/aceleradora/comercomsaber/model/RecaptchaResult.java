package br.com.aceleradora.comercomsaber.model;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class RecaptchaResult {
    public boolean success;
}
