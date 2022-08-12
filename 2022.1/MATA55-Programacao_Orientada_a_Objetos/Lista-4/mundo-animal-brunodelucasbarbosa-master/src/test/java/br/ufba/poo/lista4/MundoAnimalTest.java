package br.ufba.poo.lista4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import java.lang.reflect.Modifier;
import org.junit.Test;

public class MundoAnimalTest {

    @Test
    public void todasAsClassesEInterfacesForamCriadas() {
        String pkg = getClass().getPackageName();
        try {
            Class.forName(pkg + ".Animal");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Animal nao encontrado.");
        }
        try {
            Class.forName(pkg + ".Mamifero");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Mamifero nao encontrado.");
        }
        try {
            Class.forName(pkg + ".Ave");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Ave nao encontrada.");
        }
        try {
            Class.forName(pkg + ".Cachorro");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Cachorro nao encontrado.");
        }
        try {
            Class.forName(pkg + ".Gato");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Gato nao encontrado.");
        }
        try {
            Class.forName(pkg + ".Pato");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("Pato nao encontrado.");
        }
        try {
            Class.forName(pkg + ".BemTeVi");
        } catch (ClassNotFoundException e) {
            throw new RuntimeException("BemTeVi nao encontrado.");
        }
    }

    @Test
    public void testaNascimentos() {
        Cachorro p = new Cachorro();
        assertEquals("Nascendo do ventre da mae...", p.nasce());
        BemTeVi b = new BemTeVi();
        assertEquals("Nascendo do ovo...", b.nasce());
    }
}

