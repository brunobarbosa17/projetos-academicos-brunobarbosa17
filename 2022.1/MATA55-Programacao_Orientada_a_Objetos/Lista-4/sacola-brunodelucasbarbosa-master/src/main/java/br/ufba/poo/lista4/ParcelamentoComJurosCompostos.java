package br.ufba.poo.lista4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * No parcelamento com juros compostos, a taxa no mês M é dada
 * pela seguinte expressão:
 *
 *   Math.pow(1 + taxa, M) - 1.0;
 */
public class ParcelamentoComJurosCompostos extends Parcelamento {

    public ParcelamentoComJurosCompostos(double taxa, int meses) {
        super(taxa, meses);
    }

    @Override
    public double taxaEfetivaNoMes(int mes) {
        return Math.pow(1 + taxa, mes) - 1.0;
    }
}

