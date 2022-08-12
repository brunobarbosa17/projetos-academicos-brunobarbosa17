package br.ufba.poo.lista1;

public class EhPdf {

    /**
     * @param nomeDoArquivo nome do arquivo; não pode ser nulo
     * @return Indica se o nomeDoArquivo representa o nome de um arquivo PDF
     */
    public static boolean ehPdf(String nomeDoArquivo) {
        
        if(nomeDoArquivo.isEmpty() || nomeDoArquivo == null) {
            return false;
        } else {
            return nomeDoArquivo.toLowerCase().endsWith(".pdf") ;
        }
    }
    public static void main(String[] args) {
        System.out.println(ehPdf(" .pdf"));
    }
}

