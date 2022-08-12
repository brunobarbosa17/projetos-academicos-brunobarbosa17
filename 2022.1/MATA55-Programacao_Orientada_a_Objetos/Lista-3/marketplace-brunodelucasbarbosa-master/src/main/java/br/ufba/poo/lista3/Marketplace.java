package br.ufba.poo.lista3;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Loja que vende produtos e serviços.
 * TODO: Complete a implementação do método getCarrinhoTxt
 */
public class Marketplace {

    private Collection<ItemDeVenda> items = new ArrayList<>();

    /**
     * Adiciona item ao carrinho de compras
     * @param item item a adicionar
     */
    public void addItem(ItemDeVenda item) {
        items.add(item);
    }

    /**
     * TODO: complete a implementação de acordo com a especificação abaixo.
     *
     * Retorna uma string representando os items que foram adicionados.
     * Cada item é representado em uma linha, com o seguinte formato:
     *
     * NOME (CONDIÇÃO) - PREÇO
     *
     * onde NOME é o nome do produto ou serviço
     * CONDIÇÃO é a condição do produto (novo ou usado)
     * PREÇO é o preço do produto ou serviço
     *
     * No caso de serviço, não existe CONDIÇÃO; assim, a linha fica assim:
     *
     * NOME - PREÇO
     */
    public String getCarrinhoTxt() {
        String txt = "";
        for (ItemDeVenda item : items) {
            txt += item.getNome();
            if(item.getClass().getSimpleName().equals("Produto")) {
                Produto itemProduto = (Produto) item;
                if(itemProduto.isNovo()) {
                    txt += " " + "(novo)";
                } else {
                    txt += " " + "(usado)";
                }
            }
            txt += " - " + item.getPreco();
            txt += "\n";
        }
        return txt;
    }

    /**
     * Exemplo de uso
     */
    public static void main(String[] args) {
        Marketplace market = new Marketplace();
        market.addItem(new Produto("Skate", 150.0, true));
        market.addItem(new Servico("Troca de pneu", 100.0));
        System.out.println(market.getCarrinhoTxt());
        /* Saída esperada:
			Skate (novo) - 150.0
			Troca de pneu - 100.0
		 */
    }
}

