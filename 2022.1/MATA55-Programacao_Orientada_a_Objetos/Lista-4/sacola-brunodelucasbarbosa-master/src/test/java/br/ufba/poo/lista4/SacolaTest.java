package br.ufba.poo.lista4;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Test;
import br.ufba.designjudge.elems.ClassElement;
import static br.ufba.designjudge.DesignJudge.*;

public class SacolaTest {

    private double delta = 0.01;

    private String pkg = getClass().getPackageName();

    private ClassElement jsClass = klass(pkg + ".ParcelamentoComJurosSimples");

    private ClassElement jcClass = klass(pkg + ".ParcelamentoComJurosCompostos");

    @Test
    public void testExemplo() {
        Sacola s = new Sacola();
        s.adicionaItem(new ItemSacola("Torradeira", 100));
        s.adicionaItem(new ItemSacola("Fone de ouvido", 900));
        double taxa = 0.03;
        Parcelamento simples12meses = new ParcelamentoComJurosSimples(taxa, 12);
        Parcelamento composto12meses = new ParcelamentoComJurosCompostos(taxa, 12);
        Parcelamento composto18meses = new ParcelamentoComJurosCompostos(taxa, 18);
        Parcelamento[] parcelamentos = new Parcelamento[] { simples12meses, composto12meses, composto18meses };
        assertEquals(1030.00, s.getValorParcelado(simples12meses), delta);
        assertEquals(1182.66, s.getValorParcelado(composto12meses), delta);
        assertEquals(1300.80, s.getValorParcelado(composto18meses), delta);
    }

    @Test
    public void testValorDeUmaParcela() {
        Sacola s = new Sacola();
        s.adicionaItem(new ItemSacola("Torradeira", 100));
        s.adicionaItem(new ItemSacola("Fone de ouvido", 900));
        double taxa = 0.04;
        Parcelamento p = new ParcelamentoComJurosCompostos(taxa, 10);
        double parcela = s.getParcelas(p).get(5);
        assertEquals(121.66, parcela, delta);
    }
}

