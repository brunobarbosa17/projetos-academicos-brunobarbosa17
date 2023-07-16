package br.com.mata62.sistema.comandos;

import br.com.mata62.biblioteca.BibliotecaImpl;

import java.util.ArrayList;

public class ComandoConsultarNotificacoes extends Comando{
    @Override
    public void executar(ArrayList<String> args, BibliotecaImpl biblioteca) {
        var usuario = biblioteca.getUsuario(args.get(0));
        if(usuario == null){
            System.out.println("Erro: Código de usuário " + args.get(0) + " é inválido.");
            return;
        }
        System.out.println("Quantidade de vezez que o usuário foi notificado: " + usuario.getQuantidadeNotificacoes());
    }
}
