#include <iostream>
using namespace std;

int main () {
  int n1,n2,n3,n4,n5;
  cin >> n1 >> n2 >> n3 >> n4 >> n5;
  if (n1 + n2 + n3 + n4 + n5 > 5000) {
    cout << "Acesso proibido";
  } else {
    cout << "Acesso liberado";
  }
}