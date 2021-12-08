#include <iostream>

#include "noPaciente.h"

typedef struct
{
	std::string numSus;
	float idade;
	int risco;
	bool encontra;
} dadosPaci;

class noPaciente;

class filaEspera
{

private:
	noPaciente *inicio;
	int numPaciente;

public:
	filaEspera();

	~filaEspera();

	bool inserePaciente(std::string numSus, float idade, int risco);

	bool editaPaciente(std::string numSus, int risco);

	dadosPaci buscaPaciente(float base, float topo);

	bool PacienteEsperando(int categoria);

	bool removePaciente(std::string numSus);

	bool chamarPaciente(int categoria);	//chamar proximo paciente na fila por categoria: 0 Neonatal, 1 Pediatrico, 2 Adulto.
	
	bool recebeDadosGerador();

	int tamanho();

	friend std::ostream &operator<<(std::ostream &output, const filaEspera &f);
};