[![Open in Visual Studio Code](https://classroom.github.com/assets/open-in-vscode-f059dc9a6f8d3a56e377f745f24479a46679e63a5d9fe6f495e02850cd0d8118.svg)](https://classroom.github.com/online_ide?assignment_repo_id=5906179&assignment_repo_type=AssignmentRepo)
# Problema I — Regulação de Leitos

## 2021.1 Estrutura de Dados e Algoritmos I — Prof. Antonio L. Apolinário Júnior

**Desenvolvido por:** Bruno de Lucas Santos Barbosa, Elis Marcela de Souza Alcantara, Felipe Guimarães Izidoro Freire e Lucas Morais Barreto.

## O problema:

<p style="text-align: justify">
Uma empresa de desenvolvimento de software pretende desenvolver um sistema de regulação de leitos para estados e municípios, para o gerenciamento de leitos de UTI. Para iniciar os trabalhos a empresa pretende contratar a sua equipe para elaborar um estudo sobre que tipo de estrutura de dados deve ser utilizada no núcleo do sistema.
<br>
Para demonstrar que sua proposta de estrutura de dados e seus algoritmos funcionam de forma adequada, os donos da empresa, ex-programadores com grande experiência em desenvolvimento de algoritmos e estruturas de dados, solicitaram que sua equipe gerasse um simulador para avaliar sua solução. 
<br>
O simulador deve ser capaz de criar, de forma aleatória, demandas e disponibilidade de leitos. O sistema deve então gerenciar a alocação dos leitos e, se necessário, a espera por leitos. Um mapa da situação do sistema deve ser apresentado a cada instante, onde possamos ter ideia da situação do processo, ou seja, identificar se o sistema está sobrecarregado ou com subutilização.  
Os donos da empresa enfatizaram que não há necessidade de uma interface gráfica “sofisticada”, já que estão mais preocupados com a eficiência dos seus algoritmos e estruturas de dados que vocês irão utilizar. 
<br>
Um requisito importante para os donos da empresa é que o núcleo deve ser genérico e versátil, uma vez que os planos da empresa envolvem utilizar desse núcleo para regular também leitos ambulatoriais e até consultas. 
<br>
Outra restrição importante é que a codificação deve ser feita em C++ ANSI, que é a linguagem de desenvolvimento utilizada em todos os aplicativos desenvolvidos pela empresa. A documentação e estruturação do seu código também será avaliada, uma vez que, finalizado o projeto, este núcleo deverá ser utilizado pelos programadores da empresa para desenvolver o sistema. 
</p>

## Descrição do projeto:

<p style="text-align: justify">
Iniciado o projeto foi pensado primeiramente no ranqueamento e identificação dos pacientes, pois há demanda por uma estrutura que possa fornecer essa facilidade de ordenar os pacientes de acordo com os requisitos do sistema e também concluiu-se que seria necessário utilizar mais de uma estrutura, assim foi preciso avaliar como seria feita a integração entre elas, e a partir disso chegou-se ao entendimento de que as melhores estruturas para realizar essa implementação são as pilhas e filas.

A princípio, foram identificados os dados necessários para a construção do sistema de solicitação de vagas, assim foi organizada uma struct para os pacientes em fila de espera, com as seguintes informações: número de SUS, idade e o risco, sendo este interpretado em uma sequência númerica, na qual 0 é o caso de menor urgência e o 4 é o mais urgente. Esses dados são reutilizados no gerador para realizar a simulação.

```
typedef struct
{
  std::string numSus;
  float idade;
  int risco;
} noPaci;
```

Já na estrutura de leitos disponíveis foi considerado um id único que diferencia os leitos entre si, a classificação e o número SUS do paciente que está ocupando-o, além de um ponteiro apontando para o próximo. Cada nó contém as informações do leito.

```
struct No{
  int idLeito;
  int classificacao;
  bool disponivel;
  string susPaciente;
  No* proximo;
};
```

Durante o desenvolvimento da classe do hospital foi pensado em um modelo que atendesse as demandas geradas pelas outras estruturas, então foram elencadas como relevantes as seguintes informações: máximo de vagas e para cada categoria o total de leitos e a ocupação, por fim um ponteiro para o topo da estrutura.

Class hospital:
```
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
}
```

Para relacionar os dados e assim direcionar os pacientes para as vagas foi desenvolvido um gerador que popula os dados da simulação e a integração de todas as estruturas envolvidas se encontra no [núcleo](https://github.com/MATA40-2021-2/problema-i-grupo-ii/blob/main/nucleo.cpp). 

Para a implementação das classes e structs, foram utilizados os seguintes métodos: getters e setters, funções para checar se a estrutura está sobrecarregada ou vazia, funções para auxiliar na simulação de hipotéses gerando dados aleatórios e construtores e destrutores.
<br>
    
[Métodos da fila de espera.](https://github.com/MATA40-2021-2/problema-i-grupo-ii/blob/main/filaEspera.cpp)
<br>
[Métodos da geração.](https://github.com/MATA40-2021-2/problema-i-grupo-ii/blob/main/gerador.cpp)
<br>
[Métodos dos pacientes.](https://github.com/MATA40-2021-2/problema-i-grupo-ii/blob/main/noPaciente.cpp)

## Estruturas utilizadas:
### Leitos do Hospital: Pilha
> Uma pilha é uma matriz ou estrutura de lista de chamadas de função e parâmetros. Semelhante a uma pilha de pratos em um restaurante, os elementos em uma pilha são adicionados ou removidos do topo da pilha, seguindo o conceito: “último a entrar primeiro, primeiro a sair” ou ordem LIFO. O processo de adicionar dados a uma pilha é conhecido como "push", enquanto a recuperação de dados de uma pilha é chamada de "pop". Isso ocorre no topo da pilha. Um ponteiro de pilha indica a extensão da pilha, ajustando conforme os elementos são empurrados ou colocados em uma pilha. Quando uma função é chamada, o endereço da próxima instrução é colocado na pilha. Quando a função é encerrada, o endereço é retirado da pilha e a execução continua naquele endereço. Em uma pilha “ideal”, operações básicas devem ocorrer em O(1), independentemente do tamanho N da pilha (ou seja, em tempo constante).
###
O módulo de alocação de vagas é uma pauta largamente mencionada nas discussões da área de informática médica, acredita-se que a combinação de computadores, redes de comunicação e informática médica podem melhorar a qualidade do atendimento na saúde, facilitando o acesso ao atendimento médico e consequentemente salvar vidas. A partir disso, conclui-se que a preferência de liberação de leitos deveria seguir um sistema de pilhas, ou seja, o última a entrar na pilha deve ser o primeiro a sair, pois a urgência por leitos demanda que assim seja.
### Fila de espera: Fila Simplesmente Encadeada
> Na estrutura de fila, os acessos aos elementos também seguem uma regra. O que diferencia a fila da pilha é a ordem de saída dos elementos: enquanto na pilha “o último que entra é o primeiro que sai”, na fila “o primeiro que entra é o primeiro que sai” (a sigla FIFO – first in, first out - é usada para descrever essa estratégia). A idéia fundamental da fila é que só podemos inserir um novo elemento no final da fila e só podemos retirar o elemento do início.
###
A estrutura de fila é uma analogia natural com o conceito de filas que usamos no nosso dia a dia, como no problema apresentado (uma fila hospitalar): cada paciente inserido na fila ocupa um determinado espaço assim como cada elemento adicionado na fila ocupa um espaço na memória e a movimentação desses elementos deve seguir determinada ordem, quando retira-se o primeiro item da fila o segundo vira o primeiro e segue-se uma ordem de prioridade tangenciando a urgência.
</p>
