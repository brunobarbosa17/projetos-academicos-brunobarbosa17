package br.ufba.poo.lista3;

import java.util.ArrayList;
import java.util.Collection;

public class Produto implements ItemDeVenda {

    private String nome;

    private double preco;

    private boolean ehNovo;

    public Produto(){}

    public Produto(String nome, double preco, boolean ehNovo) {
        super();
        this.nome = nome;
        this.preco = preco;
        this.ehNovo = ehNovo;
    }

    @Override
    public double getPreco() {
        return preco;
    }

    @Override
    public String getNome() {
        return nome;
    }

    public boolean isNovo() {
        return ehNovo;
    }
}

