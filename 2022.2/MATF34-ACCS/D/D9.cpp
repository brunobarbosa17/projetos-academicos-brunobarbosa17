#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    int x, aux;
    cin >> x;
    vector<int> vetor;
    for (int i = 0; i < x; i++) {
        cin >> aux;
        vetor.push_back(aux);
    };
    sort(vetor.begin(), vetor.end());

    int repete;
    vector<int> repetidos;
    for (int i = 0; i < x; i++) {
        int atual = vetor[i];
        repete = 0;
        for (int u = 0; u < x; u++) {
            // if (vetor.at(u) == atual) {
            //     repete++;
            // }
            if (binary_search(vetor.begin(), vetor.end(), atual)) {
                repete ++;
            }
        };
        if (repete == 3) {
            if (count(repetidos.begin(), repetidos.end(), atual)) {
                continue;
            } else {
                repetidos.push_back(atual);
            }
        }
    };

    sort(repetidos.begin(), repetidos.end());
    for (int i = 0; i < repetidos.size(); i++) {
        cout << repetidos[i] << " ";
    }
    
}

int buscaBinaria (int x, int n, int v[]) { 
   int e = -1, d = n;
   while (e < d-1) {  
      int m = (e + d)/2;
      if (v[m] < x) e = m;
      else d = m; 
   }
   return d;
}

// compare if one number are equals to another in vector c++
#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

