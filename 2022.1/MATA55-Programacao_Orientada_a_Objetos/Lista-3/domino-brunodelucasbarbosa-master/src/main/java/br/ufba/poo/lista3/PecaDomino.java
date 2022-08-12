package br.ufba.poo.lista3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

/**
 * Uma peça de dominó possui dois números.
 * Após criada, a peça não pode ser modificada.
 * TODO: Complete a implementação dos métodos e construtores abaixo.
 */
public class PecaDomino {

    private Collection<Integer> numeros = new ArrayList<Integer>();

    /**
     * TODO: implementar
     * Cria uma peça de dominó com os números n1 e n2.
     * Não é feita nenhuma verificação sobre os valores
     * de n1 e n2.
     * @param n1 primeiro número
     * @param n2 segundo número
     */
    public PecaDomino(int n1, int n2) {
        numeros.add(n1);
        numeros.add(n2);
        //Collection<Integer> listaImutavel = Collections.unmodifiableCollection(numeros);
        numeros = Collections.unmodifiableCollection(numeros);
    }

    /**
     * TODO: implementar. Atenção: um objeto que receba o retorno
     * deste método não deve ser capaz de alterar os números desta
     * peça.
     * Veja o caso de teste testImutabilidade na classe PecaDominoTest
     *
     * Obtém os números da peça, como uma coleção de
     * dois elementos.
     * @return Collection com os números da peça
     */
    public Collection<Integer> getNumeros() {
        return numeros;
    }

    /**
     * TODO: implementar
     * Indica se a peça possui o número indicado
     * @param n número buscado
     * @return true, se a peça contém o número;
     *         false, caso contrário.
     */
    public boolean possuiNumero(int n) {
        return numeros.contains(n);
    }


    /**
     * Exemplo de uso da classe
     */
    public static void main(String[] args) {
        PecaDomino d1 = new PecaDomino(6, 6);
        PecaDomino d2 = new PecaDomino(6, 2);
        System.out.println(d1.getNumeros());
        if (d2.possuiNumero(2)) {
            System.out.println("Possui 6.");
        }
    }
}

