//QUESTAO MINUSCULO PARA MAIUSCULO
#include <iostream>
#include <string>
#include <ctype.h>

using namespace std;

int main() {
  string frase, fraseUpperCase;
  getline(cin, frase);
  for (int i = 0; i < frase.size(); i++) {
    fraseUpperCase[i] = putchar(toupper(frase[i]));
  }
  cout << fraseUpperCase << endl;
}