#include <iostream>
#include <string>

using namespace std;

int main () {
  string xyz;
  int n;
  getline(cin, xyz);
  cin >> n;
  
  for (int i = 0; i < n; i++) {
      cout << xyz << endl;
  };
}