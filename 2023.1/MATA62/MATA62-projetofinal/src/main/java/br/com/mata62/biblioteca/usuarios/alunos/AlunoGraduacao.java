package br.com.mata62.biblioteca.usuarios.alunos;

public class AlunoGraduacao extends Aluno {

    public AlunoGraduacao(String nome, String codigoIdentificador) {
        super(nome, codigoIdentificador);
    }

    @Override
    public int GetQuantidadeTempoMaximoEmDiasEmprestimo() {
        return 3;
    }


    @Override
    public Integer GetLimiteDeEmprestimosEmAberto() {
        return null;
    }



    @Override
    public int getLimiteEmprestimosEmAberto() {
        return 3;
    }



}
