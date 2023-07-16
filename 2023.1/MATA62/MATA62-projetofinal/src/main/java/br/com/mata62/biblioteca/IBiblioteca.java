package br.com.mata62.biblioteca;

import br.com.mata62.biblioteca.livros.Livro;
import br.com.mata62.biblioteca.usuarios.Usuario;
import br.com.mata62.biblioteca.usuarios.alunos.Aluno;
import br.com.mata62.biblioteca.usuarios.professor.Professor;

import java.util.ArrayList;
import java.util.List;

public interface IBiblioteca {

    Livro getLivro(String codigoLivro);
    Usuario getUsuario(String codigoIdentificador);
    Professor getProfessor(String codigoProfessor);

    void addProfessor(Professor professor);
    void addAluno(Aluno aluno);
    void addLivros(Livro livro);

    boolean solicitarEmprestimo(String codigoUsuario, String codigoLivro);
    public boolean devolver(Usuario usuario, Livro livro);
    public void reservar(Usuario usuario, Livro livro);
}
