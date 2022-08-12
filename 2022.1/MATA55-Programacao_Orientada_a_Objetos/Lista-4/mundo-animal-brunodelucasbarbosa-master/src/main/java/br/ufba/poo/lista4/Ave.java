package br.ufba.poo.lista4;

public abstract class Ave implements Animal {
    @Override
    public String nasce() {
        return "Nascendo do ovo...";
    }

    public abstract String canta();

    public String voa() {
        return "Voando...";
    }
}
