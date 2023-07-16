package br.com.mata62.biblioteca.reserva;

import br.com.mata62.biblioteca.livros.Livro;
import br.com.mata62.biblioteca.usuarios.alunos.Aluno;

public class ReservaImpl implements IReserva {

    public Boolean SolicitarReserva(Livro livro, Aluno aluno) {
        if (aluno.getQuantidadeReservasDoLivro(livro) == 3) {
            return false;
        }
        return livro.solicitarReserva(aluno);
    }
}
