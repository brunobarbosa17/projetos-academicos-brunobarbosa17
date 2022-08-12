package br.ufba.poo.lista3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import org.junit.Test;

public class PecaDominoTest {

    @Test
    public void testGetNumeros() {
        PecaDomino domino = new PecaDomino(-50, 99);
        List<Integer> expected = Arrays.asList(-50, 99);
        List<Integer> result = new ArrayList<Integer>(domino.getNumeros());
        assertEquals(expected, result);
    }

    @Test
    public void testPossuiNumero() {
        PecaDomino domino = new PecaDomino(5, 6);
        assertTrue(domino.possuiNumero(5));
        assertTrue(domino.possuiNumero(6));
        assertFalse(domino.possuiNumero(0));
    }

    @Test
    public void testImutabilidade() {
        PecaDomino domino = new PecaDomino(5, 6);
        Collection<Integer> numeros = domino.getNumeros();
        try {
            numeros.remove(6);
            numeros.add(4);
        } catch (Exception e) {
        }
        List<Integer> expected = Arrays.asList(5, 6);
        List<Integer> result = new ArrayList<Integer>(domino.getNumeros());
        assertEquals(expected, result);
    }
}

