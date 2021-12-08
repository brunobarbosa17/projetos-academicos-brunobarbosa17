#include <iostream>
using namespace std;

int main () {
    long long int n, esq, dir, meio;
    cin >> n;
    string vet[n], num;
    

    for (int i = 0; i < n; i++) {
        cin >> vet[i];
    }

    int q;
    cin >> q; //Lê qtd de requisições

    for (int i = 0; i < q; i++) {   
    
    cin >> num; //nome a ser pesquisado

    esq = 0;
    dir = n-1;
    while(esq <= dir) {        
        meio = (esq + dir)/2;
        if (vet[meio] == num) {
            break;
        }

        if (vet[meio] < num) {
            esq = meio + 1;
        } else {
            dir = meio - 1;
        }

    }

    if (vet[meio] == num) {
        cout << num << " vive!" << endl;
    } else {
        cout << num << " foi extinto :(" << endl;
    }
}



    
}