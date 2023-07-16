package br.com.mata62.biblioteca.usuarios;


import br.com.mata62.biblioteca.emprestimo.EmprestimoImpl;
import br.com.mata62.biblioteca.livros.Livro;

import java.util.ArrayList;

public abstract class Usuario implements Observador {
    private String nome;
    private String codigoIdentificador;
    private ArrayList<Livro> listaDeReservas = new ArrayList<>();

    private ArrayList<EmprestimoImpl> emprestimos = new ArrayList<>();
    private int quantidadeNotificacoes = 0;

    public int getQuantidadeNotificacoes() {
        return quantidadeNotificacoes;
    }

    public Usuario(String nome, String codigoIdentificador) {
        this.nome = nome;
        this.codigoIdentificador = codigoIdentificador;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigoIdentificador() {
        return codigoIdentificador;
    }

    public void setCodigoIdentificador(String codigoIdentificador) {
        this.codigoIdentificador = codigoIdentificador;
    }

    public abstract int GetQuantidadeTempoMaximoEmDiasEmprestimo();



    public ArrayList<EmprestimoImpl> getEmprestimos(){return this.emprestimos;}

    public void addEmprestimo(EmprestimoImpl emprestimo){this.emprestimos.add(emprestimo);}

    public int getNumeroDeEmprestimosEmAberto(){
        int contador = 0;
        for (EmprestimoImpl emprestimo : emprestimos){
            if (emprestimo.getStatus() == "Em curso") contador ++;
        }
        return contador;
    }

    public abstract int getLimiteEmprestimosEmAberto();

    public ArrayList<Livro> getListaDeReservas(){
        return listaDeReservas;
    }

    public Integer getQuantidadeReservasDoLivro(Livro livro) {
        return (int) listaDeReservas.stream()
                .filter(l -> l.getCodigoIdentificador().equals(livro.getCodigoIdentificador()))
                .count();
    }

    public ArrayList<EmprestimoImpl> getEmprestimosAtivos(){
        ArrayList<EmprestimoImpl> ativos = new ArrayList<>();
        for(EmprestimoImpl emprestimo : emprestimos){
            if (emprestimo.getStatus() == "Em curso") ativos.add(emprestimo);
        }
        return ativos;
    }
    public abstract boolean podePegarEmprestado(Livro livro);

    @Override
    public String toString() {
        return "Usuario{" +
                "nome='" + nome + '\'' +
                ", codigoIdentificador='" + codigoIdentificador + '\'' +
                ", listaDeReservas=" + listaDeReservas +
                ", emprestimos=" + emprestimos +
                '}';
    }
    public void notificar(){
        quantidadeNotificacoes++;
        System.out.println("Notificando aos observadores...");
    };
}
