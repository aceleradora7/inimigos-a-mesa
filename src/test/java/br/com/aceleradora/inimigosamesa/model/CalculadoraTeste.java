package br.com.aceleradora.inimigosamesa.model;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by aluno03 on 05/08/15.
 */
public class CalculadoraTeste {

    Calculadora calculadora = new Calculadora();
    Alimento alimento1 = new Alimento();
    Alimento alimento2 = new Alimento();

    @Before
    public void setUp() throws Exception {
        alimento1.setCodigo(1);
        alimento1.setCalorias("10");
        alimento1.setGordura("30");
        alimento1.setSodio("50");
        alimento1.setAcucar("70");

        alimento2.setCodigo(2);
        alimento2.setCalorias("20");
        alimento2.setGordura("40");
        alimento2.setSodio("90");
        alimento2.setAcucar("140");
    }

    @Test
    public void QuandoPassamosUmAlimentoNaCalculadoraEntaoRetornaAQuantidadeDeCaloriaEGorduraDesseAlimento() throws Exception {
        calculadora.adicionaAlimento(alimento1);

        assertEquals("Deve retornar a quantidade de caloria do unico alimento ", 10, calculadora.getCaloriasTotal(), 1);
        assertEquals("Deve retornar a quantidade de gordura do unico alimento ", 30, calculadora.getGorduraTotal(), 1);
        assertEquals("Deve retornar a quantidade de sodio convertido em sal do unico alimento ", 0.12, calculadora.getSalTotal(), 1);
        assertEquals("Deve retornar a quantidade de acucar do unico alimento ", 70, calculadora.getAcucarTotal(), 1);
    }

    @Test
    public void QuandoPassamosDoisAlimentosNaCalculadoraEntaoRetornaASomaDaQuantidadeDeCaloriaDosDoisAlimentos() throws Exception {
        calculadora.adicionaAlimento(alimento1);
        calculadora.adicionaAlimento(alimento2);

        assertEquals("Deve retornar a soma de caloria total dos dois alimentos ", 30, calculadora.getCaloriasTotal(), 1);
        assertEquals("Deve retornar a soma de gordura total dos dois alimentos ", 70, calculadora.getGorduraTotal(), 1);
        assertEquals("Deve retornar a soma de sodio convertido em sal total dos dois alimentos ", 0.35, calculadora.getSalTotal(), 1);
        assertEquals("Deve retornar a soma de acucar total dos dois alimentos ", 210, calculadora.getAcucarTotal(), 1);
    }

}
