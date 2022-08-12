package br.ufba.poo.lista2;

import java.util.Objects;

public class Ponto {

    private double x;
    private double y;

    public Ponto(double x, double y) {
        this.x = x;
        this.y = y;
    }

    public double getX() {
        return x;
    }

    public void setX(double x) {
        this.x = x;
    }

    public double getY() {
        return y;
    }

    public void setY(double y) {
        this.y = y;
    }

    @Override
    public String toString() {
        return "(" + this.x + "," + this.y + ")";
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Ponto)) return false;
        Ponto ponto = (Ponto) o;
        return Double.compare(ponto.getX(), getX()) == 0 && Double.compare(ponto.getY(), getY()) == 0;
    }

}

