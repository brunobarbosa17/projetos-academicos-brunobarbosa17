#include<iostream>

#include "noPaciente.h"

// ******************************************************

noPaciente::noPaciente()
{ 
	paci.idade = 0;
	paci.numSus = "";
	paci.risco = 0;

	prox = NULL;
}

// ******************************************************

noPaciente::noPaciente(std::string numSus, float idade, int risco) 
{
	paci.idade = idade;
	paci.numSus = numSus;
	paci.risco = risco;

	prox = NULL;
}

// ******************************************************

noPaciente::~noPaciente() {}

// ******************************************************

void noPaciente::setPaciente(int risco) 
{
	paci.risco = risco;
}

// ******************************************************

void noPaciente::setProx(noPaciente* p) 
{
	prox = p;
}

// ******************************************************

std::string noPaciente::getSus()
{

	return paci.numSus;
}

float noPaciente::getIdade()
{

	return paci.idade;
}

int noPaciente::getSituacao()
{

	return paci.risco;
}

std::string noPaciente::getGravidade()
{
	switch (paci.risco)
	{
	case 0:
		return "Não Urgente (Azul)";
		break;

	case 1:
		return "Pouco Urgente (Verde) ";
		break;

	case 2:
		return "Urgente (Amarelo)";
		break;

	case 3:

		return "Muito Urgente (Laranja)";
		break;

	case 4:
		return "Emergência (Vermelho)";
		break;
		
	default:
		return "";
		break;

	}
}

// ******************************************************

noPaciente*  noPaciente::getProx() 
{

	return prox;
}