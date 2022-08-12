package br.ufba.poo.lista1;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class NomeTest {

    @Test
    public void testaExemplo() {
        Nome nome = new Nome();
        nome.setPrimeiroNome("Fulano");
        nome.setSobrenome("de Tal");
        assertEquals("Fulano de Tal", nome.getNomeCompleto());
    }
}

