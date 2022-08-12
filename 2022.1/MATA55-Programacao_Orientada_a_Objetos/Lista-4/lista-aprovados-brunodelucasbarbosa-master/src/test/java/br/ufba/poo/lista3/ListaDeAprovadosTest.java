package br.ufba.poo.lista3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import org.junit.Test;
import org.mockito.Mockito;

public class ListaDeAprovadosTest {

    @Test
    public void testListaVazia() {
        ListaDeAprovados lista = new ListaDeAprovados();
        assertEquals(0, lista.getRanking().size());
    }

    @Test
    public void testOrdemDecrescente() {
        ListaDeAprovados lista = new ListaDeAprovados();
        Estudante a = new Estudante("A", 8.0);
        Estudante b = new Estudante("B", 7.0);
        Estudante c = new Estudante("C", 9.0);
        lista.addEstudante(a);
        lista.addEstudante(b);
        lista.addEstudante(c);
        List<Estudante> ranking = new ArrayList<>(lista.getRanking());
        List<Estudante> expected = Arrays.asList(c, a, b);
        assertEquals(expected, ranking);
    }
}

