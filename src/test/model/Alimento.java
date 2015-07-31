package model;

import br.com.aceleradora.inimigosamesa.model.Categoria;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 * Created by mentores on 29/07/15.
 */
public class Alimento {

    @Test
    public void testName() throws Exception {
        assertEquals(true, true);
    }

    @Test
    public void quandoValorForIgualANullEntaoRetornaOMesmoValor() throws Exception {
        br.com.aceleradora.inimigosamesa.model.Alimento alimento = new br.com.aceleradora.inimigosamesa.model.Alimento("abacate", "0", "0", null, "0", "0", "0", "0", "0", "0", "0", "0", new Categoria(1));

        String valorEsperado = null;
        String valorRetornado = alimento.calculaExibicao(alimento.getGordura());

        assertEquals(valorEsperado, valorRetornado);
    }

    @Test
    public void quandoValorForIgualAVazioEntaoRetornaOMesmoValor() throws Exception {
        br.com.aceleradora.inimigosamesa.model.Alimento alimento = new br.com.aceleradora.inimigosamesa.model.Alimento("abacate", "0", "0", "", "0", "0", "0", "0", "0", "0", "0", "0", new Categoria(1));

        String valorEsperado = "";
        String valorRetornado = alimento.calculaExibicao(alimento.getGordura());

        assertEquals(valorEsperado, valorRetornado);
    }

    @Test
    public void quandoPorcaoExibicaoForIgualAPorcaoBaseCalculoEntaoRetornaOMesmoValor() throws Exception {
        br.com.aceleradora.inimigosamesa.model.Alimento alimento = new br.com.aceleradora.inimigosamesa.model.Alimento("abacate", "0", "0", "10", "0", "100", "0", "100", "0", "0", "0", "0", new Categoria(1));

        String valorEsperado = "10";
        String valorRetornado = alimento.calculaExibicao(alimento.getGordura());

        assertEquals(valorEsperado, valorRetornado);
    }


    /* metodo testado
    public String calculaExibicao(String valor) {
        if (valor == null || valor.equals("") || Double.parseDouble(porcaoExibicao) == Double.parseDouble(porcaoBaseCalculo)) {
            return valor;
        } else {
            double calculoExibicaoSodio = 0.0;
            if (Double.parseDouble(porcaoExibicao) < Double.parseDouble(porcaoBaseCalculo)) {
                double numerador = Double.parseDouble(porcaoBaseCalculo) / Double.parseDouble(porcaoExibicao);
                calculoExibicaoSodio = Double.parseDouble(valor) / numerador;
            } else {
                double numerador = Double.parseDouble(porcaoExibicao) / Double.parseDouble(porcaoBaseCalculo);
                calculoExibicaoSodio = Double.parseDouble(valor) * numerador;
            }
            return String.valueOf(calculoExibicaoSodio);
        }
    }*/
}
