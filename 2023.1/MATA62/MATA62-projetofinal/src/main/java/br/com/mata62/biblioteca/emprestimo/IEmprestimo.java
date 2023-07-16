package br.com.mata62.biblioteca.emprestimo;

import br.com.mata62.biblioteca.livros.Exemplar;
import br.com.mata62.biblioteca.livros.Livro;
import br.com.mata62.biblioteca.usuarios.Usuario;

import java.time.LocalDateTime;

public interface IEmprestimo {
    boolean solicitarEmprestimo(Usuario usuario, Livro livro);

     void emprestar(Livro livro, Usuario usuario);
    public Usuario getUsuario();
    LocalDateTime getDataDeEmprestimo();

    Exemplar getExemplar();

    boolean devolver();

    boolean estaVencido();

    Livro getLivro();

    String getStatus();

    LocalDateTime getDataDeDevolucao();
}
