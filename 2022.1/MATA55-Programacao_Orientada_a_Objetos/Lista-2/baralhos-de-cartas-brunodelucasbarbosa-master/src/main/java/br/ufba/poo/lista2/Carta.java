package br.ufba.poo.lista2;

public class Carta {

    private int numero;
    private char naipe;

    public Carta(int numero, char naipe) {
        this.numero = numero;
        this.naipe = naipe;
    }

    public int getNumero() {
        return numero;
    }

    public char getNaipe() {
        return naipe;
    }

    public String toString() {
        StringBuilder retorno = new StringBuilder();
        retorno.append(numero);
        retorno.append(naipe);
        return retorno.toString();
    }
}

