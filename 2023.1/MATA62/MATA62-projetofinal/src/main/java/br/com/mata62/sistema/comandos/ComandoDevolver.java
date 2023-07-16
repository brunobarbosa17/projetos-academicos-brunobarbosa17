package br.com.mata62.sistema.comandos;

import br.com.mata62.biblioteca.BibliotecaImpl;
import br.com.mata62.biblioteca.livros.Livro;

import java.util.ArrayList;

public class ComandoDevolver extends Comando{
    public void executar(ArrayList<String> args, BibliotecaImpl biblioteca){
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
        if(biblioteca.devolver(usuario, livro)){
            System.out.println("Sucesso. Usuário " + usuario.getNome() + " devolveu o livro " + livro.getTitulo());
        }
    }
}
