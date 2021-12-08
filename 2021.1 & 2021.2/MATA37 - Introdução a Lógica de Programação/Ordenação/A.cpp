#include <iostream>

using namespace std;

int main() {
int n; cin >> n;

int vetor[n];
int aux;

for (int i = 0; i < n; i++) {
        cin >> vetor[i];
    }

    for (int j = 0; j < n; j++) { //posição

        int menor = vetor[j];
        int posMenor = j;

        for (int i = j+1; i < n; i++) {
            if (vetor[i] < menor) {
                menor = vetor[i];
                posMenor = i;
            }    
        }

        aux = vetor[j];
        vetor[j] = vetor[posMenor];
        vetor[posMenor] = aux;
    }

    for (int i = 0; i < 8; i++) {
        cout << vetor[i] << " ";
    }
    

}