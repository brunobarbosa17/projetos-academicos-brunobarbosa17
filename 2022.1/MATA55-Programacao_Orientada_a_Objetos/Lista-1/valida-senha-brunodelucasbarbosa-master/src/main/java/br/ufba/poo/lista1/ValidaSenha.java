package br.ufba.poo.lista1;

public class ValidaSenha {

    /**
     * Verifica se a senha digitada está correta.
     *
     * @param senhaCorreta  senha correta
     * @param senhaDigitada senha digitada pelo usuário
     * @return <code>true</code> se as duas senhas são iguais; <code>false</code>
     *         caso contrário
     */
    public static boolean validaSenha(String senhaCorreta, String senhaDigitada) {
        return senhaCorreta.equals(senhaDigitada);
    }

    public static void main(String[] args) {
        System.out.println(validaSenha("teste123", "teste123"));
    }
}

