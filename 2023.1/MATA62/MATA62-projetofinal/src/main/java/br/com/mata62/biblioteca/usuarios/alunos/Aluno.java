package br.com.mata62.biblioteca.usuarios.alunos;

import br.com.mata62.biblioteca.emprestimo.regra.*;
import br.com.mata62.biblioteca.livros.Livro;
import br.com.mata62.biblioteca.usuarios.Usuario;

import java.util.ArrayList;
import java.util.Arrays;

public abstract class Aluno extends Usuario implements IEmprestimoAluno {
    private ArrayList<RegraEstrategia> regrasDeEmprestimo =
            new ArrayList<>(Arrays.asList(new RegraDevedor(), new RegraDisponibilidade(),
            new RegraEmprestismosMaximos(), new RegraReservas(), new RegraExemplarDoMesmoLivro()));

    public Aluno(String nome, String codigoIdentificador) {
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

    private Integer quantidadeDeReservasPermitidas = 3;
    public Integer getQuantidadeDeReservasPermitidas() {
        return quantidadeDeReservasPermitidas;
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
