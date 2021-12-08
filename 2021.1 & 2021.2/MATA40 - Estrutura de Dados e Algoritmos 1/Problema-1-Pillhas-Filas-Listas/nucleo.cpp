#include <iostream>
#include <unistd.h>

#include "filaEspera.h"
#include "gerador.h"
#include "pilhaHospital.h"

int main(int argc, char **argv)
{
    filaEspera LSE;    
    srand(time(NULL));
    
    system("clear"); // Limpar tela Linux

    hospital pilha; 
    int id = 1;
    for(int i = 0; i < 20; i++) {    
      No v; // Cada nó é um leito a ser criado
      int faixa = (rand() % 3);
      v.idLeito = id;
      v.classificacao = faixa;
      pilha.inserir(v); // Populando os leitos e inserindo na classe hospital!
      id++;
    };

    //pilha.imprimir();

    

    //Iniciar com alguns pacientes já em fila
    for (int i=0; i<20; i++){
        Paciente P;      
        LSE.inserePaciente(P.getSUS(), P.getIdade(), P.getGravidade());
    }


    while (true)
    {

        time_t now = time(NULL);
        std::cout << ctime(&now ) << std::endl;   //Atualização em tempo real


        std::cout << "===================================" << std::endl;
	    std::cout << "            LEITOS            " << std::endl << std::endl;
        
        pilha.statusGeral();
        pilha.desocuparLeito(); // Probabilidade definida dentro da função

        std::cout << "===================================" << std::endl <<std::endl;
               
        // Chegada de Novos Pacientes
	    std::cout << "===================================" << std::endl;
	    std::cout << "            CHECK-IN            " << std::endl << std::endl;  //Chegada de novos Pacientes

        int novosPac = (rand() % 5); // chegada de 0 a 5 novos pacientes

        for (int i=0; i<novosPac; i++){     ///probabilidade de chegar um novo paciente
            Paciente P;     
	        P.infoPaciente();
            //std::cout << "Novo Paciente: " << P.getSUS() << std::endl;

            LSE.inserePaciente(P.getSUS(), P.getIdade(), P.getGravidade());
        }
	    std::cout << "===================================" << std::endl << std::endl;

        // Chamar pacientes
	    std::cout << "===================================" << std::endl;
	    std::cout << "            ATENDIMENTO            " << std::endl << std::endl; //Chamada de pacientes

        
        for (int i=0; i<3; i++){

            if (LSE.PacienteEsperando(i)){  //Tem paciente esperando na categoria i?
                if (pilha.ocuparLeito(i)){  // Tem leito disponível na categoria i? se sim, ocupa
                    LSE.chamarPaciente(i);  // Remove Paciente da fila de espera
                } 

            }

        }
        
	    std::cout << "===================================" << std::endl << std::endl;
       
        //Fila de atendimento/ pacientes em espera
        LSE.recebeDadosGerador();       // Atualiza dados dos pacientes, como gravidade
        std::cout << LSE << std::endl;  // Imprime Lista de Espera

/* 
	    std::cout << "===================================" << std::endl;
	    std::cout << "            LEITOS            " << std::endl << std::endl;

        pilha.imprimir();
	    std::cout << "===================================" << std::endl;
*/
        sleep(5);        // delay de 10 seg
        system("clear"); // Limpar tela Linux

    }

}