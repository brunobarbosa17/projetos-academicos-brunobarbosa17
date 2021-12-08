#include <iostream>
#include <ctime>
#include "tadVetorDin.h"
using namespace std;

cVetorDin::cVetorDin() { // Constrói o vetor
	v 		= NULL;
	tam 	= 0;
	numElem = 0;
}

cVetorDin::cVetorDin(int N, int valor) { // Preenche o vetor com um valor constante 1.I
	criado = true;
	v 		= new int[N];
	tam 	= N;
	numElem = 0;
	for (int i = 0; i < tam; i++) {
		v[numElem++] = valor;
	}
}

cVetorDin::cVetorDin(int N, int val_i, int val_f) { // 1.II
	if (N < val_f - val_i) {
		cout << "Nao e possivel preencher " << val_f - val_i << " elementos, pois o tamanho maximo e: " << N << endl;
		return;
	}
	int elementos = val_f - val_i;
	criado = true;
	numElem = 0;
	tam = N;
	v = new int[N];
	for (int i = 0; i <= elementos; i++) {
		v[numElem++] = val_i++;
	}
}

cVetorDin::cVetorDin(int N, int k, int i, int f) { // 1.III
	if(k > N) {
		cout << "Nao e possivel criar um vetor de tamanho " << N << " e preencher " << k << " valores." << endl;
		return;
	}
	criado = true;
	v = new int[N];
	this->tam = k;
	numElem = 0;
	srand( time(NULL) );
	for (int i = 0; i < tam; i++) {
		v[numElem++] = rand() % f + 1;
		while (v[numElem] < i) {
			v[numElem] = rand() % f;
		}
	}
}

//********************

void cVetorDin::inserirNoFinal(int valor){ // 2.I
	if (numElem < tam) {
		v[numElem] = valor;
		cout << "Valor inserido!" <<endl;
		numElem++;
	} else {
		cout << "O valor tem tamanho " << tam << " e possui " << numElem << " elementos, por isso nao e possivel inserir no final!" << endl;
	}
}

void cVetorDin::inserirNoInicio(int valor) { // 2.II
	if (numElem < tam) {
		numElem++;
		for (int i = numElem; i >= 0; i--) {
			v[i + 1] = v[i];
		}
		v[0] = valor;
	}
	else {
		cout << "O valor tem tamanho " << tam << " e possui " << numElem << " elementos, por isso nao e possivel inserir no inicio!" << endl;
	}
}

void cVetorDin::inserirNoIndice(int valor, int indice) { // 2.II
	if (indice > numElem && numElem <= tam) {
		cout << "O valor tem tamanho " << tam << " e possui " << numElem << " elementos, por isso nao e possivel inserir no inicio!" << endl;
	}
	else {
		for (int i = numElem; i >= indice; i--) {
			v[i + 1] = v[i];
		}
		v[indice] = valor;
		numElem++;
	}
}

void cVetorDin::removerElemento(int indice) {
	if(indice >= 0 && indice <= numElem) {
		v[indice] = NULL;
	} else {
		cout << "Esta posicao e invalida." << endl;
		return;
	}
}

void cVetorDin::deleteVetor() {
	criado = false;
	delete[] v;
	free(v);
	tam = 0;
	numElem = 0;
	cout << "objeto deletado!" << endl;
};

void cVetorDin::informacoes() {
	if (!criado) {
		cout << "Vetor ainda nao foi criado." << endl;
		return;
	} else {
		cout << "O vetor tem tamanho maximo de " << tam << " elementos." << endl;
		cout << "O vetor contem atualmente " << numElem << " elementos." << endl;
		cout << "/*********************/" << endl;

		cout << "Saida na ordem de armazenamento: " << endl;
		for (int i = 0; i < numElem; i++) {
			cout << "Elemento[" << i << "] = " << v[i] << endl;
		}
		cout << "/*********************/" << endl;
		cout << "Saida na ordem inversa: " << endl;
		for (int i = numElem-1; i > -1; i--){
			cout << "Elemento[" << i << "] = " << v[i] << endl;
		}
	}
}
