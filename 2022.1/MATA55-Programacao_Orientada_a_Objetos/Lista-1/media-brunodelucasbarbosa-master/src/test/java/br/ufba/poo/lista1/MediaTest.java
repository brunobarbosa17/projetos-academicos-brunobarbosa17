package br.ufba.poo.lista1;

import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class MediaTest {

    public static final double delta = 0.001;

    @Test
    public void doisValoresIguais() {
        assertEquals(3.0, Media.media(3.0, 3.0), delta);
    }
}

