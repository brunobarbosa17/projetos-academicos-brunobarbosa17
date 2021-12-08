#include <iostream>

typedef struct
{
  std::string numSus;
  float idade;
  int risco;
} noPaci;

class noPaciente
{
private:
  noPaci paci;
  noPaciente *prox;

public:
  noPaciente();
  noPaciente(std::string numSus, float idade, int risco);
  ~noPaciente();

  void setPaciente(int risco);
  void setProx(noPaciente *p);

  std::string getSus();
  float getIdade();
  int getSituacao();
  std::string getGravidade();

  noPaciente *getProx();

  friend std::ostream &operator<<(std::ostream &output, const noPaciente &n);
};