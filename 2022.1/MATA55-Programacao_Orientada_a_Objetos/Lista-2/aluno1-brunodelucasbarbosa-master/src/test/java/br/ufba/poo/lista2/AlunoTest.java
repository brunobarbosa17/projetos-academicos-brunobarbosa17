package br.ufba.poo.lista2;

import static br.ufba.designjudge.DesignJudge.*;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotEquals;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Modifier;
import org.junit.Test;
import br.ufba.designjudge.elems.ClassElement;
import br.ufba.designjudge.elems.ConstructorElement;

public class AlunoTest {

    private String pkg = getClass().getPackageName();

    private ClassElement classAluno = klass(pkg + ".Aluno");

    private ConstructorElement alunoConstructor = classAluno.get(constructor().withParameterCount(2)).asConstructor();

    @Test
    public void atributos() {
        classAluno.mustExist();
        classAluno.mustHave(fields("matricula", "nome"));
    }

    @Test
    public void construtores() throws ClassNotFoundException {
        alunoConstructor.mustExist();
    }

    @Test
    public void igualdade1() throws InstantiationException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException, SecurityException {
        assertEquals(alunoConstructor.call("123", "abc"), alunoConstructor.call("123", "abc"));
    }

    @Test
    public void igualdade3() throws InstantiationException, IllegalAccessException, ClassNotFoundException, IllegalArgumentException, InvocationTargetException, SecurityException {
        assertNotEquals(alunoConstructor.call("123", "abc"), alunoConstructor.call("456", "abc"));
    }
}

