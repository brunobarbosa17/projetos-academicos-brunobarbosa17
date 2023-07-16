package br.com.mata62.biblioteca.usuarios.alunos;

public class AlunoPosGraduacao extends Aluno {

    public AlunoPosGraduacao(String nome, String codigoIdentificador) {
        super(nome, codigoIdentificador);
    }

    @Override
    public int GetQuantidadeTempoMaximoEmDiasEmprestimo() {
        return 4;
    }

    @Override
    public Integer GetLimiteDeEmprestimosEmAberto() {
        return null;
    }

    @Override
    public int getLimiteEmprestimosEmAberto() {
        return 4;
    }
}
