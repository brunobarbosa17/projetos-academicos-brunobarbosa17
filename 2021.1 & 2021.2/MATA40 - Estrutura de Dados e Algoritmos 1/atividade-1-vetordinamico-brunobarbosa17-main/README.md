[![Open in Visual Studio Code](https://classroom.github.com/assets/open-in-vscode-f059dc9a6f8d3a56e377f745f24479a46679e63a5d9fe6f495e02850cd0d8118.svg)](https://classroom.github.com/online_ide?assignment_repo_id=5444853&assignment_repo_type=AssignmentRepo)
# Atividade 1 - Classes (TADs) e Alocação Dinamica de memória

## Objetivos:

- Reforçar o conceito de Tipo Abstrato de Dados (TAD), implementado na forma de Classes em C++;
- Compreender de forma prática o conceito de alocação dinamica de memória;
- Implementar, em linguagem C++, um tipo abstrato (vetor dinâmico) e utiliza-lo em um programa.

## Conceitos básicos:

A implementação do TAD `cVetorDin` está baseada na idéia de que o tamanho do vetor será definido em tempo de execução, quando da criação de um objeto dessa Classe. Portanto, é possível criar diversos objetos da classe `cVetorDin` com capacidade de armazenamento distintos. 

Para isso, a classe precisa controlar a capacidade de armazenamento e sua ocupação, o que é feito atravéz dos seus atributos `tamanho` e `numElementos`. Todos os métodos dessa classe deverão consultar/atualizar essas informações, de modo que sempre estejam em consonância com o preenchimento do vetor em um determinado instante do programa que o utiliza. Por isso, esses atributos são criados com o modificador de acesso `private`.

Para sedimentar esses conceitos, sugiro a leitura de [1] ou [2].

### Seu trabalho:

A partir do código base fornecido nesse repositório, complemente o TAD `cVetorDin` para que seja possível:

1. Criar um vetor inicializado com: 
	1. um valor constante em todos os seus elementos;
	2. valores sequenciais dentro de um intervalo `[i..f]` fornecido como parametro (críticas devem ser feitas para tratar casos onde o intervalo não está em consonancia com o tamanho do vetor);
	3. valores randomicos;
	4. valores randomicos dentro de um intervalo `[i..f]` fornecido como parametro.
2. Inserir novos valores dentro do vetor:
	1. no seu final;
	2. no seu inicio;
	3. em uma posição especifica (que deve ser validada em relação).
3. Remover um elemento do vetor, dada sua posição.
4. Limpar o vetor, removendo todos os seus elementos.
5. Imprimir no dispositivo de saida:
	1. todas as informações do vetor;
	2. a lista de todos os elementos contidos no vetor:
		1. na ordem de armazenamento;
		2. na ordem inversa do armazenamento.

#### Desafios:

Se voce chegou até aqui com facilidade, tente implementar métodos para:

1. Concatenar dois vetores `v0` e `v1`: 
	O vetor `v0`, que chama esse método, recebe um outro vetor `v1` como parametro e transfere todos os seus elementos para o final de `v0`. Ao final do processo `v1` fica vazio.
2. Misturar dois vetores `v0` e `v1` em um terceiro vetor `v3`: 
	O vetor `v3`, que chama esse método, recebe dois vetores `v0` e `v1` como parametros e "mistura" os elementos de `v0` e `v1` de forma alternada. Caso `v3` tenha elementos esses serão perdidos. Ao final do processo `v0` e `v1` permanecem com seus elementos.

### Commentários:

Utilize o programa `TADExample.cpp` para testar as operações/métodos a medida que voce for implementando-os. Não há necessidade de **"interface com o usuário"**, ou seja, gerar perguntas para o usuário sobre o que deve ser feito.  

Todas as funções do TAD devem garantir que o vetor esteja sempre consistente. Portanto, operações que não podem ser executadas por qualquer inconsistencia (inserir um elemento em um vetor cheio ou tentar remover um elemento de um vetor vazio, por exemplo) devem ser impedidas e sinalizadas ao programa que chama o método, para que este trate a impossibilidade de execução da operação. Em outras palavras, os métodos do TAD não devem imprimir mensagens ou solicitar dados para o usuário, mas sim indicar ao programa que invocou o método para que esse decida o que deve ser feito: avisar ao usuário por mensagem, abortar a execução do programa, etc. 

### Referencias Bibliográficas

[1] Resende, Rodolfo S. F., **Definição e uso de classes**, notas de aula, UFMG, 
disponível em: https://homepages.dcc.ufmg.br/~rodolfo/aedsi-2-10/Classes/classe.html

[2] Drozdek, Adam. **Estrutura de Dados e Algoritmos em C++**. 2ª edição, Cengage Learning, 2016. disponível em: http://library.lol/main/632CB6346878AD4F1184148DD672B3B3
