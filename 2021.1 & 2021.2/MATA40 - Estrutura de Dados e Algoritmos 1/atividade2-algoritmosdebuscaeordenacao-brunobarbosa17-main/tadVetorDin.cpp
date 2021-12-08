#include <iostream>
#include <time.h>
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
	for (int u = 0; u < tam; u++) {
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
		// cout << "/*********************/" << endl;
		// cout << "Saida na ordem inversa: " << endl;
		// for (int i = numElem-1; i > -1; i--){
		// 	cout << "Elemento[" << i << "] = " << v[i] << endl;
		// }
		
	}
}

// g++ TADExample.cpp g++ tadVetorDin.cpp -o Executavel.exe COMANDO PARA RODAR O ARQUIVO




// Implementação dos métodos de ordenação

void cVetorDin::ordernarBubble() {
	int k, j, aux,vezes=0;
	for (k = 0; k < numElem - 1; k++) {
		for (j = 0; j < numElem - k - 1; j++) {
			if (v[j] > v[j + 1]) {
				vezes++;
				aux = v[j];
				v[j] = v[j + 1];
				v[j + 1] = aux;
			}
        }
    }

		if(verificaOrdenado()) {
			cout << "O vetor foi ordenado com o metodo Quick Sort gerando " << vezes << " comparacoes tendo custo minimo O(n^2)." << endl;
		}
}

void cVetorDin::ordernarOddEven() {
	int vezes=0;
    bool sort = false;

        while (!sort) {
					sort = true;
					for (int i = 1; i < numElem - 1; i += 2) {
							if (v[i] <= v[i + 1]) continue;
							int temp = v[i];
							v[i] = v[i + 1];
							v[i + 1] = temp;
							sort = false;
							vezes++;
					}
					for (int i = 0; i < numElem - 1; i += 2) {
							if (v[i] <= v[i + 1]) continue;
							int temp = v[i];
							v[i] = v[i + 1];
							v[i + 1] = temp;
							sort = false;
						vezes++;
					}
			}

			if(verificaOrdenado()) {
				cout << "O vetor foi ordenado com o metodo Odd Even gerando " << vezes << " comparacoes tendo custo minimo de O(N^2)." << endl;
			}
}

void cVetorDin::ordernarCockTail() {
    int length = numElem,bottom = 0,top = numElem-1, swapped=0,i,aux,vezes=0;
    while(swapped == 0 && bottom < top) {
        swapped = 1;
				vezes++;
				for(i = bottom; i < top; i = i + 1) {
					vezes++;
            if(v[i] > v[i + 1]) {
                aux=v[i];
                v[i]=v[i+1];
                v[i+1]=aux;
                swapped = 0;
            }
        }
        top = top - 1; 

        for(i = top; i > bottom; i = i - 1) {
					vezes++;
					if(v[i] < v[i - 1]) {
						vezes++;
						aux=v[i];
						v[i]=v[i-1];
						v[i-1]=aux;
						swapped = 0;
            }
        }
        bottom = bottom + 1;  
    }
		if(verificaOrdenado()) {
			cout << "O vetor foi ordenado com o metodo Cock Tail gerando " << vezes << " comparacoes tendo custo minimo de O(n^2)." << endl;
		}
}

void cVetorDin::ordenarQuickSort(int left, int right) {
    int i, j, x, y,vezes=0;     
    i = left;
    j = right;
    x = v[(left + right) / 2];
     
    while(i <= j) {
			vezes++;
			while (v[i] < x && i < right) {
				vezes++;
				i++;
        }
        while(v[j] > x && j > left) {
					vezes++;
					j--;
        }
        if(i <= j) {
					vezes++;
            y = v[i];
            v[i] = v[j];
            v[j] = y;
            i++;
            j--;
						
        }
				
    }

    if(j > left) {
			vezes++;
			ordenarQuickSort(left, j);
    }
		if (i < right) {
			vezes++;
        ordenarQuickSort(i, right);
    }

		if(verificaOrdenado()) {
			cout << "O vetor foi ordenado com o metodo Quick Sort gerando " << vezes << " comparacoes tendo custo de O(n log n)." << endl;
		}
}

bool cVetorDin::verificaOrdenado() {
    for (int i = 1; i < numElem; i++) {
        if (v[i - 1] > v[i]) {
            return 0;
        }
    }
    return 1; 
}

void cVetorDin::unir(int p, int q, int r) {
  int n1 = q - p + 1;
  int n2 = r - q;

  int L[n1], M[n2];

  for (int i = 0; i < n1; i++){
		vezesMerge++;
    L[i] = v[p + i];
	}
  for (int j = 0; j < n2; j++) {
		vezesMerge++;
    M[j] = v[q + 1 + j];
	}

  int i, j, k;
  i = 0;
  j = 0;
  k = p;

  while (i < n1 && j < n2) {
		vezesMerge++;
    if (L[i] <= M[j]) {
      v[k] = L[i];
      i++;
    } else {
      v[k] = M[j];
      j++;
    }
    k++;
  }

  while (i < n1) {
		vezesMerge++;
    v[k] = L[i];
    i++;
    k++;
  }

  while (j < n2) {
		vezesMerge++;
    v[k] = M[j];
    j++;
    k++;
  }
	
};

void cVetorDin::ordernarMerge(int l, int r) {
  if (l < r) {
    int m = l + (r - l) / 2;
    ordernarMerge(l, m);
    ordernarMerge(m + 1, r);
    unir(l, m, r);
  }
	if(verificaOrdenado())
	cout << "O vetor foi ordenado com o metodo Merge Sort gerando " << vezesMerge << " comparacoes." << endl;
}


// Metodos de Busca

bool cVetorDin::buscaSequencialOrd(int k) {
	if (v == NULL)			
		return false;

	for (int i = 0 ; i < numElem ; i++)	
		if (v[i] == k) {
			cout << "O valor: " << k << " foi encontrado no indice : " << i << endl;
			return true;		
		}			
		else					
			if (v[i] > k)
				return false;		

	return false;
}

bool cVetorDin::buscaBinaria(int k) {

int i = 0,
	f = numElem-1;

	if (v == NULL)				
		return false;

	while ( i <= f ) {
		int medio = (i + f) / 2.0;	

		if (k == v[medio]){
			cout << "O valor: " << k << " foi encontrado no indice : " << i << endl;
			return true;				 
		}			

		if (k > v[medio]) 				
			i = medio + 1; 				
		else
			f = medio - 1;
		}
	return false;
}
