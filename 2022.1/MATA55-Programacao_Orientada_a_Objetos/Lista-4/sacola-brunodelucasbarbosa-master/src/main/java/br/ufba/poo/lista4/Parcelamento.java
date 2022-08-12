package br.ufba.poo.lista4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Classe abstrata que calcula as parcelas para pagamento de uma dívida.
 *
 * O parcelamento possui uma taxa e um período, em meses.
 *
 * O cálculo das parcelas depende da taxa efetiva a cada mês, que por sua vez
 * pode variar de acordo com o método usado para calcular juros. Por exemplo,
 * com juros simples, a taxa é a mesma em todos os meses; já nos juros
 * compostos, a taxa vai aumentando ao longo do tempo.
 */
abstract public class Parcelamento {

    protected double taxa;

    protected int meses;

    public Parcelamento(double taxa, int meses) {
        this.taxa = taxa;
        this.meses = meses;
    }   

    public double[] getParcelas(double divida) {
        double[] parcelas = new double[meses];
        double parcelaInicial = divida / meses;
        for (int i = 0; i < meses; i++) {
            parcelas[i] = parcelaInicial * (1 + taxaEfetivaNoMes(i));
        }
        return parcelas;
    }

    public abstract double taxaEfetivaNoMes(int mes);

    @Override
    public String toString() {
        String[] r = getClass().getSimpleName().split("(?=\\p{Upper})");
        String nome = String.join(" ", r).toLowerCase();
        return nome + " de " + (taxa * 100) + "% a.m (" + meses + " meses)";
    }
}

