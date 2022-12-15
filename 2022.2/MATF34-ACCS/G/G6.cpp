#include <iostream>

using namespace std;

int main(){
  int n, m, a, l, c, bugs=0,cont=0;

  cin >> n >> m;

  int matrizA[n][m];

  for(int i = 0; i < n; i++) {
    for (int j = 0; j < m; j++){
      cin >> matrizA[i][j];
        if (matrizA[i][j] == 1) {
          bugs++;
        }
    }
  }


    cin >> a;
  
  for (int i = 0; i < a; i++) {
    cin >> l >> c;
    l = l - 1;
    c = c - 1;
    if (matrizA[l][c] == 1) {
      bugs--;
      matrizA[l][c] == 0;
    }
  }

  if (bugs > 0) {
    cout << "ILL BE BACK";
  } else {
    cout << "HASTA LA VISTA BABY";
  }
}
