package br.ufba.poo.lista4;

import java.util.HashMap;
import java.util.Map;

public class TarefaMain {

    /**
     * Exemplo de uso das classes ListaDeTarefas e
     * ListaDeTarefasComAutenticacao.
     */
    public static void main(String[] args) {
        ListaDeTarefas lista = new ListaDeTarefas("Compras");
        System.out.println(lista.toString());
        int idArroz = lista.adiciona("Arroz");
        int idFeijao = lista.adiciona("Feijao");
        lista.remove(idFeijao);
        lista.atualiza(idArroz, "Arroz integral");
        System.out.println(lista.toString());

		ListaDeTarefasComAutenticacao lista2 = new ListaDeTarefasComAutenticacao("Consertos");
		lista2.autentica("admin");
		int id = lista2.adiciona("Consertar torneira");
		lista2.atualiza(id, "Trocar torneira");

		lista2.autentica("guest");
		System.out.println(lista2.toString());
		lista2.adiciona("Vai dar erro, pois guest não pode adicionar");

    }
}

