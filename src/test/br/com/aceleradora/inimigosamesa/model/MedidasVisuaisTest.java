package br.com.aceleradora.inimigosamesa.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

/**
 * Created by aluno04 on 06/08/15.
 */
public class MedidasVisuaisTest {

    @Test
    public void verificaColherSeForVazioRetornaTrue() throws Exception {
        MedidasVisuais medidasVisuais = new MedidasVisuais(new Alimento());
        assertTrue(medidasVisuais.verificaColherVazia(""));
    }

    @Test
    public void verificaColherSeForNullRetornaTrue() throws Exception {
        MedidasVisuais medidasVisuais = new MedidasVisuais(new Alimento());
        assertTrue(medidasVisuais.verificaColherVazia(null));
    }

    @Test
    public void verificaColherSeForLetraRetornaFalse() throws Exception {
        MedidasVisuais medidasVisuais = new MedidasVisuais(new Alimento());
        assertTrue(!medidasVisuais.verificaColherVazia("teste"));
    }

    @Test
    public void verificaSeColherSalForNullRetornaZero() throws Exception {
        Alimento alimento = new Alimento();
        alimento.setPorcaoExibicao("5");
        alimento.setPorcaoBaseCalculo("2");
        alimento.setSodio(null);
        MedidasVisuais medidasVisuais = new MedidasVisuais(alimento);
        assertEquals(medidasVisuais.calculaColherSal(), 0);
    }

    @Test
    public void verificaColherSalSeForVaziaRetornaZero() throws Exception {
        MedidasVisuais medidasVisuais = new MedidasVisuais(new Alimento());
        assertEquals(medidasVisuais.calculaColherSal(), 0);
    }

    @Test
    public void verificaSeColherSalNaoForVaziaRetornaQuantidadeDeColher() throws Exception {
        Alimento alimento = new Alimento();
        alimento.setPorcaoExibicao("5");
        alimento.setPorcaoBaseCalculo("2");
        alimento.setSodio("1000");
        MedidasVisuais medidasVisuais = new MedidasVisuais(alimento);
        assertEquals(medidasVisuais.calculaColherSal(), 3);
    }

    @Test
    public void verificaSeColherAcucarForNullRetornaZero() throws Exception {
        Alimento alimento = new Alimento();
        alimento.setPorcaoExibicao("5");
        alimento.setPorcaoBaseCalculo("2");
        alimento.setAcucar(null);
        MedidasVisuais medidasVisuais = new MedidasVisuais(alimento);
        assertEquals(medidasVisuais.calculaColherAcucar(), 0);
    }

    @Test
    public void verificaColherAcucarSeForVaziaRetornaZero() throws Exception {
        MedidasVisuais medidasVisuais = new MedidasVisuais(new Alimento());
        assertEquals(medidasVisuais.calculaColherAcucar(), 0);
    }

    @Test
    public void verificaSeColherAcucarNaoForVaziaRetornaQuantidadeDeColher() throws Exception {
        Alimento alimento = new Alimento();
        alimento.setPorcaoExibicao("5");
        alimento.setPorcaoBaseCalculo("2");
        alimento.setAcucar("3");
        MedidasVisuais medidasVisuais = new MedidasVisuais(alimento);
        assertEquals(medidasVisuais.calculaColherAcucar(), 4);
    }

    @Test
    public void verificaSeColherGorduraForNullRetornaZero() throws Exception {
        Alimento alimento = new Alimento();
        alimento.setPorcaoExibicao("5");
        alimento.setPorcaoBaseCalculo("2");
        alimento.setGordura(null);
        MedidasVisuais medidasVisuais = new MedidasVisuais(alimento);
        assertEquals(medidasVisuais.calculaColherGordura(), 0);
    }

    @Test
    public void verificaColherGorduraSeForVaziaRetornaZero() throws Exception {
        MedidasVisuais medidasVisuais = new MedidasVisuais(new Alimento());
        assertEquals(medidasVisuais.calculaColherGordura(), 0);
    }

    @Test
    public void verificaSeColherGorduraNaoForVaziaRetornaQuantidadeDeColher() throws Exception {
        Alimento alimento = new Alimento();
        alimento.setPorcaoExibicao("5");
        alimento.setPorcaoBaseCalculo("2");
        alimento.setGordura("3");
        MedidasVisuais medidasVisuais = new MedidasVisuais(alimento);
        assertEquals(medidasVisuais.calculaColherGordura(), 3);
    }

}