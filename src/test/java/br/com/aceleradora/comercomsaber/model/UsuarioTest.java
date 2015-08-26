package br.com.aceleradora.comercomsaber.model;

import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


/**
 * Created by aluno06 on 21/08/15.
 */
public class UsuarioTest {

    @Test
    public void verificaUsuarioSeForVazioRetornaTrue() throws Exception {


        Usuario usuario = new Usuario("Testonildo", "", "1234", 5);
        assertEquals("Testa se emeil do usuario esta vaziu: ", usuario.getEmail(), "");
    }
}
