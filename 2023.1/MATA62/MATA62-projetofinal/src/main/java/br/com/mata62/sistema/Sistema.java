package br.com.mata62.sistema;

import br.com.mata62.biblioteca.BibliotecaImpl;
import br.com.mata62.biblioteca.livros.Exemplar;
import br.com.mata62.biblioteca.livros.Livro;
import br.com.mata62.biblioteca.usuarios.alunos.AlunoGraduacao;
import br.com.mata62.biblioteca.usuarios.alunos.AlunoPosGraduacao;
import br.com.mata62.biblioteca.usuarios.professor.Professor;
import br.com.mata62.sistema.comandos.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Scanner;

public class Sistema {
    private HashMap<String, Comando> comandos = new HashMap();
    private BibliotecaImpl biblioteca = BibliotecaImpl.getInstace();

    public Sistema(){
        this.comandos.put("emp", new ComandoEmprestar()); // emp <codigo_usuario> <codigo_livro>
        this.comandos.put("dev", new ComandoDevolver()); // dev <codigo_usuario> <codigo_livro>
        this.comandos.put("res", new ComandoReservar()); // res <codigo_usuario> <codigo_livro>
        this.comandos.put("obs", new ComandoObservar()); // obs <codigo_usuario> <codigo_livro>
        this.comandos.put("liv", new ComandoConsultarLivro()); // liv <codigo_livro>
        this.comandos.put("usu", new ComandoConsultarUsuario()); // usu <codigo_usuario>
        this.comandos.put("ntf", new ComandoConsultarNotificacoes()); // ntf <codigo_usuario>



        var livro1 = new Livro("Engenharia de Software", "100", "Addison-Wesley", "Ian Sommervile", "6ª", "2000");
        var livro2 = new Livro("UML – Guia do Usuário", "101", "Campus", "Grady Booch, James Rumbaugh, Ivar Jacobson", "7ª", "2000");
        var livro3 = new Livro("Code Complete", "200", "Microsoft Press", "Steve McConnell", "2ª", "2014");
        var livro4 = new Livro("Agile Software Development, Principles, Patterns, and Practices", "201", "Prentice Hall", "Robert Martin", "1ª", "2002");
        var livro5 = new Livro("Refactoring: Improving the Design of Existing Code", "300", "Addison-Wesley Professional", "Martin Fowler", "1ª", "1999");
        var livro6 = new Livro("Software Metrics: A Rigorous and Practical Approach", "301", "CRC Press", "Norman Fenton, James Bieman", "3ª", "2014");
        var livro7 = new Livro("Design Patterns: Elements of Reusable Object-Oriented Software", "400", "Addison-Wesley Professional", "Erich Gamma, Richard Helm, Ralph Johnson, John Vlissides", "1ª", "1994");
        var livro8 = new Livro("UML Distilled: A Brief Guide to the Standard Object Modeling Language", "401", "Addison-Wesley Professional", "Martin Fowler", "3ª", "2003");

        var exemplar1 = new Exemplar("1");
        var exemplar2 = new Exemplar("2");
        var exemplar3 = new Exemplar("3");
        var exemplar4 = new Exemplar("4");
        var exemplar5 = new Exemplar("5");
        var exemplar6 = new Exemplar("6");
        var exemplar7 = new Exemplar("7");
        var exemplar8 = new Exemplar("8");

        livro1.addExemplar(exemplar1);
        livro2.addExemplar(exemplar2);
        livro3.addExemplar(exemplar3);
        livro4.addExemplar(exemplar4);
        livro5.addExemplar(exemplar5);
        livro6.addExemplar(exemplar6);
        livro7.addExemplar(exemplar7);
        livro8.addExemplar(exemplar8);

        var alunoGraduacao = new AlunoGraduacao("Joao", "123");
        var alunoPos = new AlunoPosGraduacao("Maria", "456");
        var professor = new Professor("Jose", "789");

        biblioteca.addLivros(livro1);
        biblioteca.addLivros(livro2);
        biblioteca.addLivros(livro3);
        biblioteca.addLivros(livro4);
        biblioteca.addLivros(livro5);
        biblioteca.addLivros(livro6);
        biblioteca.addLivros(livro7);
        biblioteca.addLivros(livro8);
        biblioteca.addAluno(alunoGraduacao);
        biblioteca.addAluno(alunoPos);
        biblioteca.addProfessor(professor);
    }
    public void rodar(){
        System.out.println("Bem vindo ao sistema da biblioteca");
        System.out.printf("--------------------------------%n");
        System.out.printf(" Comandos permitidos         %n");
        System.out.printf("--------------------------------%n");
        System.out.printf("| %-7s | %-9s | %9s |%n", "COMANDO", "PARAMETRO", "PARAMETRO");
        System.out.printf("--------------------------------%n");

        System.out.printf("| %-4s | %-5s | %-5s |%n", "emp", "codigo_usuario", "codigo_livro");
        System.out.printf("| %-4s | %-5s | %-5s |%n", "dev", "codigo_usuario", "codigo_livro");
        System.out.printf("| %-4s | %-5s | %-5s |%n", "res", "codigo_usuario", "codigo_livro");
        System.out.printf("| %-4s | %-5s | %-5s |%n", "obs", "codigo_usuario", "codigo_livro");
        System.out.printf("| %-4s | %-5s | %n", "liv", "codigo_livro");
        System.out.printf("| %-4s | %-5s | %n", "usu", "codigo_livro");
        System.out.printf("| %-4s | %-5s | %n", "ntf", "codigo_usuario");

        System.out.printf("--------------------------------%n");
        Scanner entrada = new Scanner(System.in);
        while(true){
            System.out.println("\nDigite seu comando: ");
            String input[] = entrada.nextLine().split(" ");
            input[0] = input[0].toLowerCase();
            if(input[0] == "sai"){
                System.out.println("Encerrando o  programa...");
                break;
            }
            if (!comandos.containsKey(input[0])) {
                System.out.println("Comando inválido");
                continue;
            }
            Comando comando = comandos.get(input[0]);
            var args = new ArrayList<>(Arrays.asList(input));
            args.remove(0);
            comando.executar(args, biblioteca);

        }
    }
}
