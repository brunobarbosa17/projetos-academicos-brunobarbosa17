#include <iostream>
using namespace std;

int main () {
    long long n, esq, dir, meio;
    cin >> n;
    int v[n], p;
    
    for (int i = 0; i < n; i++) {
        cin >> v[i];
    }
    p=1;
    while (p != 0) {    
    cin >> p; 
    if(p == 0) {
        break;
    }
    esq = 0;
    dir = n-1;
    while(esq <= dir) {
        meio = (esq + dir)/2;
        if (v[meio] == p) {
            break;
        }
        if (v[meio] < p) {
            esq = meio + 1;
        } else dir = meio - 1;
    }
        if (v[meio] == p) {
            cout << meio << endl;
        } else cout << "Nao foi visitado ainda." << endl;
    
    }
}