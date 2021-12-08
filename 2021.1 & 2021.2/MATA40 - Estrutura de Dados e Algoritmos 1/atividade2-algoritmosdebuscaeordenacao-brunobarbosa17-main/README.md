[![Open in Visual Studio Code](https://classroom.github.com/assets/open-in-vscode-f059dc9a6f8d3a56e377f745f24479a46679e63a5d9fe6f495e02850cd0d8118.svg)](https://classroom.github.com/online_ide?assignment_repo_id=5573009&assignment_repo_type=AssignmentRepo)
# Atividade 2

## Análise de Complexidade dos Algoritmos de Busca e Ordenação

Durante as aulas teóricas, apresentamos e discutimos o funcionamento e a complexidade de algoritmos para resolver dois dos prinncipais problemas da Ciência da Computação: **Busca** e **Ordenação**.

Ao analisarmos os algoritmos vimos que os exemplos apresentados pertencias as classes de complexidade ***O(n)***, ***O(log(n))***, ***O(n.log(n))*** e ***O(n^2)***. Essas classes portanto indicam como a taxa de crescimento assintótica relacionada ao esforço computacional dos algoritmos pode ser caractarizada. Mas, como discutido, na prática mesmo algoritmos da mesma classe podem ter comportamentos diferentes entre sí, sem contudo descaracterizar sua classe de complexidade. 

Nessa atividade vamos testar na prática o comportamento da implementação dos algoritmos de busca e ordenação e compara-los com os resultados teóricos apresentados. Para isso voce deve: 

1. A partir da **Tipo Abstrato de Dados** `cVetorDin` desenvolvido na atividade 1 implemente os métodos de ordenação:
	1. <s>*Bubble Sort*;</s>
	2. <s>*Odd-Even Sort*;</s>
	3. <s>*Cocktail Sort*;</s>
	4. *Merge Sort*;
	5. <s>*Quick Sort*;</s> 

> 
> Os métodos *Odd-Even Sort* e *Cocktail Sort* são variantes do *Bubble Sort*. 
> 
> Entenda melhor o seu funcionamento em: https://sorting.at/
> 

1. Teste seus métodos verificando se vetores criados com valores randomicos ficam ordenados após sua execução (se quiser automatize o processo com um método *private* para teste). 

1. De posse dos métodos de ordenação funcionando, implemente os métodos de busca:
	1. <s>Linear Sequencial;</s><br>
	2. <s> Binária.</s>
1. A seguir construa um programa que permita a analise e comparação da implementação dos algoritmos e suas complexidades teóricas:
	1. O usuário deve fornecer o numero de elementos para teste (`n`) e o numero de repetições (`k`) que o teste deve ser feito e qual algoritmo deve ser testado. 
	1. O simulador deve então gerar `k` execuções do algoritmo selecionado, com dados diferentes a cada rodada, e computar o numero de comparações médio final. 
	1. Ao final voce deve fornecer o valor da ordem do numero de comparações esperado, dado pela complexidade do algoritmo, e o número de comparações médio, obtido pela simulação com dados "reais". 

Por se tratar de uma atividade simples, minha sugestão é que voces tentem codificar "do zero" os algoritmos em questão. É um ótimo exercicio para ganhar fluidez em codificação. 

## Referencias Bibliográficas:

[1] 	Ziviani, N., [Projeto De Algoritmos Com Implementações Em Pascal E C](https://book4you.org/book/5341203/765418), Cengage Learning. 3a. Edição 2012.
	
[2]	Drozdek,A., [Data Structures and Algorithms in C++](https://book4you.org/book/2315271/c157bc), Cengage Learning, 2012.

[3]	Sedgewick, R., Van Wyk, C. J., [Algorithms in C++, Parts 1-4: Fundamentals, Data Structure, Sorting, Searching](https://book4you.org/book/11023105/8c786b), Addison-Wesley Professional, 1998.
