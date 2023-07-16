package br.com.mata62.biblioteca.livros;

import br.com.mata62.biblioteca.usuarios.Observador;
import br.com.mata62.biblioteca.usuarios.Usuario;
import br.com.mata62.biblioteca.usuarios.alunos.Aluno;

import java.util.ArrayList;

public class Livro {
    private String titulo;
    private String codigoIdentificador;
    private String editora;
    private String autores;
    private String edicao;
    private String anoPublicacao;
    private ArrayList<Exemplar> exemplares = new ArrayList<Exemplar>();

    private ArrayList<Usuario> reservas = new ArrayList<Usuario>();
    private ArrayList<Observador> observadores = new ArrayList<>();

    public Livro(String titulo, String codigoIdentificador, String editora, String autores, String edicao, String anoPublicacao) {
        this.titulo = titulo;
        this.codigoIdentificador = codigoIdentificador;
        this.editora = editora;
        this.autores = autores;
        this.edicao = edicao;
        this.anoPublicacao = anoPublicacao;
    }

    public String getTitulo(){
        return this.titulo;
    }
    public void adicionarObservador(Usuario professor) {
        observadores.add(professor);
    }

    public Boolean solicitarReserva(Usuario usuario) {
        reservas.add(usuario);
        if (this.reservas.size() > 2) {
            for (Observador observador : observadores) {
                observador.notificar();
            }
        }
        return true;
    }

    public void removerReserva(Usuario usuario){
        for(Usuario usuarioReserva : reservas){
            if (usuarioReserva.getCodigoIdentificador() == usuario.getCodigoIdentificador()){
                reservas.remove(usuarioReserva);
                return;
            }
        }
    }

    public boolean usuarioTemReserva(Usuario usuario){
        for(Usuario usuarioReserva : reservas){
            if (usuarioReserva.getCodigoIdentificador() == usuario.getCodigoIdentificador()){
                return true;
            }
        }
        return false;
    }

    public String getCodigoIdentificador() {
        return codigoIdentificador;
    }

    public ArrayList<Exemplar> getExemplares(){
        return this.exemplares;
    }

    public void addExemplar(Exemplar exemplar){
        this.exemplares.add(exemplar);
    }
    public int getNumeroExemplaresDisponiveis() {
        int contador = 0;
        for( Exemplar exemplar : exemplares){
            if (exemplar.estaDisponivel() )
                contador++;
        }
        return contador;
        //return (int) this.exemplares.stream().map(exemplar -> exemplar.estaDisponivel()).count();
    }
    public Exemplar getExemplarDisponivel(){
        for (Exemplar exemplar : exemplares){
            if(exemplar.estaDisponivel()){
                return exemplar;
            }
        }
        return null;
    }

    public ArrayList<Usuario> getReservas(){
        return reservas;
    }

    @Override
    public String toString() {


        return "Livro{" +
                "titulo='" + titulo + '\'' +
                ", codigoIdentificador='" + codigoIdentificador + '\'' +
                ", editora='" + editora + '\'' +
                ", autores='" + autores + '\'' +
                ", edicao='" + edicao + '\'' +
                ", anoPublicacao='" + anoPublicacao + '\'' +
                '}';
    }
}
