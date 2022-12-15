#include <iostream>
#include <vector>
#include <algorithm>

using namespace std;

int main() {
    int n;
    cin >> n;

    int tradicional = 0, geleia = 0;
    for (int i = 0; i < n; i++) {
        int aux;
        cin >> aux;
        if (aux == 10) {
            tradicional++;
        } else {
            geleia++;
        }
    }
    if (tradicional > geleia) {
        cout << "Tradicional" << endl;
    } else {
        cout << "Geleia" << endl;
    }
    
}
