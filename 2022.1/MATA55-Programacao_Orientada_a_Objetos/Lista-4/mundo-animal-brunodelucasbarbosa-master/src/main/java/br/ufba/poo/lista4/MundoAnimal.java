package br.ufba.poo.lista4;

/**
 * Crie classes para representar gatos, cachorros, patos e bem-te-vis,
 * considerando os seguintes métodos:
 *
 * <pre>
 * public String canta() {
 * 	return "Bem-te-vi!";
 * }
 *
 * public String canta() {
 * 	return "Qua-qua!";
 * }
 *
 * public String voa() {
 * 	return "Voando...";
 * }
 *
 * public String nasce() {
 * 	return "Nascendo do ventre da mae...";
 * }
 *
 * public String nasce() {
 * 	return "Nascendo do ovo...";
 * }
 * </pre>
 *
 * Crie uma interface chamada `Animal` e classes chamadas `Mamifero`, `Ave`,
 * `Cachorro`, `Gato`, `Pato` e `BemTeVi`, sendo que apenas as 4 últimas podem
 * ser instanciadas. Todos os animais nascem, mas mamíferos e aves nascem de
 * formas diferentes. Todas as aves cantam, mas de formas diferentes.
 * Todas as aves no nosso exemplo voam.
 *
 * Use herança ou implementação de interface, de acordo com o caso, de forma a
 * evitar duplicação de código e permitir que os métodos sejam chamados com o
 * tipo mais abstrato possível. Você não deve criar nenhum outro método,
 * atributo ou construtor além do que foi especificado na questão.
 *
 * O código a seguir deve compilar e executar sem erro (sem produzir nenhuma
 * saída), mas note que ele testa apenas uma parte de todas as condições da
 * especificação.
 */
public class MundoAnimal {

    /**
     * Exemplo de código.
     */
    public static void main(String[] args) {
        // O código pode não compilar enquanto você
        // não fizer o exercício

		Cachorro c = new Cachorro();
		Gato g = new Gato();
		Pato p = new Pato();
		BemTeVi b = new BemTeVi();
		Ave ap = (Ave) p;
		Ave ab = (Ave) b;

		((Animal) c).nasce();
		((Animal) g).nasce();
		((Animal) p).nasce();
		((Animal) b).nasce();

		ap.nasce();
		ab.nasce();
		if (!p.canta().equals("Qua-qua!")) {
			throw new RuntimeException("Erro!");
		}
		if (!b.canta().equals("Bem-te-vi!")) {
			throw new RuntimeException("Erro!");
		}

    }
}

