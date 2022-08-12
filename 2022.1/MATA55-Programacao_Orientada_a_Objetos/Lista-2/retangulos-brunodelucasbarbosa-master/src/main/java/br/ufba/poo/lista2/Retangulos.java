package br.ufba.poo.lista2;

/**
 * Crie classes para representar Pontos, Dimensões e Retangulos, considerando as seguintes indicações:
 *
 * A classe Ponto possui dois atributos privados, x e y, de tipo double, um construtor e o método
 * toString que retorna os valores no seguinte formato: (x,y).
 * Além disso, ela possui o método public boolean equals(Object obj), que retorna true se e somente se
 * ambos os pontos possuem o mesmo x e o mesmo y.
 *
 * A classe Dimensao possui dois atributos privados, largura e altura, de tipo double, um construtor e
 * o método toString, que retorna os valores no seguinte fomato: l:largura - a:altura.
 * Além disso, ela possui o método public boolean equals(Object obj), que retorna true se e somente se
 * as duas dimensões possuem a mesma largura e a mesma altura.
 *
 * A classe Retangulo possui quatro atributos privados, x, y, largura e altura, de tipo double.
 * Possui também dois construtores, um que recebe parâmetros para os quatro atributos e outro que recebe
 * um Ponto e uma Dimensao.
 * Além disso, a classe possui alguns métodos:
 *
 * <pre>
 * public double getPerimetro(){
 * // retorna o perimetro do retangulo
 * }
 *
 * public double getArea(){
 * // retorna a área do retângulo
 * }
 *
 * public Ponto getOrigem(){
 * // retorna um objeto da classe Ponto com as coordenadas x e y
 * }
 *
 * public Dimensao getDimensao(){
 * // retorna um objeto de classe Dimensao com a largura e altura do retangulo
 * }
 *
 * A classe implementa o metodo equals:
 *
 * public boolean equals(Object obj) {
 * // dois retangulos são iguais quando têm a mesma origem e dimensão
 * }
 *
 * public boolean equivalente(Retangulo r){
 * // dois retangulos são equivalentes quando têm a mesma área
 * }
 *
 * public String toString(){
 * // retorna os valores no seguinte formato: (x,y) l:largura - a:altura
 * }
 * </pre>
 *
 * Todas as classes possuem getters para os atributos privados.
 *
 * O código a seguir deve compilar e executar sem erro, mas note que ele testa apenas uma parte de
 * todas as condições da especificação.
 */
public class Retangulos {

    public static void main(String[] args) {
        Ponto p1 = new Ponto(2, 5);
        System.out.println("p1" + p1);
        // output p1(2.0,5.0)
        Ponto p2 = new Ponto(5, 10);
        System.out.println("p2" + p2);
        Dimensao d = new Dimensao(10, 5);
        System.out.println(d);
        // output l:10.0 - a:5.0
        Retangulo r1 = new Retangulo(p1, d);
        System.out.println("Area: " + r1.getArea());
        // output Area: 50.0
        Retangulo r2 = new Retangulo(2, 5, 10, 5);
        System.out.println(r1);
        // output (2.0,5.0) l:10.0 - a:5.0
        System.out.println(r2);
        if (r1.equals(r2)) {
            System.out.println("Retangulos iguais");
        } else {
            System.out.println("Retangulos diferentes");
        }

//        System.out.println(r1.getOrigem());
//        System.out.println(r2.getOrigem());
//        System.out.println(r1.getDimensao());
//        System.out.println(r2.getDimensao());
        Ponto teste = r1.getOrigem();
        Dimensao teste2 = r1.getDimensao();
        System.out.println(teste);
        System.out.println(teste2);

    }
}

