#include <iostream>

using namespace std;

int main(){
  int n, m;

  cin >> n >> m;

  int matrizA[n][m], matrizB[n][m], matrizC[n][m];
  //matriz 2x2 => matriz[0][0] = 1; matriz[0][1] =3
  //matiz[1][0] = 2; matriz[1][1] = 4
  //1 3
  //2 4

  for(int i = 0; i < n; i++) {
    for (int j = 0; j < m; j++){
      cin >> matrizA[i][j];
    }
  }

  for(int i = 0; i < n; i++) {
    for (int j = 0; j < m; j++){
      cin >> matrizB[i][j];
    }
  }

  for(int i = 0; i < n; i++) {
    for (int j = 0; j < m; j++) {
      matrizC[i][j] = matrizA[i][j] - matrizB[i][j]; 
      
    }
  }

  for(int i = 0; i < n; i++) {
    for (int j = 0; j < m; j++) {
      cout << matrizC[i][j] << " "; 
    }
    cout << endl;
  } 

}