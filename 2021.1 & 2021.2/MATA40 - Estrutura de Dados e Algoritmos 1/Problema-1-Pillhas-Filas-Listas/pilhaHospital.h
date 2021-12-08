#include <iostream>
#include <string>

using namespace std;


struct No{ // Cada no conterá as informações do leito
  int idLeito;
  int classificacao;
  bool disponivel;
  string susPaciente;
  No* proximo;
};

class hospital {
  private:
    int maximoDeVagas;
    int totalLeitosNeoNatal= 0;
    int totalLeitosPediatrico=0;
    int totalLeitosAdulto=0;

    int neoNatalOcupados=0;
    int pediatricoOcupados=0;
    int adultoOcupados=0;

    No* NoTopo;

  public:
    hospital();
    ~hospital();
    bool estacheia();
    bool estavazia();
    
    void inserir(No v);
    void remover();
    void imprimir();
    void gerarLeitoAleatorio();

    std::string convertTipo(int tipoLeito);

    bool ocuparLeito(int tipoLeito);
    bool desocuparLeito();


    int nVagas (int tipoLeito);
    int nOcupados (int tipoLeito);
    void statusGeral();
};
