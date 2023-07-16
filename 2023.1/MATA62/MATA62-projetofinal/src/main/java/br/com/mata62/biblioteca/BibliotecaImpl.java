package br.com.mata62.biblioteca;

import br.com.mata62.biblioteca.emprestimo.EmprestimoImpl;
import br.com.mata62.biblioteca.emprestimo.IEmprestimo;
import br.com.mata62.biblioteca.livros.Livro;
import br.com.mata62.biblioteca.reserva.IReserva;
import br.com.mata62.biblioteca.usuarios.Usuario;
import br.com.mata62.biblioteca.usuarios.alunos.Aluno;
import br.com.mata62.biblioteca.usuarios.professor.Professor;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import static br.com.mata62.biblioteca.emprestimo.EmprestimoImpl.EmprestimoFactory;

public class BibliotecaImpl implements IBiblioteca {

    private HashMap<String, Usuario> usuarios = new HashMap<>();
    private HashMap<String, Livro> livros = new HashMap<>();
    private static BibliotecaImpl instace;



    public static BibliotecaImpl getInstace()  {
        if( instace == null){
            return new BibliotecaImpl();
        }
        return instace;
    }

    @Override
    public Livro getLivro(String codigoLivro) {
        return livros.get(codigoLivro);
    }

    @Override
    public Usuario getUsuario(String codigoIdentificador) {
        return usuarios.get(codigoIdentificador);
    }

    @Override
    public Professor getProfessor(String codigoProfessor) {
        return (Professor) usuarios.get(codigoProfessor);
    }

    @Override
    public void addProfessor(Professor professor) {
        usuarios.put(professor.getCodigoIdentificador(), professor);
    }

    @Override
    public void addAluno(Aluno aluno) {
        usuarios.put(aluno.getCodigoIdentificador(), aluno);
    }

    @Override
    public void addLivros(Livro livro) {
        livros.put(livro.getCodigoIdentificador(), livro);
    }

    @Override
    public boolean solicitarEmprestimo(String codigoUsuario, String codigoLivro) {
        var livro = this.getLivro(codigoLivro);
        var usuario = this.getUsuario(codigoUsuario);
        var emprestimo = EmprestimoImpl.EmprestimoFactory(livro);
        return emprestimo.solicitarEmprestimo(usuario, livro);
    }
    @Override
    public boolean devolver(Usuario usuario, Livro livro){
        for(IEmprestimo emprestimo : usuario.getEmprestimosAtivos()) {
            if(emprestimo.getLivro().getCodigoIdentificador() == livro.getCodigoIdentificador()) {
                emprestimo.devolver();
                return true;
            }
        }
        return false;
    }

    @Override
    public void reservar(Usuario usuario, Livro livro) {
        livro.solicitarReserva(usuario);
    }
}

