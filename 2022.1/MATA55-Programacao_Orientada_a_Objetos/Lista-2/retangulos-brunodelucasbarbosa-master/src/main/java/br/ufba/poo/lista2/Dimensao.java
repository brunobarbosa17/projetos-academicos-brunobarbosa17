package br.ufba.poo.lista2;

import java.util.Objects;

public class Dimensao {

    private double largura;
    private double altura;

    public Dimensao(double largura, double altura) {
        this.largura = largura;
        this.altura = altura;
    }

    public double getLargura() {
        return largura;
    }

    public void setLargura(double largura) {
        this.largura = largura;
    }

    public double getAltura() {
        return altura;
    }

    public void setAltura(double altura) {
        this.altura = altura;
    }

    @Override
    public String toString() {
        return "l:" + this.largura + " - a:" + this.altura ;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Dimensao)) return false;
        Dimensao dimensao = (Dimensao) o;
        return Double.compare(dimensao.getLargura(), getLargura()) == 0 && Double.compare(dimensao.getAltura(), getAltura()) == 0;
    }

}

