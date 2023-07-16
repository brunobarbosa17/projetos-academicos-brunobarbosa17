package br.com.mata62.biblioteca.emprestimo.regra;

import br.com.mata62.biblioteca.livros.Livro;
import br.com.mata62.biblioteca.usuarios.Usuario;
import br.com.mata62.biblioteca.usuarios.alunos.Aluno;

public class RegraEmprestismosMaximos implements RegraEstrategia{

    @Override
    public boolean estaDeAcordo(Usuario usuario, Livro livro) {
         if(usuario.getNumeroDeEmprestimosEmAberto() < usuario.getLimiteEmprestimosEmAberto()){
            return true;
         }
         System.out.println("Erro: Usuário alcançou o máximo de empréstimos");
         return false;
    }
}
