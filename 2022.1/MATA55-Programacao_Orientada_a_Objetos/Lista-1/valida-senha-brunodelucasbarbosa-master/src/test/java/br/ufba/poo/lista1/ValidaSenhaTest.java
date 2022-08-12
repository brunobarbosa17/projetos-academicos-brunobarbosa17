package br.ufba.poo.lista1;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class ValidaSenhaTest {

    @Test
    public void objetosDiferentes() {
        assertFalse(ValidaSenha.validaSenha("abcd", "qwerty"));
    }
}

