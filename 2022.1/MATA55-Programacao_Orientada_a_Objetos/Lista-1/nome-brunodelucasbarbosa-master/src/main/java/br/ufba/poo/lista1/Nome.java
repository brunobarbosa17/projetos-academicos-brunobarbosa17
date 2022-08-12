package br.ufba.poo.lista1;

/**
 * Esta classe representa o nome de uma pessoa,
 * formado por um primeiro nome e um sobrenome.
 *
 * Exercício: implemente os métodos corretamente.
 */
public class Nome {

    private String primeiroNome;

    private String sobrenome;

    /**
     * Retorna o nome completo, formado pelo primeiro nome e pelo
     * sobrenome, separados por um espaço.
     *
     * Dica: se x e y são strings, x + y é a concatenção das duas
     * strings.
     *
     * Dica: " " é uma string que representa um espaço em branco.
     */
    public String getNomeCompleto() {
        return this.primeiroNome + " " + this.sobrenome;
    }

    public String getPrimeiroNome() {
        return this.primeiroNome;
    }

    /**
     * Altera o primeiro nome para o valor passado como parâmetro
     * @param s Novo primeiro nome
     */
    public void setPrimeiroNome(String s) {
        this.primeiroNome = s;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    /**
     * Altera o sobrenome para o valor passado como parâmetro
     * @param s Novo sobrenome
     */
    public void setSobrenome(String s) {
        this.sobrenome = s;
    }

    /**
     * Este método está aqui somente para você testar a sua
     * classe. Você pode implementá-lo como quiser, pois ele
     * não faz parte da avaliação.
     */
    public static void main(String[] args) {
        Nome nome = new Nome();
        nome.setPrimeiroNome("Fulano");
        nome.setSobrenome("de Tal");
        // Deve imprimir: Fulano
        System.out.println(nome.getPrimeiroNome());
        // Deve imprimir: de Tal
        System.out.println(nome.getSobrenome());
        // Deve imprimir: Fulano de Tal
        System.out.println(nome.getNomeCompleto());
    }
}

