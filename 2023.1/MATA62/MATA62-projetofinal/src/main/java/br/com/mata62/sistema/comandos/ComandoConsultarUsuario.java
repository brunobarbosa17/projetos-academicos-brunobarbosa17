package br.com.mata62.sistema.comandos;

import br.com.mata62.biblioteca.BibliotecaImpl;
import br.com.mata62.biblioteca.emprestimo.IEmprestimo;

import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class ComandoConsultarUsuario extends Comando {

    @Override
    public void executar(ArrayList<String> args, BibliotecaImpl biblioteca) {
        var usuario = biblioteca.getUsuario(args.get(0));
        if(usuario == null){
            System.out.println("Erro: Código de usuário " + args.get(0) + " é inválido.");
            return;
        }
        System.out.println("Empréstimos do usuário " + usuario.getNome());
        for(IEmprestimo emprestimo : usuario.getEmprestimos()){
            System.out.println("    "+ emprestimo.getLivro().getTitulo() + " Data de empréstimo>: " +
                                emprestimo.getDataDeEmprestimo().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) +
                                 " " + emprestimo.getStatus() +
                                " Data de Devolução : " +
                                emprestimo.getDataDeDevolucao().format(DateTimeFormatter.ofPattern("dd/MM/yyyy")) );
        }
    }
}
