package br.ufba.poo.lista4;

import java.util.HashMap;
import java.util.Map;

/**
 * Exceção lançada quando algum usuário tenta executar uma operação para
 * o qual não está autorizado.
 */
public class AutorizacaoException extends RuntimeException {

    public AutorizacaoException() {
        super("Usuario nao autorizado.");
    }
}

