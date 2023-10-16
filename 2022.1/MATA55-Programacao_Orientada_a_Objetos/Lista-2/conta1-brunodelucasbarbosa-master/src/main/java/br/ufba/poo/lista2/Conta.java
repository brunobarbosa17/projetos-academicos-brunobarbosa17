package br.ufba.poo.lista2;

import java.security.InvalidParameterException;
import java.util.Objects;

/**
 * Crie uma classe `Conta` para representar uma conta bancária.
 * Toda conta possui um código que a identifica, do tipo `String`, e um saldo, do tipo `double`.
 * Ao criar uma conta, deve-se sempre informar o código e, opcionalmente, o saldo; se o saldo não for
 * informado, ele deve ser zero.
 *
 * Ao movimentar dinheiro na conta, o saldo nunca deve ser negativo.
 *
 * + Considere que a classe deve possuir os seguintes atributos privados:
 *     - `String codigo`
 *     - `double saldo`
 * + Considere que a classe deve possuir os seguintes métodos:
 *     - `void deposita(double quantia)`: adiciona a quantia ao saldo da conta.
 *     - `boolean transfere(double quantia, Conta beneficiario)`:
 */
public class Conta {

    private String codigo;
    private double saldo;

    public Conta(String codigo, double saldo) {
        this.codigo = codigo;
        this.saldo = saldo;
    }

    public Conta(String codigo) {
        this.codigo = codigo;
        this.saldo = 0;
    }

    /**
     * Subtrai a quantia do saldo da conta, a menos que o saldo
     * seja insuficiente (isto é, menor que a quantia).
     * @param quantia quantia
     * @return `true` se a quantia foi retirada, `false` caso contrário
     */
    public boolean retira(double quantia) {
        if (this.saldo >= quantia) {
            this.saldo -= quantia;
            return true;
        }
        return false;
    }

    /**
     * Adiciona a quantia ao saldo da conta.
     * @param quantia quantia
     */
    public void deposita(double quantia) {
        this.saldo += quantia;
    }

    /**
     * Transfere a quantia da conta atual para a conta do beneficiário,
     * a menos que o saldo da conta atual seja insuficiente (ou ainda se
     * o parâmetro `beneficiario` for `null`).
     * @param quantia
     * @param beneficiario
     * @return `true` se a transferência foi realizada, `false` caso contrário
     */
    public boolean transfere(double quantia, Conta beneficiario) {
        if(beneficiario == null) { return false; }

        if (this.retira(quantia)) {
            beneficiario.deposita(quantia);
            return true;
        }
        return false;
    }

    public String getCodigo() {
        return this.codigo;
    }

    public double getSaldo() {
        return this.saldo;
    }

    public static void main(String[] args) {
        Conta conta1 = new Conta("123", 100);
        Conta conta2 = new Conta("1234", 100);
        Conta conta3 = null;
        
        conta1.transfere(100, conta2);
        
        System.out.println(conta1.getSaldo());
        System.out.println(conta2.getSaldo());
    }
}

