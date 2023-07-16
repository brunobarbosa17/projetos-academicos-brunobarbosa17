package br.com.mata62.sistema.comandos;

import br.com.mata62.biblioteca.BibliotecaImpl;

import java.util.ArrayList;

public abstract class Comando  {
    public abstract void executar(ArrayList<String> args, BibliotecaImpl biblioteca);
}
