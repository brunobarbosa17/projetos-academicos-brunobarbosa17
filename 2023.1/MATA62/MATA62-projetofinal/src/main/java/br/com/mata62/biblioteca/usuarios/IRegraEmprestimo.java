package br.com.mata62.biblioteca.usuarios;

public interface IRegraEmprestimo {

    int CalcularQuantidadeTempoEmprestimo();

    void SolicitarEmprestimo();

    Boolean DevolucaoEmprestimo();

    boolean podePegarEmprestado();

}
