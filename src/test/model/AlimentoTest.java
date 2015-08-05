package model;

import br.com.aceleradora.inimigosamesa.model.Alimento;
import br.com.aceleradora.inimigosamesa.model.Categoria;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by mentores on 29/07/15.
 */
public class AlimentoTest {

    @Test
    public void quandoValorForIgualANullEntaoRetornaOMesmoValor() throws Exception {
        Alimento alimento = new Alimento("abacate", "0", "0", null, "0", "0", "0", "0", "0", "0", "0", "0", new Categoria(1),"","");

        String valorEsperado = null;
        String valorRetornado = alimento.calculaExibicao(alimento.getGordura());

        assertEquals(valorEsperado, valorRetornado);
    }

    @Test
    public void quandoValorForIgualAVazioEntaoRetornaOMesmoValor() throws Exception {
        Alimento alimento = new Alimento("abacate", "0", "0", "", "0", "0", "0", "0", "0", "0", "0", "0", new Categoria(1),"","");

        String valorEsperado = "";
        String valorRetornado = alimento.calculaExibicao(alimento.getGordura());

        assertEquals(valorEsperado, valorRetornado);
    }

    @Test
    public void quandoPorcaoExibicaoForIgualAPorcaoBaseCalculoEntaoRetornaOMesmoValor() throws Exception {
        Alimento alimento = new Alimento("abacate", "0", "0", "10", "0", "100", "0", "100", "0", "0", "0", "0", new Categoria(1),"","");

        String valorEsperado = "10";
        String valorRetornado = alimento.calculaExibicao(alimento.getGordura());

        assertEquals(valorEsperado, valorRetornado);
    }

    @Test
    public void quandoPorcaoExibicaoForMenorQueAPorcaoBaseCalculoEntaoCalculaOValorASerExibido() throws Exception {
        Alimento alimento = new Alimento("abacate", "0", "0", "10", "0", "100", "0", "70", "0", "0", "0", "0", new Categoria(1),"","");

        String valorEsperado = "7.0";
        String valorRetornado = alimento.calculaExibicao(alimento.getGordura());

        assertEquals(valorEsperado, valorRetornado);
    }

    @Test
    public void quandoPorcaoExibicaoForMaiorQueAPorcaoBaseCalculoEntaoCalculaOValorASerExibido() throws Exception {
        Alimento alimento = new Alimento("abacate", "0", "0", "10", "0", "100", "0", "200", "0", "0", "0", "0", new Categoria(1),"","");

        String valorEsperado = "20.0";
        String valorRetornado = alimento.calculaExibicao(alimento.getGordura());

        assertEquals(valorEsperado, valorRetornado);
    }

    @Test
    public void quandoPorcaoBaseDeCalculoForNullEntaoRetornaFalse() throws Exception {
        Alimento alimento = new Alimento("abacate", "0", "0", "10", "0", null, "0", "200", "0", "0", "0", "0", new Categoria(1),"","");

        assertTrue(!alimento.temLetraPorcaoBaseCalculo());
    }

    @Test
    public void quandoPorcaoBaseDeCalculoForVaziaEntaoRetornaFalse() throws Exception {
        Alimento alimento = new Alimento("abacate", "0", "0", "10", "0", null, "0", "200", "0", "0", "0", "0", new Categoria(1),"","");

        assertTrue(!alimento.temLetraPorcaoBaseCalculo());
    }


/*

     Método testado
    public  boolean temLetraPorcaoBaseCalculo(){
        if(getPorcaoBaseCalculo()!=null && !getPorcaoBaseCalculo().isEmpty()){
            try {
                Double.parseDouble(getPorcaoBaseCalculo());
            }catch(Exception e){
                return true;
            }
        }
        return false;
    }
*/


}
