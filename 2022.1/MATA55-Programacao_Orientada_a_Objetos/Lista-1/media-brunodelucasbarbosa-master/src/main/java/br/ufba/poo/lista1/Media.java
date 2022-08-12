package br.ufba.poo.lista1;

public class Media {

    /**
     * Retorna a média aritmética entre dois números.
     *
     * @param a primeiro número
     * @param b segundo número
     * @return a média aritmética entre <code>a</code> e <code>b</b>
     */
    public static double media(double a, double b) {
        return (a + b) / 2;
    }

    public static void main(String[] args) {
        System.out.println(media(20, 20));
    }
}

