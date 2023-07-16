package br.com.mata62.biblioteca.emprestimo.regra;

import br.com.mata62.biblioteca.livros.Livro;
import br.com.mata62.biblioteca.usuarios.Usuario;

public class RegraReservas implements RegraEstrategia{
    @Override
    public boolean estaDeAcordo(Usuario usuario, Livro livro) {
        for(Usuario usuarioReserva : livro.getReservas()){
            if(usuarioReserva.getCodigoIdentificador() == usuario.getCodigoIdentificador()) return true;
        }
        if(livro.getReservas().size() < livro.getNumeroExemplaresDisponiveis()) return true;
        System.out.println("Erro: Os exemplares disponíveis estão reservados");
        return false;
    }
}
