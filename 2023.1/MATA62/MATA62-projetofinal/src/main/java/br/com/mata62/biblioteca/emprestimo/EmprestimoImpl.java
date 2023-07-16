package br.com.mata62.biblioteca.emprestimo;

import br.com.mata62.biblioteca.livros.Exemplar;
import br.com.mata62.biblioteca.livros.Livro;
import br.com.mata62.biblioteca.usuarios.Usuario;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

public class EmprestimoImpl implements IEmprestimo {

    private LocalDateTime dataDeEmprestimo;
    private  LocalDateTime dataDeDevolucao;

    private Livro livro;
    private Exemplar exemplar;
    private Usuario usuario;

    private String status;

    public EmprestimoImpl(Livro livro){
        this.livro = livro;
    }

    public static EmprestimoImpl EmprestimoFactory(Livro livro){
        return new EmprestimoImpl(livro);
    }

    @Override
    public boolean solicitarEmprestimo(Usuario usuario, Livro livro) {
        if(usuario.podePegarEmprestado(livro)) {
            this.emprestar(livro, usuario);
            return true;
        }
        return false;
    }

    @Override
    public void emprestar(Livro livro, Usuario usuario) {
        this.exemplar = livro.getExemplarDisponivel();
        this.usuario = usuario;
        exemplar.tornarIndisponivel(this);
        this.livro = livro;
        this.dataDeEmprestimo = LocalDateTime.now();
        this.dataDeDevolucao = LocalDateTime.now().plusDays(usuario.GetQuantidadeTempoMaximoEmDiasEmprestimo());
        usuario.addEmprestimo(this);
        livro.removerReserva(usuario);
        this.status = "Em curso";
    }

    @Override
    public LocalDateTime getDataDeEmprestimo() {
        return dataDeEmprestimo;
    }
    @Override
    public Exemplar getExemplar(){
        return this.exemplar;
    }

    @Override
    public boolean devolver(){
        this.exemplar.tornarDisponivel();
        this.dataDeDevolucao = LocalDateTime.now();
        this.status = "Finalizado";
        return true;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    @Override
    public boolean estaVencido(){
        return status == "Em curso" && LocalDateTime.now().isBefore(dataDeDevolucao);
    }
    @Override
    public Livro getLivro() {
        return livro;
    }

    @Override
    public String getStatus(){
        return status;
    }

    @Override
    public LocalDateTime getDataDeDevolucao(){
        return dataDeDevolucao;
    }

    @Override
    public String toString() {
        return "EmprestimoImpl{" +
                "dataDeEmprestimo=" + dataDeEmprestimo +
                ", dataDeDevolucao=" + dataDeDevolucao +
                '}';
    }
}
