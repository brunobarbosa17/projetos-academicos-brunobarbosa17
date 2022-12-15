#include <iostream>

using namespace std;

int main() {
    char matriz[10][10];

    for (int i = 0; i < 10; i++) {
        for (int j = 0; j < 10; j++) {
            cin >> matriz[i][j];
        }
    }

    for (int i = 0; i < 10; i++) {
        for (int j = 0; j < 10; j++) {
            if (matriz[i][j] == 't') {
                if (/*i==9 || j==0 || j==9 || i==0 ||*/
                    (i+1<=9 && matriz[i+1][j] == '*') ||
                    (j+1<=9 && matriz[i][j+1] == '*') || 
                    (i-1>=0 && matriz[i-1][j] == '*') || 
                    (j-1>=0 && matriz[i][j-1] == '*') ) {
                    matriz[i][j] = 'p';
                    }
            }
        }
    }

    for (int i = 0; i < 10; i++) {
        for (int j = 0; j < 10; j++) {
            cout << matriz[i][j] << " ";
        }
        cout << endl;
    }


}