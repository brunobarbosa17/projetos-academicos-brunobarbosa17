package br.ufba.poo.lista3;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class MarketplaceTest {

    @Test
    public void listaVazia() {
        Marketplace market = new Marketplace();
        assertEquals("", market.getCarrinhoTxt().trim());
    }

    @Test
    public void listaDeServicos() {
        Marketplace market = new Marketplace();
        market.addItem(new Servico("A", 10));
        market.addItem(new Servico("B", 20));
        assertEquals("A - 10.0\nB - 20.0", market.getCarrinhoTxt().trim());
    }

    @Test
    public void listaDeProdutos() {
        Marketplace market = new Marketplace();
        market.addItem(new Produto("A", 10, true));
        market.addItem(new Produto("B", 20, false));
        assertEquals("A (novo) - 10.0\nB (usado) - 20.0", market.getCarrinhoTxt().trim());
    }

    @Test
    public void listaMista() {
        Marketplace market = new Marketplace();
        market.addItem(new Servico("A", 10));
        market.addItem(new Produto("B", 20, false));
        assertEquals("A - 10.0\nB (usado) - 20.0", market.getCarrinhoTxt().trim());
    }
}

