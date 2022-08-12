package br.ufba.poo.lista2;

import static br.ufba.designjudge.DesignJudge.field;
import static br.ufba.designjudge.DesignJudge.klass;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import java.lang.reflect.Modifier;
import org.junit.Test;
import br.ufba.designjudge.elems.ClassElement;
import br.ufba.designjudge.elems.Element;

public class RetangulosTest {

    private String pkg = getClass().getPackageName();

    @Test
    public void testPontoToString() {
        Ponto p = new Ponto(5, 4);
        String result = p.toString();
        assertEquals("(5.0,4.0)", result);
    }

    @Test
    public void testDimensaoToString() {
        Dimensao d = new Dimensao(3, 4);
        String result = d.toString();
        assertEquals("l:3.0 - a:4.0", result);
    }

    @Test
    public void testRetanguloToString() {
        Ponto p = new Ponto(5, 4);
        Dimensao d = new Dimensao(3, 4);
        Retangulo r = new Retangulo(p, d);
        assertEquals("(5.0,4.0) l:3.0 - a:4.0", r.toString());
    }
}

