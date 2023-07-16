package br.com.mata62.biblioteca.reserva;

import br.com.mata62.biblioteca.livros.Livro;
import br.com.mata62.biblioteca.usuarios.alunos.Aluno;

public interface IReserva {
    Boolean SolicitarReserva(Livro livro,  Aluno aluno);
}
