package br.ufba.poo.lista2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Objects;

public class Baralho {

    private ArrayList<Carta> carta;
    private int tamanhoAtual = 52;
    private int qntdsCavados = 0;

    public Baralho() {
        organizarBaralho();
    }

    public String toString() {
        StringBuilder cartas = new StringBuilder();
        carta.forEach(carta1 -> cartas.append(carta1 + " "));
        return cartas.toString();
    }

    public void embaralha() {
        carta.clear();
        organizarBaralho();
        Collections.shuffle(carta);
    }

    public Carta cava() {
        if (tamanhoAtual > 0) {
            tamanhoAtual -= 1;
            return carta.get(qntdsCavados++);
        }
        return null;
    }

    private void organizarBaralho() {
        this.tamanhoAtual = 52;
        this.qntdsCavados = 0;
        carta = new ArrayList<Carta>();
        for (int i = 1; i <= 13; i++) {
            carta.add(new Carta(i, 'e'));
        }
        for (int i = 1; i <= 13; i++) {
            carta.add(new Carta(i, 'p'));
        }
        for (int i = 1; i <= 13; i++) {
            carta.add(new Carta(i, 'c'));
        }
        for (int i = 1; i <= 13; i++) {
            carta.add(new Carta(i, 'o'));
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Baralho)) return false;
        Baralho baralho = (Baralho) o;
        return carta.equals(baralho.carta);
    }


}

