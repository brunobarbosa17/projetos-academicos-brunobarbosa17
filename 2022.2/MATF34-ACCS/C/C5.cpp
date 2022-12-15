#include <iostream>
#include <string>

using namespace std;

int main () {
  int EC, AN, ES;
  cin >> EC >> AN >> ES;

  if (EC != 6) {
    int EC_restantes = 6 - EC;
    int AN_restantes = 60 - AN;
    int ES_restantes = 3 - ES;
    cout << EC_restantes << " " << AN_restantes << " " << ES_restantes << endl;
    return 0;
  }

  cout << "Final Verdadeiro";
}