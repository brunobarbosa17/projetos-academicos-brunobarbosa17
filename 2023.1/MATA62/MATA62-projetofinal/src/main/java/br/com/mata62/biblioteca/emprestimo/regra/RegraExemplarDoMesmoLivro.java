package br.com.mata62.biblioteca.emprestimo.regra;

import br.com.mata62.biblioteca.emprestimo.EmprestimoImpl;
import br.com.mata62.biblioteca.livros.Livro;
import br.com.mata62.biblioteca.usuarios.Usuario;

public class RegraExemplarDoMesmoLivro implements RegraEstrategia{
    @Override
    public boolean estaDeAcordo(Usuario usuario, Livro livro) {
        for (EmprestimoImpl emprestimo : usuario.getEmprestimosAtivos()){
            if (emprestimo.getLivro().getCodigoIdentificador() == livro.getCodigoIdentificador()){
                System.out.println("Error: O usuário já tem um exemplar do livro em empréstimo");
                return false;
            }
        }
        return true;
    }
}
