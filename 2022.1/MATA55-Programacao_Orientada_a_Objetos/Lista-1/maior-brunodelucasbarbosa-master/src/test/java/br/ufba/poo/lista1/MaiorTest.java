package br.ufba.poo.lista1;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class MaiorTest {

    @Test
    public void doMeioEhMaior() {
        int[] array = { 6, 3, 5, 100, 7, 3, 8 };
        int maior = Maior.maior(array);
        assertEquals(100, maior);
    }
}

