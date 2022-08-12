package br.ufba.poo.lista3;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Comparador de estudantes segundo nota, em ordem DECRESCENTE.
 * Se dois estudantes tiverem a mesma nota, não há ordem definida
 * entre eles.
 * TODO: fazer com que objetos desta classe possam ser atribuídos
 *       ao atributo comparator da classe ListaDeAprovados.
 */
public class NotaComparator implements Comparator<Estudante> {

  ListaDeAprovados listaDeAprovados;

  @Override
  public int compare(Estudante o1, Estudante o2) {
    if(o1.getNota() > o2.getNota()) {return -1;}
    else {return 1;}
  
  }


  
}





