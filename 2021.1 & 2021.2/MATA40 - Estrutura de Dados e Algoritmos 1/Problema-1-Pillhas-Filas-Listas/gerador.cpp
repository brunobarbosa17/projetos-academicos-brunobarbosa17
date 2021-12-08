#include <iostream>

#include <stdlib.h> //srand, rand
#include <time.h>   //time

#include "gerador.h"

Paciente::Paciente()
{

    for (int i = 0; i < 15; i++) // gerar Identificação do sus
        sus += std::to_string(rand() % 9);

    idade = rand() % (100) / 1.0; // gerar idade

    gravidade = rand() % 4; // gerar gravidade de 0 a 4

}

Paciente::~Paciente()
{
    sus = "";
    idade = 0;
    gravidade = 0;

}

double Paciente::getIdade()
{
    return idade;
}

std::string Paciente::getSUS()
{
    return sus;
}

int Paciente::getGravidade()
{
    return gravidade;
}

// ****************************
// ****************************
// ****************************
// ****** Atualiza Paci *******

alteraGravidade::alteraGravidade()
{
    gravidade = 0;
    probab = 0;
}

alteraGravidade::~alteraGravidade()
{
}

int alteraGravidade::alteraRisco(int risco)
{
    // Probabilidade de alterar a gravidade do paciente:
    int gravid = risco;
    int prob = (rand() % 100); // gerar probabilidade 0 a 100

    if (prob < 10)
        gravid--; // 10% de probabilidade de diminuir a gravidade
    else if (prob < 20)
        gravid++; // 10% de probabilidade de aumentar a gravidade (10~20)

    // ajustando limites de gravidade
    if (gravid < 0)
        gravid = 0;
    if (gravid > 4)
        gravid = 4;

    return gravid;
}


std::string Paciente::convertGravidade(){

    switch (gravidade)
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

void Paciente::infoPaciente(){
	

	std::cout << "-----------------------------------" << std::endl;
	
	std::cout << "SUS: " << sus << std::endl;
	std::cout << "Idade: " << idade << std::endl;
	std::cout << "Gravidade: " << convertGravidade() << std::endl;
} 