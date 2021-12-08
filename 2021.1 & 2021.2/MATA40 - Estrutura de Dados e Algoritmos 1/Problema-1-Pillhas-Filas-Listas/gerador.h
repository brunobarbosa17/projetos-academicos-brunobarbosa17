/* Essa classe faz referência à "vaga.h" feita por @Elis */

#include <iostream>
#include <string>
#include <time.h> //time

class Paciente
{

private:
    // dados do paciente:
    std::string sus;
    double idade;
    int gravidade;

public:
    Paciente();
    ~Paciente();

    int alteraGravidade(int risco);

    std::string getSUS();
    int getGravidade();
    double getIdade();
    std::string convertGravidade();
    void infoPaciente();
};

class alteraGravidade
{
private:
    int gravidade;
    int probab;

public:
    alteraGravidade();
    ~alteraGravidade();
  
    int alteraRisco(int risco);
};
