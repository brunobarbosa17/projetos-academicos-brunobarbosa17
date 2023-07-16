package br.com.mata62.biblioteca.emprestimo.regra;

import br.com.mata62.biblioteca.livros.Livro;
import br.com.mata62.biblioteca.usuarios.Usuario;

public interface RegraEstrategia {
    boolean estaDeAcordo(Usuario usuario, Livro livro);
}
