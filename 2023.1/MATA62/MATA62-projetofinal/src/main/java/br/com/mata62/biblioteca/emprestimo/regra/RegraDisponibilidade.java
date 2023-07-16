package br.com.mata62.biblioteca.emprestimo.regra;

import br.com.mata62.biblioteca.livros.Livro;
import br.com.mata62.biblioteca.usuarios.Usuario;

public class RegraDisponibilidade implements RegraEstrategia{
    @Override
    public boolean estaDeAcordo(Usuario usuario, Livro livro) {
        if(!(livro.getNumeroExemplaresDisponiveis() > 0)){
            System.out.println("Erro: Não há exemplares disponíveis");
        }
        return true;
    }
}
