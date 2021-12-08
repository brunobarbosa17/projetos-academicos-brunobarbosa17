#include <iostream>

using namespace std; 

int main() {
  int n,m,l,c, final=0;
  cin >> n >> m;
  int matriz[n][n];

  for(int i=0; i < n; i++) {
    for(int j=0; j < n; j++) {
      cin >> matriz[i][j];
    }
  }

  for(int i=0; i < m; i++) {
    cin >> l >> c;

    if (matriz[l][c] == 0) {
      while (l >= 0) {
        l--;
        if (matriz[l][c] == 1) {
          //cout << "acertei" << endl;
          final++;
          matriz[l][c] = 0;
          break;
        }
      }
    }
  }
/*  for(int i=0; i < n; i++) {
    for(int j=0; j < n; j++) {
      cout << matriz[i][j] << " ";
    }
    cout << endl;
  }*/
cout << final;


}