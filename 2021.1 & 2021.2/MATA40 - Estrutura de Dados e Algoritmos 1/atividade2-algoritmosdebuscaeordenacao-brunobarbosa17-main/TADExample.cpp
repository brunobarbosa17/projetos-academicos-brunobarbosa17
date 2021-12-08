#include <iostream>
#include <time.h>

using namespace std;

#include "tadVetorDin.h"

int main() {
	int elementosTeste, repeticoes, algoritmo;
	cout << "Insira a quantidade de elementos para teste: " << endl;
	cin >> elementosTeste;

	cout << "Insira a quantidade de repeticoes que deseja: " << endl;
	cin >> repeticoes;

	cout << "Insira o numero referente a qual algoritmo deseja testar: " << endl;
	cout << "1 -> BubbleSort " << endl;
	cout << "2 -> Odd Even Sort " << endl;
	cout << "3 -> Cocktail Sort" << endl;
	cout << "4 -> Merge Sort" << endl;
	cout << "5 -> Quick Sort" << endl;
	cin >> algoritmo;


	switch (algoritmo) {
	case 1:
		for(int u = 0; u < repeticoes; u++) {
			int N = elementosTeste, k = elementosTeste, i=1,f=9999;
			cVetorDin vetor1(N, k,i,f);
			vetor1.ordernarBubble();
			vetor1.deleteVetor();
		};
		break;
	
	case 2: 
			for(int u = 0; u < repeticoes; u++) {
			int N = elementosTeste, k = elementosTeste, i=1,f=9999;
			cVetorDin vetor1(N, k,i,f);
			vetor1.ordernarOddEven();
			vetor1.deleteVetor();
		};
		break;

	case 3:
			for(int u = 0; u < repeticoes; u++) {
			int N = elementosTeste, k = elementosTeste, i=1,f=9999;
			cVetorDin vetor1(N, k,i,f);
			vetor1.ordernarCockTail();
			vetor1.deleteVetor();
		};
	break;

	case 4:
			for(int u = 0; u < repeticoes; u++) {
			int N = elementosTeste, k = elementosTeste, i=1,f=9999;
			cVetorDin vetor1(N, k,i,f);
			vetor1.ordernarMerge(0, N);
			vetor1.deleteVetor();
		};
	break;

	case 5:
			for(int u = 0; u < repeticoes; u++) {
			int N = elementosTeste, k = elementosTeste, i=1,f=9999;
			cVetorDin vetor1(N, k,i,f);
			vetor1.ordenarQuickSort(0,N);
			vetor1.deleteVetor();
		};
		break;

	default:
		break;
	}


	system("PAUSE");
	return 0;
}

// g++ TADExample.cpp g++ tadVetorDin.cpp -o teste.exe
