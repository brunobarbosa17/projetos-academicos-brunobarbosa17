package br.com.mata62.sistema.comandos;

import br.com.mata62.biblioteca.BibliotecaImpl;
import br.com.mata62.biblioteca.livros.Exemplar;
import br.com.mata62.biblioteca.livros.Livro;
import br.com.mata62.biblioteca.usuarios.Usuario;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ComandoConsultarLivro extends Comando{

    @Override
    public void executar(ArrayList<String> args, BibliotecaImpl biblioteca) {
        Livro livro = biblioteca.getLivro(args.get(0));
        if(livro == null){
            System.out.println("Erro: Código de livro " + args.get(0) + " é inválido.");
            return;
        }
        System.out.println("Titulo: " + livro.getTitulo());
        System.out.println("Quantidade de reservas : " + livro.getReservas().size() );
        if(livro.getReservas().size() > 0){
            System.out.println("Livro reservado para os usuários: ");
            for(Usuario usuario: livro.getReservas()){
                System.out.println("    " + usuario.getNome());
            }
        }

        System.out.println("Exemplares: ");
        for (Exemplar exemplar : livro.getExemplares()){
            String codigo = exemplar.getCodigo() + " ";
            String status = exemplar.estaDisponivel() ? " Disponível " :
                            "Emprestado para o usuário " + exemplar.getEmprestimo().getUsuario().getNome() + ", devolução prevista: " +
                            exemplar.getEmprestimo().getDataDeDevolucao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy"));
            System.out.println(codigo + status);
        }
    }
}
