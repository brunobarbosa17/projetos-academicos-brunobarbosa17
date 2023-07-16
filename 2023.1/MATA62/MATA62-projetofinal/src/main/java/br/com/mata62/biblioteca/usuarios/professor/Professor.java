package br.com.mata62.biblioteca.usuarios.professor;

import br.com.mata62.biblioteca.emprestimo.regra.*;
import br.com.mata62.biblioteca.livros.Livro;
import br.com.mata62.biblioteca.usuarios.Observador;
import br.com.mata62.biblioteca.usuarios.Usuario;

import java.util.ArrayList;
import java.util.Arrays;

public class Professor extends Usuario implements Observador {

    private Integer quantidadeNotificacoes = 0;

    private ArrayList<RegraEstrategia> regrasDeEmprestimo =
            new ArrayList<>(Arrays.asList(new RegraDevedor(), new RegraDisponibilidade()));

    public Professor(String nome, String codigoIdentificador) {
        super(nome, codigoIdentificador);
    }

    public boolean podePegarEmprestado(Livro livro) {
        for(RegraEstrategia regra : regrasDeEmprestimo){
            if(! regra.estaDeAcordo(this, livro)){
                return false;
            }
        }
        return true;
    }

    @Override
    public int GetQuantidadeTempoMaximoEmDiasEmprestimo() {
        return 7;
    }

    @Override
    public int getLimiteEmprestimosEmAberto() {
        return Integer.MAX_VALUE;
    }


    public void observarLivro(Livro livro) {
        livro.adicionarObservador(this);
    }

    @Override
    public void notificar()  {
        quantidadeNotificacoes++;
        System.out.println("Notificando aos observadores...");
    }


    @Override
    public String toString() {
        return "Professor{" +
                "nome=" + this.getNome() +
                ", codigoIdentificador=" + this.getCodigoIdentificador() +
                ", quantidadeNotificacoes=" + quantidadeNotificacoes +
                '}';
    }
}
