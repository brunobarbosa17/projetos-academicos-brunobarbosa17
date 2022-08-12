package br.ufba.poo.lista4;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 * Sacola de compras.
 *
 * Após adicionar itens, a sacola fornece o valor total da compra
 * tanto à vista quanto a prazo.
 *
 * No cálculo do valor a prazo, deve-se passar como parâmetro um
 * objeto do tipo Parcelamento.
 *
 * TODO: implemente as classes ParcelamentoComJurosSimples e
 * ParcelamentoComJurosCompostos. Use mecanismos da linguagem para
 * evitar duplicação de código.
 */
public class Sacola {

    private List<ItemSacola> itens = new ArrayList<>();

    public void adicionaItem(ItemSacola item) {
        itens.add(item);
    }

    public double getValorAVista() {
        return itens.stream().reduce(0.0, (accum, x) -> accum + x.getPreco(), Double::sum);
    }

    public List<Double> getParcelas(Parcelamento p) {
        double[] parcelas = p.getParcelas(getValorAVista());
        return Arrays.stream(parcelas).boxed().collect(Collectors.toList());
    }

    public double getValorParcelado(Parcelamento p) {
        return getParcelas(p).stream().reduce(0.0, (accum, x) -> accum + x, Double::sum);
    }

    /**
     * Exemplo de uso da sacola de compras, com opções de parcelamento
     */
    public static void main(String[] args) {
        Sacola s = new Sacola();
        s.adicionaItem(new ItemSacola("Torradeira", 100));
        s.adicionaItem(new ItemSacola("Fone de ouvido", 900));
        // O código a seguir pode dar erros de compilação se você não
        // completar o exercício

		double taxa = 0.03;
		Parcelamento simples12meses = new ParcelamentoComJurosSimples(taxa, 12);
		Parcelamento composto12meses = new ParcelamentoComJurosCompostos(taxa, 12);
		Parcelamento composto18meses = new ParcelamentoComJurosCompostos(taxa, 18);
		Parcelamento[] parcelamentos = new Parcelamento[] { simples12meses, composto12meses, composto18meses };
		
		System.out.println("Valor à vista: " + s.getValorAVista());
		System.out.println("Opções de parcelamento:");
		
		for (Parcelamento p : parcelamentos) {
			System.out.println("  - " + p + ": " + s.getValorParcelado(p));
				
		}
    }
}

