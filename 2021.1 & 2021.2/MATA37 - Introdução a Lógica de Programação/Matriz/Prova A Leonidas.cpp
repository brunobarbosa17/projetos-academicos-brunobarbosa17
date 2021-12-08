#include <iostream>

using namespace std;

int main() {
    int p, matriz[10][10], tem=0;
    cin >> p;
    
    for (int i = 0; i < 10; i++) {
        for (int j = 0; j < 10; j++) {
        cin >> matriz[i][j];
        }
    }

    for (int i = 0; i < 10; i++) {
        for (int j = 0; j < 10; j++) {
        if(matriz[i][j] == p) {
            tem++;
        }
    }
}
if (tem == 0) {
    cout << "nao";
} else {
    cout << "sim";
}



}