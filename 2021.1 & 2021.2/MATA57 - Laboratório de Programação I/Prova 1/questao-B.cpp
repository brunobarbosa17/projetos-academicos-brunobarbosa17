#include <iostream>
using namespace std;
//Intervalos
int main() {
  int x,y,w,z,num, intervalo=0;
  bool primeiro = false, segundo= false;
  cin >> w >> z;
  cin >> x >> y;
  cin >> num;

  if (num >= w && num <= z) primeiro = true;
  if (num >= x && num < y) segundo = true;

  if(primeiro && !segundo) {
    cout << "Primeiro intervalo!" << endl;
  } else if (segundo && !primeiro) {
    cout << "Segundo intervalo!" << endl;
  } else if (primeiro && segundo) {
    cout << "Ambos!" << endl;
  } else {
    cout << "Nenhum!" << endl;
  }
  
}