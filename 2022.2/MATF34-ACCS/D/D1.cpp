#include <iostream>
#include <vector>
#include <bits/stdc++.h>

using namespace std;
int main() {
	vector<int> barcos;
	int qtd;
	cin >> qtd;
	int aux;

	for (int i = 0; i < qtd; i++) {
		cin >> aux;
		barcos.push_back(aux);
	}
  
  sort(barcos.begin(), barcos.end(), greater<int>());

  for (int i = 0; i < qtd; i++) {
		cout << barcos[i] << " ";
	}
}
