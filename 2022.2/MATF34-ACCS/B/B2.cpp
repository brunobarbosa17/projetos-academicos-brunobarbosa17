#include <iostream>
using namespace std;

int main() {
  int n;
  cin >> n;
  int vet[n];
  int aux;
  for(int i = 0; i < n; i++) {
    cin >> aux;
    vet[i] = aux;
  }

  int c;
  int soma = 0;
  cin >> c;
  for(int i = 0; i < n; i++) {
    if(vet[i] != c) {
      soma += vet[i];
    }  else{
      soma -= vet[i];
    }
  }

  cout << soma << endl;
}