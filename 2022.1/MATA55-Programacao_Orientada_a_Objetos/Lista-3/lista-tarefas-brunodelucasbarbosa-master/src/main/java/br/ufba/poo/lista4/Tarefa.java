package br.ufba.poo.lista4;

import java.util.HashMap;
import java.util.Map;

/**
 * Uma tarefa com id e descrição.
 */
public class Tarefa {

    private String descricao;

    private int id;

    public Tarefa(int id, String descricao) {
        super();
        this.id = id;
        this.descricao = descricao;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public int getId() {
        return id;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + id;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Tarefa other = (Tarefa) obj;
        if (id != other.id)
            return false;
        return true;
    }
}

