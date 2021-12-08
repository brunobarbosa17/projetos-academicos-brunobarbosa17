#include <iostream>
#include <cstdlib>
#include <fstream>
#include <list>
#include <string>
#include <stdlib.h>
#include <vector>
using namespace std;

#include "tadVetorDin.h"

int main() {
	int N = 15, val_i = 10, val_f=15;
	cVetorDin vetor1(N, val_i, val_f);
	vetor1.inserirNoIndice(99, 3);
	vetor1.inserirNoFinal(5);
	vetor1.inserirNoFinal(6);
	vetor1.inserirNoFinal(8);
	vetor1.inserirNoFinal(9);
	vetor1.informacoes();
	system("PAUSE");
	return 0;
}

// g++ TADExample.cpp g++ tadVetorDin.cpp -o Executavel.exe COMANDO PARA RODAR O ARQUIVO