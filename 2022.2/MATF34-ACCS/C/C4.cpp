#include <iostream>
using namespace std;

int main (){
  int n, q;
  cin >> n >> q;
  int resto = n - q;
  if (q > n && (resto % 2 == 0)) {
    cout << "vendido";
  } else {
    cout << "sinto muito";
  }
}