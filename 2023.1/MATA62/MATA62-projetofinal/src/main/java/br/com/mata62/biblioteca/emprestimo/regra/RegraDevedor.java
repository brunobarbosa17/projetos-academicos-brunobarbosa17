package br.com.mata62.biblioteca.emprestimo.regra;

import br.com.mata62.biblioteca.emprestimo.EmprestimoImpl;
import br.com.mata62.biblioteca.livros.Livro;
import br.com.mata62.biblioteca.usuarios.Usuario;

public class RegraDevedor implements  RegraEstrategia{
    @Override
    public boolean estaDeAcordo(Usuario usuario, Livro livro) {
        for(EmprestimoImpl emprestimo : usuario.getEmprestimos()){
            if (emprestimo.estaVencido()) {
                System.out.println("Erro: Usuário tem empréstimo vencido");
            }
        }
        return true;
    }
}
