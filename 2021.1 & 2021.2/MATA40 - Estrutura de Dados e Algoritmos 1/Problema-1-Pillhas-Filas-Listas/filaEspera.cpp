#include <iostream>

#include "filaEspera.h"
#include "gerador.h"

// ******************************************************

filaEspera::filaEspera()
{
	inicio = NULL;
	numPaciente = 0;
}

// ******************************************************

filaEspera::~filaEspera()
{
	if (inicio == NULL)
	{
		return;
	}

	noPaciente *noCorrente = inicio->getProx();

	while (noCorrente != NULL)
	{
		free(inicio);
		numPaciente--;
		inicio = noCorrente;
		noCorrente = inicio->getProx();
	}

	free(inicio);
	numPaciente--;
}

// ******************************************************

bool filaEspera::inserePaciente(std::string numSus, float idade, int risco) // insere paciente baseado no risco
{
	
	if (risco<2) return false; //paciente não precisa de leito.
	
	noPaciente *novoPaciente = new noPaciente(numSus, idade, risco);

	if (novoPaciente == NULL)
	{
		return false;
	}

	if (inicio == NULL)
	{
		inicio = novoPaciente;
		numPaciente++;
		return true;
	}

	noPaciente *noAux = inicio;

	while ((noAux->getProx() != NULL) && ((noAux->getProx())->getSituacao() >= risco))
	{
		noAux = noAux->getProx();
	}

	if (noAux == inicio) // adição do segundo elemento
	{
		if (noAux->getSituacao() >= risco)
		{
			novoPaciente->setProx(noAux->getProx());
			noAux->setProx(novoPaciente);
			numPaciente++;

			return true;
		}
		else
		{
			novoPaciente->setProx(noAux);
			inicio = novoPaciente;
			numPaciente++;

			return true;
		}
	}

	novoPaciente->setProx(noAux->getProx());
	noAux->setProx(novoPaciente);
	numPaciente++;

	return true;
}

// ******************************************************

bool filaEspera::editaPaciente(std::string numSus, int risco) // localiza o sus do paciente, e o modifica
{
	if (inicio == NULL)
	{
		return false;
	}

	noPaciente *noCorrente = inicio;

	while ((noCorrente != NULL) && (noCorrente->getSus() != numSus))
	{
		noCorrente = noCorrente->getProx();
	}

	if (noCorrente == NULL)
	{
		return false;
	}

	if (noCorrente->getSituacao() == risco)
	{
		return false;
	}

	noCorrente->setPaciente(risco);

	std::string x = noCorrente->getSus();
	float y = noCorrente->getIdade();
	int z = noCorrente->getSituacao();

	removePaciente(numSus);

	inserePaciente(x, y, z);

	return true;
}

// ******************************************************

dadosPaci filaEspera::buscaPaciente(float base, float topo) //busca com base no intervalo de idade
{
	dadosPaci Teste;
	noPaciente *noCorrente = inicio;

	while (noCorrente != NULL)
	{

		if (noCorrente->getIdade() >= base && noCorrente->getIdade() < topo)
		{
			break;
		}

		noCorrente = noCorrente->getProx();
	}

	if (noCorrente == NULL)
	{
		Teste.idade = 0;
		Teste.numSus = "";
		Teste.risco = 0;
		Teste.encontra = false;

		return Teste;
	}

	Teste.idade = noCorrente->getIdade();
	Teste.numSus = noCorrente->getSus();
	Teste.risco = noCorrente->getSituacao();
	Teste.encontra = true;

	return Teste;
}

// ******************************************************

bool filaEspera::removePaciente(std::string numSus)
{
	if (inicio == NULL)
	{
		return false;
	}

	noPaciente *noAux = inicio;
	noPaciente *noCorrente = NULL;

	if (noAux->getSus() == numSus)
	{
		inicio = noAux->getProx();
		free(noAux);
		numPaciente--;

		return true;
	}

	while ((noAux->getProx() != NULL) && ((noAux->getProx())->getSus() != numSus))
	{
		noAux = noAux->getProx();
	}

	noCorrente = noAux->getProx();

	noAux->setProx(noCorrente->getProx());

	free(noCorrente);
	numPaciente--;

	return true;
}

// ******************************************************

bool filaEspera::recebeDadosGerador()
{
	if (inicio == NULL)
	{
		return false;
	}

	noPaciente *noCorrente = inicio;
	alteraGravidade teste;

	while (noCorrente != NULL)
	{
		int x = teste.alteraRisco(noCorrente->getSituacao());

		if (x != noCorrente->getSituacao())
		{
			editaPaciente(noCorrente->getSus(), x);
		}

		noCorrente = noCorrente->getProx();
	}

	return true;
}

// ******************************************************

int filaEspera::tamanho()
{
	return (numPaciente);
}

bool filaEspera::chamarPaciente(int categoria){
	
	float idadeMin, idadeMax;
	std::string categoriaStr = "";

	if (categoria==0){
		idadeMin = 0;
		idadeMax = 1;
		categoriaStr = "Neonatal";
	}
	else if(categoria==1){
		idadeMin = 1;
		idadeMax = 13;
		categoriaStr = "Pediátrico";

	}
	else{
		idadeMin = 13;
		idadeMax = 200;
		categoriaStr = "Adulto";

	}

	dadosPaci proxPaciente = buscaPaciente(idadeMin, idadeMax);


	if (!proxPaciente.encontra){
		return false;
	}

	//std::cout << "**********************" << std::endl;
	std::cout << categoriaStr << std::endl;	//adicionar ID do leito aqui
	std::cout << "SUS: " << proxPaciente.numSus << std::endl;	
	std::cout << "Idade: " << proxPaciente.idade << std::endl;	
	std::cout << "------------------------------" << std::endl;
			
		
	removePaciente(proxPaciente.numSus);
	
	return true;

	

}

bool filaEspera::PacienteEsperando(int categoria){
	float idadeMin, idadeMax;
	std::string categoriaStr = "";

	if (categoria==0){
		idadeMin = 0;
		idadeMax = 1;
		categoriaStr = "Neonatal";
	}
	else if(categoria==1){
		idadeMin = 1;
		idadeMax = 13;
		categoriaStr = "Pediátrico";

	}
	else{
		idadeMin = 13;
		idadeMax = 200;
		categoriaStr = "Adulto";

	}

	dadosPaci proxPaciente = buscaPaciente(idadeMin, idadeMax);
	
	return (proxPaciente.encontra);

}

// ******************************************************

std::ostream &operator<<(std::ostream &output, const filaEspera &f)
{

	if (f.inicio == NULL)
	{
		output << "===================================" << std::endl;
		output << "Fila Vazia" << std::endl;
		output << "===================================" << std::endl;
	}
	else
	{
		output << "===================================" << std::endl;
		output << "******** LISTA DE ESPERA **********" << std::endl;
		output << "Numero de pacientes = " << f.numPaciente << std::endl << std::endl;
		output << "-----------------------------------" << std::endl;

		noPaciente *noCorrente = f.inicio;
		Paciente teste;

		while (noCorrente != NULL)
		{

			output << "SUS:       " << noCorrente->getSus() << std::endl;
			output << "Idade:     " << noCorrente->getIdade() << std::endl;
			output << "Gravidade: " << noCorrente->getGravidade() << std::endl;

			noCorrente = noCorrente->getProx();
			output << "-----------------------------------" << std::endl;
		}

		output << "===================================" << std::endl;
	}

	return output;
}

// ******************************************************
// ******************************************************

