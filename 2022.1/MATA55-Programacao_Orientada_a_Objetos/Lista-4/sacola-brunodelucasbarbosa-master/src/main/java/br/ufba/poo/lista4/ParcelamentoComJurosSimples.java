package br.ufba.poo.lista4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * No parcelamento com juros simples, a taxa efetiva é sempre a mesma,
 * independente do mês.
 */
public class ParcelamentoComJurosSimples extends Parcelamento {

    public ParcelamentoComJurosSimples(double taxa, int meses) {
        super(taxa, meses);
    }

    @Override
    public double taxaEfetivaNoMes(int mes) {
        return taxa;
    }
}

