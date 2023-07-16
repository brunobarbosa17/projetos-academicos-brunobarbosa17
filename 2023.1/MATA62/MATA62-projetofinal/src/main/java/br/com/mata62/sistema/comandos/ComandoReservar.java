package br.com.mata62.sistema.comandos;

import br.com.mata62.biblioteca.BibliotecaImpl;
import br.com.mata62.biblioteca.livros.Livro;

import java.util.ArrayList;

public class ComandoReservar extends Comando{
    @Override
    public void executar(ArrayList<String> args, BibliotecaImpl biblioteca) {
        var usuario = biblioteca.getUsuario(args.get(0));
        Livro livro = biblioteca.getLivro(args.get(1));
        if(usuario == null){
            System.out.println("Erro: Código de usuário " + args.get(0) + " é inválido.");
            return;
        }
        if(livro == null){
            System.out.println("Erro: Código de livro " + args.get(1) + " é inválido.");
            return;
        }
        if(livro.usuarioTemReserva(usuario)){
            System.out.println("Erro: o usuário " + usuario.getNome() + " já tem uma reserva do livro " + livro.getTitulo());
            return;
        }
        biblioteca.reservar(usuario, livro);
        System.out.println("Sucesso. Livro " + livro.getTitulo() + " tem reserva para usuário " + usuario.getNome());
    }
}
