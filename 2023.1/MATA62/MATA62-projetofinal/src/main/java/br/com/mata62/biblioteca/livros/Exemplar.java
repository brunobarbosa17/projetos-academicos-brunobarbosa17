package br.com.mata62.biblioteca.livros;

import br.com.mata62.biblioteca.emprestimo.EmprestimoImpl;
import br.com.mata62.biblioteca.emprestimo.IEmprestimo;
import br.com.mata62.biblioteca.usuarios.Usuario;

public class Exemplar {
    private String codigo;
    private boolean disponivel = true;
    private IEmprestimo emprestimo;

    public Exemplar(String codigo){
        this.codigo = codigo;
    }

    public IEmprestimo getEmprestimo(){ return this.emprestimo;}

    public String getCodigo() {
        return codigo;
    }
    public boolean estaDisponivel() {
        return disponivel;
    }
    public void tornarDisponivel(){
        this.emprestimo = null;
        this.disponivel = true;
    }
    public void tornarIndisponivel(IEmprestimo emprestimo){
        this.emprestimo = emprestimo;
        this.disponivel = false;
    }
}
