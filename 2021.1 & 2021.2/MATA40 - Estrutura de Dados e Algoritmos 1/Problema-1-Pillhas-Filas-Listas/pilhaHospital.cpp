#include <iostream>
#include <ctime>
#include "pilhaHospital.h"

using namespace std;


hospital::hospital() {
  NoTopo = nullptr;
  
}

hospital::~hospital() {
  No* NoTemp;
  while(NoTopo != nullptr) {
    NoTemp = NoTopo;
    NoTopo = NoTopo->proximo;
    delete NoTemp;
  }
}

void hospital::inserir(No v){
    No* NoNovo = new No;
    if(v.classificacao == 0) {totalLeitosNeoNatal++;};
    if(v.classificacao == 1) {totalLeitosPediatrico++;};
    if(v.classificacao == 2) {totalLeitosAdulto++;};
    NoNovo->classificacao = v.classificacao;
    NoNovo->disponivel = true;
    NoNovo->idLeito = v.idLeito;
    NoNovo->proximo = NoTopo;
    NoTopo = NoNovo;
}

void hospital::remover(){
    No* NoTemp;
    NoTemp = NoTopo;
    NoTopo = NoTopo->proximo;
    delete NoTemp;
    return;
}

void hospital::imprimir() {
  
  //Imprime TODOS os leitos

  No* NoTemp = NoTopo;

  while (NoTemp != nullptr) {

    cout << "-----------------------------------" << endl;
    cout << "Leito: ID[" << NoTemp->idLeito << "]" << endl;
    cout << "Classificação: " << convertTipo(NoTemp->classificacao) << endl;
    cout << "Status: " << (NoTemp->disponivel ? "Disponível" : "Ocupado") << endl;

    NoTemp = NoTemp->proximo;
  
  }
}

bool hospital::ocuparLeito(int tipoLeito) {
  No* NoTemp = NoTopo;
  while (NoTemp != nullptr) {
    if(NoTemp->classificacao == tipoLeito && NoTemp->disponivel == true) {
      NoTemp->disponivel = false;
      cout << "Leito n[" << NoTemp->idLeito << "] " ;

      if(NoTemp->classificacao == 0) {neoNatalOcupados++;};
      if(NoTemp->classificacao == 1) {pediatricoOcupados++;};
      if(NoTemp->classificacao == 2) {adultoOcupados++;};
      return true;
    }
    NoTemp = NoTemp->proximo;
  }

  std::cout << "Sem vagas para leito " << convertTipo(tipoLeito) <<std::endl;
  return false;
}

bool hospital::desocuparLeito() {
  No* NoTemp = NoTopo;
  while (NoTemp != nullptr) {
    if(NoTemp->disponivel == false) {
      int prob = (rand() % 100);
      if (prob < 40) {
        cout << "Leito n[" << NoTemp->idLeito << "] Liberado!!!" << endl;
        NoTemp->disponivel = true;
        if(NoTemp->classificacao == 0) {neoNatalOcupados--;};
        if(NoTemp->classificacao == 1) {pediatricoOcupados--;};
        if(NoTemp->classificacao == 2) {adultoOcupados--;};
      }
    }
    NoTemp = NoTemp->proximo;
  }
  return true;
}

std::string hospital::convertTipo(int tipoLeito){

  switch(tipoLeito){
    case 0:
      return "Neonatal";
      break;

    case 1:
      return "Pediátrico";
      break;

    case 2:
      return "Adulto";
      break;

    default:
      return "";
      break;
    
    }
}


int hospital::nVagas(int tipoLeito){
  switch(tipoLeito){
    case 0:
      return totalLeitosNeoNatal;
      break;

    case 1:
      return totalLeitosPediatrico;
      break;

    case 2:
      return totalLeitosAdulto;
      break;

    default:
      return 0;
      break;
    
    }

}

int hospital::nOcupados (int tipoLeito){
  switch(tipoLeito){
    case 0:
      return neoNatalOcupados;
      break;

    case 1:
      return pediatricoOcupados;
      break;

    case 2:
      return adultoOcupados;
      break;

    default:
      return 0;
      break;
    
    }

}


void hospital::statusGeral (){
	  for (int i=0; i<3; i++){
      std::cout << convertTipo(i) << ": " << nOcupados(i) << " de " << nVagas(i) << " leitos ocupados." << std::endl;
    }

}