package br.ufba.poo.lista4;

import java.util.HashMap;
import java.util.Map;

/**
 * Adaptação da classe ListaDeTarefas com controle de acesso (autorização)
 * aos métodos adiciona, remove, atualiza, toString.
 *
 * O usuário admin pode executar qualquer método.
 * O usuário guest NÃO pode executar os métodos adiciona, remove, atualiza.
 * Demais usuários NÃO podem executar os métodos adiciona, remove, atualiza, toString.
 *
 * TODO: Quando um usuário tenta executar um método ao qual não deve ter acesso,
 * deve ser lançada uma AutorizacaoException.
 *
 * TODO: Complete a implementação desta classe. Ela deve estender a classe
 * ListaDeTarefas, usando os métodos herdados, mas deve adicionar controle
 * de acesso.
 */
public class ListaDeTarefasComAutenticacao extends ListaDeTarefas {

    private String username = "";

    public ListaDeTarefasComAutenticacao(String nome) {
        super(nome);
    }

    public void autentica(String username) {
        this.username = username;
    }

    public boolean possuiPermissaoDeLeitura() {
        return username.equals("admin") || username.equals("guest");
    }

    public boolean possuiPermissaoDeEscrita() {
        return username.equals("admin");
    }

    /**
     * Adiciona tarefa à lista somente se usuário possuir permissão de escrita;
     * caso contrário, lança AutorizacaoException
     * TODO: implementar
     */
    public int adiciona(String descricao) {
        if(!possuiPermissaoDeEscrita()) {
            throw new AutorizacaoException();
        } else {
            super.adiciona(descricao);
            return super.getTamanho();
        }
    }

    /**
     * Remove tarefa da lista somente se usuário possuir permissão de escrita;
     * caso contrário, lança AutorizacaoException
     * TODO: implementar
     */
    public void remove(int id) {
        if (!possuiPermissaoDeEscrita()) {
            throw new AutorizacaoException();
        }
        super.remove(id);
    }

    /**
     * Atualiza tarefa na lista somente se usuário possuir permissão de escrita;
     * caso contrário, lança AutorizacaoException
     * TODO: implementar
     */
    public void atualiza(int id, String novaDescricao) {
        if(!possuiPermissaoDeEscrita()) {
            throw new AutorizacaoException();
        }

        super.atualiza(id, novaDescricao);
    }

    /**
     * Retorna representação textual da lista somente se usuário possuir permissão
     * de leitura; caso contrário, lança AutorizacaoException
     * TODO: implementar
     */
    public String toString() {
        if (!possuiPermissaoDeLeitura()) {
            throw new AutorizacaoException();
        }

        return super.toString();
    }
}

