package br.ufba.poo.lista3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

import org.mockito.internal.util.collections.Iterables;

/**
 * Lista de estudantes aprovados em um processo seletivo.
 * Nessa lista é possível adicionar estudantes e, a partir
 * daí, imprimir o ranking dos estudantes, de acordo com a nota.
 * TODO: implemente o construtor; para isso, você precisará
 *       completar a implementação da classe NotaComparator.
 */
public class ListaDeAprovados extends Iterables {

    private List<Estudante> estudantes = new ArrayList<Estudante>();

    private Comparator<Estudante> comparator;

    /**
     * TODO: implementar
     * Instancia a lista de estudantes e o comparator (classe NotaComparator)
     */
    public ListaDeAprovados() {
    }

    public ListaDeAprovados(List<Estudante> estudantes, Comparator<Estudante> comparator) {
        this.estudantes = estudantes;
        this.comparator = comparator;

    }

    /**
     * Adiciona estudante à lista de aprovados
     * @param e estudante a adicionar
     */
    public void addEstudante(Estudante e) {
        estudantes.add(e);
    }

    /**
     * Retorna ranking de estudantes.
     * @return Coleção de estudantes em ordem DECRESCENTE de nota
     *         (da maior para a menor).
     */
    public Collection<Estudante> getRanking() {
        Collections.sort(estudantes, comparator);
        return Collections.unmodifiableCollection(estudantes);
    }

    /**
     * Código de exemplo
     */
    public static void main(String[] args) {
        ListaDeAprovados lista = new ListaDeAprovados();
        lista.addEstudante(new Estudante("A", 8.0));
        lista.addEstudante(new Estudante("B", 7.0));
        lista.addEstudante(new Estudante("C", 9.0));
        System.out.println(lista.getRanking());
        // Saída esperada: [9.0 - C, 8.0 - A, 7.0 - B]
    }
}

