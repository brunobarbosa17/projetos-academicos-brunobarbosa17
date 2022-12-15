#include <iostream>
#include <vector>
#include <bits/stdc++.h>

using namespace std;
int main() {
	vector<int> vet;
	int qtd;
	cin >> qtd;
	int aux;

	for (int i = 0; i < qtd; i++) {
		cin >> aux;
		vet.push_back(aux);
	}
  
  sort(vet.begin(), vet.end());

  for (int i = 0; i < 8; i++) {
		cout << vet[i] << " ";
	}
}
