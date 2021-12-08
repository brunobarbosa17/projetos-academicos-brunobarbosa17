class cVetorDin	{
private:
	int* v;
	int tam;
	int numElem;
	bool criado;

public:
// 1 - Construtores
	cVetorDin(); // construtor default
	cVetorDin(int N, int valor); // Construtor com valor constante 1.I
	cVetorDin(int N, int val_i, int val_f); // 1.II
	cVetorDin(int N, int k, int i, int f); // 1.III
// 2 - Inserir
	void inserirNoFinal(int valor); // 2.I
	void inserirNoInicio(int valor); // 2.II
	void inserirNoIndice(int valor, int indice); // 2.III
// 3 - Remover Elemento de um Vetor na sua posição
	void removerElemento(int indice); // 3

// 4 - Limpar todos os elementos do vetor
	void deleteVetor(); // Deconstrói o vetor

// 5 - Gerar informações gerais sobre o vetor
	void informacoes();
};