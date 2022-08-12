package br.ufba.poo.lista3;

/**
 * Considere as seguintes entidades do mundo real:
 *
 * Veículo:
 * - pode acelerar
 * - pode frear
 *
 * Moto:
 * - pode acelerar
 * - pode frear
 * - pode empinar
 *
 * Carro:
 * - pode acelerar
 * - pode frear
 * - pode ligar o ar condicionado
 *
 * Crie classes para representar Veículo, Moto e Carro.
 * Crie também os seguintes métodos, com implementação vazia:
 *
 * - acelerar()
 * - frear()
 * - empinar()
 * - ligarArCondicionado()
 *
 * Use herança para evitar duplicação de código.
 */
public class Veiculo {

    public void acelerar(){};
    public void frear(){};


    /**
     * Exemplo de uso
     */
    public static void main(String[] args) {
        Veiculo v = new Veiculo();
        Carro c = new Carro();
        Moto m = new Moto();

        v.acelerar();
        c.acelerar();
        c.ligarArCondicionado();
        m.acelerar();
        m.empinar();
        Veiculo meuVeiculo = c;
        meuVeiculo.acelerar();
        Veiculo outroVeiculo = m;
        outroVeiculo.acelerar();
    }
}

