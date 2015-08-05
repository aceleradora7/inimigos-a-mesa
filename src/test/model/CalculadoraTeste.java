package model;

import br.com.aceleradora.inimigosamesa.model.Alimento;
import br.com.aceleradora.inimigosamesa.model.Calculadora;
import br.com.aceleradora.inimigosamesa.model.Categoria;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.assertEquals;

/**
 * Created by aluno03 on 05/08/15.
 */
public class CalculadoraTeste {

    Calculadora calculadora = new Calculadora();

    @Test
    public void QuandoPassamosUmAlimentoEntaoRetornaOProprioValor() throws Exception {

        Calculadora calculadora = new Calculadora();
        List<Alimento> valorEsperado = new ArrayList<Alimento>();
        List<Alimento> valorRetornado = calculadora.getListaDeAlimentos();
        assertEquals("Não deve retornar null:",valorEsperado,valorRetornado);
    }

    @Test
    public  void adicionaAlimentoTeste(){
        Calculadora calculadora = new Calculadora();
        Alimento alimento = new Alimento("abacate", "0", "0", "10", "0", "100", "0", "100", "0", "0", "0", "0", new Categoria(1),"","");

        calculadora.adicionaAlimento(alimento);

        boolean valorEsperado = false;
        boolean valoRetornado = calculadora.adicionaAlimento(alimento);

        assertEquals("Retorna false se ja existir o alimento: ",valorEsperado,valoRetornado);

        Alimento alimento2 = new Alimento("Abacaxi", "0", "0", "10", "0", "100", "0", "100", "0", "0", "0", "0", new Categoria(1),"","");
        alimento.setCodigo(3);
        valorEsperado = true;
        valoRetornado = calculadora.adicionaAlimento(alimento2);

        assertEquals("Retorna true se o alimento poder ser adicionado: ",valorEsperado,valoRetornado);
//
//        calculadora = new Calculadora();
//        calculadora.adicionaAlimento(alimento);
    }
}
