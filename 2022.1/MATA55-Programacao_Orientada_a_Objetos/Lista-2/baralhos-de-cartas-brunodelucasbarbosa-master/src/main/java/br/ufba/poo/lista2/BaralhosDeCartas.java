package br.ufba.poo.lista2;

/**
 * Crie classes para representar Cartas e Baralhos considerando as seguintes indicações:
 *
 * A classe Carta possui dois atrubutos privados, numero e naipe (char). O numero é um valor de 1 a 13
 * e o naipe é um caracter: e - espadas, p - paus, c - copas, o - ouros.
 * O construtor desta classe recebe esses dois valores.
 * A classe possui dois métodos para recuperar os atributos (getNumero e getNaipe) e um metodo toString
 * que retorna um string com os dois atributos juntos (ex. 1e para indicar um ás de espadas ou 13p para
 * indicar um rei de paus). Uma vez criadas, as cartas não podem ser modificadas, por isso a classe não
 * possui setters.
 *
 * A classe Baralho possui um array privado de 52 cartas. O construtor instancia as 52 cartas na
 * seguinte ordem: 1 - 13 cartas de espadas, 1 - 13 cartas de paus, 1 - 13 cartas de copas e 1 - 13
 * cartas de ouros.
 *
 * A classe baralho possui os seguintes métodos:
 *
 * <pre>
 * public String toString(){
 * 	// retorna um string com todas as cartas no array separadas por um espaço, como no exemplo seguite:
 *  // 1e 2e 3e 4e 5e 6e 7e 8e 9e 10e 11e 12e 13e 1p 2p 3p 4p 5p 6p 7p 8p 9p 10p 11p 12p 13p 1c 2c 3c 4c 5c 6c 7c 8c 9c 10c 11c 12c 13c 1o 2o 3o 4o 5o 6o 7o 8o 9o 10o 11o 12o 13o
 * }
 *
 * public void embaralha(){
 * 	// embaralha o baralho de cartas. As cartas anteriormente cavadas voltam no baralho.
 * }
 *
 * public Carta cava(){
 * 	// retorna a primeira carta disponível do baralho; se não houver cartas, retorna null.
 * }
 * </pre>
 *
 * O código a seguir deve compilar e executar sem erro, mas note que ele testa apenas uma parte de
 * todas as condições da especificação.
 */
public class BaralhosDeCartas {

    public static void main(String[] args) {
//        Baralho b1 = new Baralho();
//        System.out.println(b1.toString());
//        b1.embaralha();
//        System.out.println(b1.toString());
//        Carta c1 = b1.cava();
//        Carta c2 = b1.cava();
//        System.out.println(c1.toString());
//        System.out.println(c2.toString());

        Baralho b = new Baralho();
        b.embaralha();
        String s1 = b.toString();
        b.embaralha();
        String s2 = b.toString();

        System.out.println(s1);
        System.out.println(s2);

        System.out.println(s1.equals(s2));
    }
}

