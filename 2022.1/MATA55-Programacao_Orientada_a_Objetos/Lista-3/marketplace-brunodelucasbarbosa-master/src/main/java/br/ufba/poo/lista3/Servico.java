package br.ufba.poo.lista3;

import java.util.ArrayList;
import java.util.Collection;

public class Servico implements ItemDeVenda {

    private String nome;

    private double preco;

    public Servico(String nome, double preco) {
        super();
        this.nome = nome;
        this.preco = preco;
    }

    @Override
    public double getPreco() {
        return preco;
    }

    @Override
    public String getNome() {
        return nome;
    }
}

