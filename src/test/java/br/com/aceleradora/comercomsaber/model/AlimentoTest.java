package br.com.aceleradora.comercomsaber.model;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by mentores on 29/07/15.
 */
public class AlimentoTest {

    @Test
    public void quandoAQuantidadeDeGorduraForIgualANullEntaoRetornaOMesmoValor() throws Exception {
        Alimento alimento = new Alimento();
        alimento.setGordura(null);
        String valorEsperado = null;
        String valorRetornado = alimento.calculaExibicao(alimento.getGordura());
        assertEquals(valorEsperado, valorRetornado);
    }

    @Test
    public void quandoAQuantidadeDeGorduraForIgualAVazioEntaoRetornaOMesmoValor() throws Exception {
        Alimento alimento = new Alimento();
        alimento.setGordura("");
        String valorEsperado = "";
        String valorRetornado = alimento.calculaExibicao(alimento.getGordura());
        assertEquals(valorEsperado, valorRetornado);
    }

    @Test
    public void quandoPorcaoExibicaoForIgualAPorcaoBaseCalculoEntaoRetornaOMesmoValor() throws Exception {
        Alimento alimento = new Alimento();
        alimento.setGordura("10");
        alimento.setPorcaoExibicao("5");
        alimento.setPorcaoBaseCalculo("5");
        String valorEsperado = "10";
        String valorRetornado = alimento.calculaExibicao(alimento.getGordura());
        assertEquals(valorEsperado, valorRetornado);
    }

    @Test
    public void quandoPorcaoExibicaoForMenorQueAPorcaoBaseCalculoEntaoCalculaOValorASerExibido() throws Exception {
        Alimento alimento = new Alimento();
        alimento.setGordura("4");
        alimento.setPorcaoExibicao("2");
        alimento.setPorcaoBaseCalculo("5");
        String valorEsperado = "1.60";
        String valorRetornado = alimento.calculaExibicao(alimento.getGordura());
        assertEquals(valorEsperado, valorRetornado);
    }

    @Test
    public void quandoPorcaoExibicaoForMaiorQueAPorcaoBaseCalculoEntaoCalculaOValorASerExibido() throws Exception {
        Alimento alimento = new Alimento();
        alimento.setGordura("4");
        alimento.setPorcaoExibicao("5");
        alimento.setPorcaoBaseCalculo("2");
        String valorEsperado = "10.00";
        String valorRetornado = alimento.calculaExibicao(alimento.getGordura());
        assertEquals(valorEsperado, valorRetornado);
    }

    @Test
    public void quandoOValorRecebidoForNullEntaoRetornaFalse() throws Exception {
        Alimento alimentoValida = new Alimento();
        assertTrue(!alimentoValida.validaValor(null));
    }

    @Test
    public void quandoOValorRecebidoForVazioEntaoRetornaFalse() throws Exception {
        Alimento alimentoValida = new Alimento();
        assertTrue(!alimentoValida.validaValor(""));
    }

    @Test
    public void quandoOValorRecebidoContemLetrantaoRetornaTrue() throws Exception {
        Alimento alimentoValida = new Alimento();
        assertTrue(alimentoValida.validaValor("nd"));
    }
}
