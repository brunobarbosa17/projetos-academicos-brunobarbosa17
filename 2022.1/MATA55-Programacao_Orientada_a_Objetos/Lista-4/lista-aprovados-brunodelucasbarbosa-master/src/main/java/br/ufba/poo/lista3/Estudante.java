package br.ufba.poo.lista3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Estudante implements Comparable {

    private String nome;

    private double nota;

    public Estudante(String nome, double nota) {
        super();
        this.nome = nome;
        this.nota = nota;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getNota() {
        return nota;
    }

    public void setNota(double nota) {
        this.nota = nota;
    }

    @Override
    public String toString() {
        return nota + " - " + nome;
    }

    @Override
    public int compareTo(Object o) {
        Estudante novoEstudante = (Estudante) o;
        if (this.getNota() > novoEstudante.getNota()) {
            return -1;
        } else {
            return 1;
        }

    }
}

