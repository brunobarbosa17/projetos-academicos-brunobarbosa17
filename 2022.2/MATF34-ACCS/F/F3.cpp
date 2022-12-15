#include <iostream>
// REI DA NOITE
using namespace std;
int main() {
  int i, j, caminhantesBrancos, identificadoresRei, identificadores, valorEsquerda,valorDireita, meio, pegaORei = 0;
  cin >> caminhantesBrancos;
  int vetorCaminhantes[caminhantesBrancos];
  for (i = 0; i < caminhantesBrancos; i++) 
    cin >> vetorCaminhantes[i];
  cin >> identificadoresRei;
  for (i = 0; i < identificadoresRei; i++) {
    cin >> identificadores;
    valorEsquerda = 0;
    valorDireita = caminhantesBrancos - 1;
    while (valorEsquerda <= valorDireita) {
      meio = (valorEsquerda + valorDireita) / 2;
      if (identificadores < vetorCaminhantes[meio])
        valorDireita = meio - 1;
      else if (identificadores == vetorCaminhantes[meio])
        break;
      else
        valorEsquerda = meio + 1;
    }
    if (vetorCaminhantes[meio] == identificadores)
      pegaORei++;
  }
  if (pegaORei > 0) {
    cout << "Preparem o vidro de dragao!!!" << endl;
  }
  if (pegaORei == 0) {
    cout << "E assim termina nossa vigilia" << endl;
  }
}