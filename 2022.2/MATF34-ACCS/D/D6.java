import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Main {
  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    ArrayList<Peca> pecas = new ArrayList<Peca>();

    for (int i = 0; i < 10; i++) {
      String linha[] = scanner.nextLine().split(" ");
      int x = Integer.parseInt(linha[0]);
      int y = Integer.parseInt(linha[1]);
      Peca peca = new Peca(x, y);
      pecas.add(peca);
    }

    Collections.sort(pecas, new Comparator<Peca>() {
      public int compare(Peca o1, Peca o2) {
        if (o1.soma == o2.soma) {
		  return o1.x - o2.x;
		}
		return o1.soma - o2.soma;
      }
    });

   for (int i = 0; i < 10; i++) {
    System.out.println(pecas.get(i).getX() + " " + pecas.get(i).getY() + " = " + pecas.get(i).getSoma());
  }

    scanner.close();
  }


}

class Peca {
  int x;
  int y;
  int soma;

  Peca(int x, int y) {
    this.x = x;
    this.y = y;
    this.soma = x + y;
  }

  public int getX() {
    return x;
}

public int getY() {
    return y;
}

public int getSoma() {
    return soma;
}

}