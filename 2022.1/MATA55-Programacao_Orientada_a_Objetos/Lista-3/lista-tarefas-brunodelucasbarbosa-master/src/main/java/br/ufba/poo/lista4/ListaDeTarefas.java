package br.ufba.poo.lista4;

import java.util.HashMap;
import java.util.Map;

/**
 * Gerencia uma lista de tarefas.
 * Veja também a classe ListaDeTarefasComAutenticacao
 */
public class ListaDeTarefas {

    private Map<Integer, Tarefa> tarefas = new HashMap<>();

    private String nome;

    private int proximoId = 1;

    public ListaDeTarefas(String nome) {
        this.nome = nome;
    }

    public int adiciona(String descricao) {
        int id = proximoId;
        Tarefa tarefa = new Tarefa(id, descricao);
        tarefas.put(proximoId, tarefa);
        proximoId++;
        return id;
    }

    public void remove(int id) {
        tarefas.remove(id);
    }

    public void atualiza(int id, String novaDescricao) {
        Tarefa tarefa = tarefas.get(id);
        if (tarefa != null) {
            tarefa.setDescricao(novaDescricao);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("=== " + nome + " ===\n\n");
        if (tarefas.size() == 0) {
            sb.append("(vazia)\n");
        } else {
            for (Tarefa tarefa : tarefas.values()) {
                sb.append("* " + tarefa.getDescricao() + "\n");
            }
        }
        return sb.toString();
    }

    public int getTamanho() {
        return tarefas.size();
    }
}

