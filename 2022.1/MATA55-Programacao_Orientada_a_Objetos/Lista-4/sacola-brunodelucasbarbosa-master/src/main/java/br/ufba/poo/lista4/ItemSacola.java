package br.ufba.poo.lista4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Item de uma sacola de compras, com nome e preço.
 */
public class ItemSacola {

    private String nome;

    private double preco;

    public ItemSacola(String nome, double preco) {
        super();
        this.nome = nome;
        this.preco = preco;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }
}

