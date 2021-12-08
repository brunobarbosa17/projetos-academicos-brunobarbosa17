// QUESTAO IBGE
#include <iostream>

using namespace std;

int main() {
  int N, S, mulheres=0, homens=0;
  cin >> N;
  for(int i =0; i < N; i++) {
    cin >> S;
    if (S == 1) {
      homens++;
    } else {
      mulheres++;
    }
  }
  cout << homens << endl << mulheres << endl;
}