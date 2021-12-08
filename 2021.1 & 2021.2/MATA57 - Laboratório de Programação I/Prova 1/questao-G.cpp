//QUESTAO MINUSCULO PARA MAIUSCULO
#include <iostream>
#include <string>

using namespace std;

int main() {
  string frase;
  getline(cin, frase);
  for(int i = 0; i < frase.size(); i++) {
    if(frase[i] >= 'a' && frase[i] <= 'z'){
      frase[i] = frase[i] - ('a' - 'A');
    }
  cout << frase[i];
  };
}