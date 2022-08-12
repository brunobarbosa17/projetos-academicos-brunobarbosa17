package br.ufba.poo.lista2;

import static br.ufba.designjudge.DesignJudge.field;
import static br.ufba.designjudge.DesignJudge.klass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import java.lang.reflect.Modifier;
import org.junit.Test;
import br.ufba.designjudge.elems.ClassElement;
import br.ufba.designjudge.elems.Element;

public class BaralhosDeCartasTest {

    private String pkg = getClass().getPackageName();

    private String baralhoStr = "1e 2e 3e 4e 5e 6e 7e 8e 9e 10e 11e 12e 13e 1p 2p 3p 4p 5p 6p 7p 8p 9p 10p 11p 12p 13p 1c 2c 3c 4c 5c 6c 7c 8c 9c 10c 11c 12c 13c 1o 2o 3o 4o 5o 6o 7o 8o 9o 10o 11o 12o 13o";

    @Test
    public void testBaralhoToString() {
        Baralho b = new Baralho();
        String result = b.toString().trim();
        assertEquals(baralhoStr, result);
    }

    @Test
    public void testEmbaralhaRetornaCartas() {
        // verifico se o metodo embaralha reseta a posição
        Baralho b = new Baralho();
        String c = b.cava().toString();
        assertEquals("1e", c);
        c = b.cava().toString();
        assertEquals("2e", c);
        b.embaralha();
        for (int i = 0; i < 52; i++) assertTrue(b.cava() != null);
        assertTrue(b.cava() == null);
    }

    @Test
    public void testEmbaralhaPossuiTodasAsCartasSemDuplicatas() {
        Baralho b = new Baralho();
        b.embaralha();
        b.embaralha();
        String stringEmbaralhada = b.toString().trim();
        assertEquals(baralhoStr.length(), stringEmbaralhada.length());
        for (String cartaStr : baralhoStr.split(" ")) {
            assertTrue(stringEmbaralhada.contains(cartaStr));
        }
    }

    @Test
    public void testEmbaralhaResultaEmOrdensDiferentes() {
        Baralho b = new Baralho();
        b.embaralha();
        String s1 = b.toString();
        b.embaralha();
        String s2 = b.toString();
        assertNotEquals(s1, s2);
    }
}

