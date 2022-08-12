package br.ufba.poo.lista2;

import org.jetbrains.annotations.NotNull;

import java.util.HashMap;
import java.util.Objects;

public class Retangulo {

    private double x;
    private double y;
    private double largura;
    private double altura;

    public Retangulo(double x, double y, double largura, double altura) {
        this.x = x;
        this.y = y;
        this.largura = largura;
        this.altura = altura;
    }

    public Retangulo(Ponto ponto, Dimensao dimensao) {
        this.x = ponto.getX();
        this.y = ponto.getY();
        this.largura = dimensao.getLargura();
        this.altura = dimensao.getAltura();
    }

    public double getPerimetro() {
        return (this.largura + this.altura) * 2;
    }

    public double getArea() {
        return this.largura * this.altura;
    }

    public Ponto getOrigem() {
        return new Ponto(this.x, this.y);
    }

    public Dimensao getDimensao() {
        return new Dimensao(this.largura, this.altura);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Retangulo)) return false;
        Retangulo retangulo1 = (Retangulo) o;
        //return retangulo.equals(retangulo1.retangulo);
        //return this.getDimensao().equals(retangulo1.getDimensao()) &&
        //        this.getOrigem().equals(retangulo1.getOrigem());

        return this.x == retangulo1.getX() &&
                this.y == retangulo1.getY() &&
                this.largura == retangulo1.getLargura() &&
                this.altura == retangulo1.getAltura();
    }

//    public boolean equals(@NotNull Retangulo retangulo) {
//        this.retangulo = retangulo;
//        return retangulo.getDimensao() == this.getDimensao() && retangulo.getOrigem() == this.getOrigem();
//    }

    public boolean equivalente(Retangulo r) {
        return r.getArea() == this.getArea();
    }

    public String toString() {
        return "(" + this.x + "," + this.y + ")" + " l:" + this.largura + " - a:" + this.altura;
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
}

