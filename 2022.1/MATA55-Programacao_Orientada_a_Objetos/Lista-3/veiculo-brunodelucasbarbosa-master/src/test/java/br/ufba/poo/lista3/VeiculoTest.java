package br.ufba.poo.lista3;

import static br.ufba.designjudge.DesignJudge.klass;
import static br.ufba.designjudge.DesignJudge.method;
import static br.ufba.designjudge.DesignJudge.methods;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import br.ufba.designjudge.elems.ClassElement;

public class VeiculoTest {

    private String pkg = getClass().getPackageName();

    private ClassElement classVeiculo = klass(pkg + ".Veiculo");

    private ClassElement classCarro = klass(pkg + ".Carro");

    private ClassElement classMoto = klass(pkg + ".Moto");

    @Test
    public void existemAsTresClasses() throws ClassNotFoundException {
        classVeiculo.mustExist();
        classCarro.mustExist();
        classMoto.mustExist();
    }

    @Test
    public void asClassesContemOsMetodosCorretos() throws NoSuchFieldException, SecurityException {
        classVeiculo.mustHave(methods("acelerar", "frear"));
        classMoto.mustHave(methods("empinar"));
        classCarro.mustHave(methods("ligarArCondicionado"));
    }
}

