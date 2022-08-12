package br.ufba.poo.lista2;

import static br.ufba.designjudge.DesignJudge.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import br.ufba.designjudge.elems.ClassElement;
import br.ufba.designjudge.elems.ConstructorElement;

public class ContaTest {

    private String pkg = getClass().getPackageName();

    private ClassElement contaClass = klass(pkg + ".Conta");

    private ConstructorElement contaCtor2 = contaClass.get(constructor().withParameters(String.class, double.class)).asConstructor();

    @Test
    public void testExisteConstrutorComCodigoESaldo() throws NoSuchMethodException, SecurityException {
        contaCtor2.mustExist();
    }

    @Test
    public void testChecaAtributosDoConstrutorComDoisParametros() {
        Conta conta = (Conta) contaCtor2.call("123", 3.14);
        assertEquals("123", conta.getCodigo());
        assertEquals(3.14, conta.getSaldo(), 0.001);
    }

    @Test
    public void testRetiraQuandoTemSaldo() {
        Conta conta = (Conta) contaCtor2.call("123", 100.0);
        assertTrue(conta.retira(60.0));
        assertEquals(40.0, conta.getSaldo(), 0.001);
    }
}

