package br.ufba.poo.lista1;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Test;

public class EhPdfTest {

    @Test
    public void extensaoPDF() {
        assertTrue(EhPdf.ehPdf("arquivo.PDF"));
    }

    @Test
    public void pdfApareceNoMeio() {
        assertFalse(EhPdf.ehPdf("manual.pdf.epub"));
    }

    @Test
    public void nomeVazio() {
        assertFalse(EhPdf.ehPdf(""));
    }
}

