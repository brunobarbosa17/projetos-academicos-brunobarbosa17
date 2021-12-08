#include <iostream>

using namespace std;

int main() {
    int n, m, ovos=0;
    cin >> n >> m;
    int matriz[n][m];
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            cin >> matriz[i][j];
        }
    }
    /*cout << "-----------------------------" << endl;
    for(int i=0; i < n; i++) {
    for(int j=0; j < m; j++) {
        cout << matriz[i][j] << " ";
    }
    cout << endl;
    }*/

    for (int i = 0; i < n; i++) {
        if (i % 2 == 0) { //Se for 0,2,4,6
            for (int j = 0; j < m; j++) {
                //cout << "> ";
            if(matriz[i][j] > 0) {
                ovos += matriz[i][j];
                //cout << "ovos :" << ovos << endl;
            }
            if (matriz[i][j] == 0) {
                //cout << "ovos :" << ovos << endl;
            }
            if(matriz[i][j] < 0) {
                ovos += matriz[i][j];
                if (ovos < 0) ovos = 0;
                //cout << "ovos :" << ovos << endl;
            }
        }
        //cout << endl;
        } else { // Se for 1,3,5,7
            for (int j = m-1; j >= 0; j--) {
                //cout << "< ";
            if(matriz[i][j] > 0) {
                ovos += matriz[i][j];
                //cout << "ovos :" << ovos << endl;
            }
            if (matriz[i][j] == 0) {
                //cout << "ovos :" << ovos << endl;
            }
            if(matriz[i][j] < 0) {
                ovos += matriz[i][j];
                if (ovos < 0) ovos = 0;
                //cout << "ovos :" << ovos << endl;
            }
        }
        }
        //cout << endl;
    }
    //if (ovos < 0) ovos = 0;
cout << ovos;

}