#include <iostream>
#include <vector>
#include <algorithm>
using namespace std;

int main() {
    int n;
    vector<int> esferas;

    for (int i = 0; i < n; i++) {
        int aux;
        cin >> aux;
        esferas.push_back(aux);
    };

    if (find(esferas.begin(), esferas.end(), 1) == 1) {
            cout << esferas << endl;
            cout << "Saia Shenlong e realize o meu desejo";
        }
  
}
