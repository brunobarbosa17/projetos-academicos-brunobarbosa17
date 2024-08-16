package br.ufba.poo.lista3;

public class Cachorro extends Animal {
    Cachorro(String nome) {
        super(nome);
    }

    void fazerSom() {
        System.out.println("Au Au!");
    }
}