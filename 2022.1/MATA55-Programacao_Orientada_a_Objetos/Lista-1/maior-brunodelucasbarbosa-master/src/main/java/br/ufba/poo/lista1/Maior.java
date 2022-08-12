package br.ufba.poo.lista1;

public class Maior {

    /**
     * Retorna o maior dos elementos de um array.
     *
     * @param elementos array de números inteiros
     * @return o valor do maior elemento, ou <code>Integer.MIN_VALUE</code> caso o
     *         array seja vazio
     */
    public static int maior(int[] elementos) {
        if (elementos.length == 0) {
            return -2147483648;
        } else {
            int max_value = elementos[0];
            for (int i : elementos) {
                if (i > max_value) {
                    max_value = i;
                }
            }
            return max_value;
        }
    }

    public static void main(String[] args) {
        int[] el = {5,6,1,90,3};
        System.out.println(maior(el));
    }
}

