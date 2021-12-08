// QUESTAO VULCAO
#include <iostream>

using namespace std;

int main() {
  int T,P,alarme=0;
  cin >> T;
  do {
    cin >> P;
    if (P > T) {
      alarme++;
    }
  } while (P != 0);
  if (alarme > 0) {
    cout << "ALARME" << endl;
  } else {
    cout << "O Havai pode dormir tranquilo" << endl;
  }
}