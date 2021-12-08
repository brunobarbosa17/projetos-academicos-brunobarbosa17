#include <iostream>
// A mais dificil que ja fiz
using namespace std;

int main() {
    int n; 
    cin >> n; 
    int vetor[n], quantidadePartes, parteOrdernar, valorAuxiliar;
    for (int i = 0; i < n; i++) {
        cin >> vetor[i];
    }
    cin >> parteOrdernar >> quantidadePartes;

    if(n / parteOrdernar < 2 || n % parteOrdernar != 0) {
        cout << "Impossivel!";
        return 0;
    }
    int final = n/parteOrdernar;
    if (final % 2 == 0) {
        final = n;
    }
    for (int j = n/parteOrdernar; j < final+1; j++) {
        int menor = vetor[j];
        int posMenor = j;
        for (int i = j; i < n; i++) {
            if (vetor[i] < menor) {
                menor = vetor[i];
                posMenor = i;
            }    
        }
        valorAuxiliar = vetor[j];
        vetor[j] = vetor[posMenor];
        vetor[posMenor] = valorAuxiliar;
    }
    for (int i = 0; i < n; i++) {
        cout << vetor[i] << " ";
    }


}