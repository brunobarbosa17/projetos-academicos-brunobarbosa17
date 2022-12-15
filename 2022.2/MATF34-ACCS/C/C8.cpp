#include <iostream>
#include <string>

using namespace std;

int main () {
  int n;
  cin >> n;

  if (n >= 20 && n < 50) {
    cout << "genin";
  } else if (n >= 50 && n <= 79) {
    cout << "chunin";
  } else if (n > 79) {
    cout << "jounin"
  } else {
    cout << "reprovado"
  }
}