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
  
  
  while(cont < a) {
    cin >> l >> c;
    l-=1;
    c-=1;
      if (matrizA[l][c] == 1) {
        bugs--;
      }
    cont++;
  }
  
  if (bugs == 0) {
    cout << "HASTA LA VISTA BABY";
  } else {
    cout << "I'LL BE BACK";
  }
  

}