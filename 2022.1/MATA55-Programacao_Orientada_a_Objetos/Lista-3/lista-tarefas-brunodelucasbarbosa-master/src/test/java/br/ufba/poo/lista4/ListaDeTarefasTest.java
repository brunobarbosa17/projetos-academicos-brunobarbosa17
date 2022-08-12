package br.ufba.poo.lista4;

import static br.ufba.designjudge.DesignJudge.klass;
import static br.ufba.designjudge.DesignJudge.method;
import static br.ufba.designjudge.DesignJudge.methods;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.fail;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import org.junit.Test;
import com.github.javaparser.ast.CompilationUnit;
import com.github.javaparser.ast.body.ClassOrInterfaceDeclaration;
import com.github.javaparser.ast.body.MethodDeclaration;
import com.github.javaparser.ast.expr.MethodCallExpr;
import com.github.javaparser.ast.visitor.VoidVisitorAdapter;
import com.github.javaparser.utils.SourceRoot;
import br.ufba.designjudge.DesignJudge;
import br.ufba.designjudge.elems.ClassElement;
import br.ufba.designjudge.exception.JudgeException;

public class ListaDeTarefasTest {

    private String pkg = getClass().getPackageName();

    private ClassElement classLista = klass(pkg + ".ListaDeTarefas");

    private ClassElement classListaAuth = klass(pkg + ".ListaDeTarefasComAutenticacao");

    public ListaDeTarefasComAutenticacao newListaAuth(String nome) {
        return (ListaDeTarefasComAutenticacao) classListaAuth.asClass().instantiate(nome);
    }

    @Test
    public void testAcessoAdmin() {
        ListaDeTarefasComAutenticacao lista = newListaAuth("Nome");
        lista.autentica("admin");
        int id = lista.adiciona("Consertar torneira");
        lista.atualiza(id, "Trocar torneira");
        lista.remove(id);
        lista.toString();
    }

    @Test
    public void testGuestNaoPodeAdicionar() {
        ListaDeTarefasComAutenticacao lista = newListaAuth("Nome");
        lista.autentica("guest");
        try {
            classListaAuth.get(method("adiciona")).asMethod().call(lista, "Consertar torneira");
            fail();
        } catch (JudgeException e) {
            assertTrue(e.getCause().getCause().getClass() == AutorizacaoException.class);
        }
    }

    @Test
    public void testGuestNaoPodeAtualizar() {
        ListaDeTarefasComAutenticacao lista = newListaAuth("Nome");
        lista.autentica("guest");
        try {
            classListaAuth.get(method("atualiza")).asMethod().call(lista, 1, "Consertar");
            fail();
        } catch (JudgeException e) {
            assertTrue(e.getCause().getCause().getClass() == AutorizacaoException.class);
        }
    }

    @Test
    public void testGuestNaoPodeRemover() {
        ListaDeTarefasComAutenticacao lista = newListaAuth("Nome");
        lista.autentica("guest");
        try {
            classListaAuth.get(method("remove")).asMethod().call(lista, 1);
            fail();
        } catch (JudgeException e) {
            assertTrue(e.getCause().getCause().getClass() == AutorizacaoException.class);
        }
    }

    @Test
    public void testGuestPodeVisualizar() {
        ListaDeTarefasComAutenticacao lista = newListaAuth("Nome");
        lista.autentica("guest");
        lista.toString();
    }

    @Test
    public void testAnonimoPodeVerContagem() {
        ListaDeTarefasComAutenticacao lista = newListaAuth("Nome");
        lista.autentica("ninguem");
        classListaAuth.get(method("getTamanho")).asMethod().call(lista);
    }
}

