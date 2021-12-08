# Problema II — Chegou o 5G

## 2021.1 Estrutura de Dados e Algoritmos I — Prof. Antonio L. Apolinário Júnior

**Desenvolvido por:** Bruno de Lucas Santos Barbosa, Elis Marcela de Souza Alcantara, Felipe Guimarães Izidoro Freire e Lucas Morais Barreto.

# O problema:
Um grande investidor “anjo”, amante da cultura e culinária baianas, sabendo que a UFBA agora tem um Instituto de Computação (IC), decidiu apoiar um grande projeto de tecnologia sediado no novo Instituto. Ele pretende aportar alguns milhares de dólares/euros para desenvolver uma solução voltada ao planejamento da cobertura 5G nas principais cidades do Brasil.

- Soluções focadas na etapa de planejamento devem ser rápidas e eficientes, sendo capazes de simular mudanças de cenários quase em tempo real, em cidades com demanda de grande cobertura. 

- O principal problema, segundo o “anjo”, na etapa de planejamento é verificar se a cobertura da distribuição de antenas de médio e pequeno alcance é adequada. Para fazer essa verificação, deve-se aferir se, dada uma localização na cidade, a antena mais próxima é capaz de fornecer cobertura com seu raio de alcance. 

- No momento, o “anjo” quer apenas verificar se o IC/UFBA possui capacidade técnica para desenvolver o projeto. Para avaliar possíveis equipes de desenvolvimento ele propôs como desafio o desenvolvimento de um protótipo como “prova de conceito”<br>
-  Esse protótipo deverá avaliar o núcleo do sistema de planejamento, ou seja, a estrutura de dados e os algoritmos que permitirão verificar a cobertura das antenas em qualquer ponto da cidade (domínio). Após a análise desse protótipo por consultores especializados, o “anjo” irá fechar o contrato com o grupo que apresentar a melhor proposta. 

## O protótipo deve considerar os seguintes aspectos/requisitos/restrições:

A escolha da estrutura de dados e dos algoritmos devem estar pautados na sua eficiência computacional, ou seja, seu custo deve ser o mais baixo possível, para grandes quantidades de dados;
A identificação da antena mais próxima deve ser feita da forma mais eficiente e rápida possível [2];
A distribuição espacial das antenas deve considerar apenas sua localização no plano do domínio da cidade, ou seja, a altura das antenas não terá influência no seu alcance;
Todas as antenas terão o mesmo alcance, default ou fornecido como um dos parâmetros do protótipo;
O protótipo deve permitir que a distribuição das antenas seja fornecida via arquivo ou gerada aleatoriamente;

# Descrição do projeto:

<p style="text-align: justify">
Na fase inicial do projeto, levamos um tempo para identificar algumas bases teóricas necessárias para a formulação de algumas questões chaves da construção.
Mas, conseguimos identificar alguns pontos importantes, como a necessidade de levar em consideração a complexidade dos algoritmos, a velocidade de execução.
E em paralelo a isso, uma das primeiras ideiais foi a de utilizar uma árvore binária de busca, além de omo utilizar entrada de arquivos externos, fazendo uma leitura de um .txt, ou caso não houvesse, sendo gerado de forma aleatória.<br>

Após isso, estávamos cientes que deveríamos utilizar uma Árvore como estrutura de dados principal, porém, a dúvida que surgiu foi: 
## Qual das possibilidades de árvore utilizar?
Para responder esta pergunta fomos em busca de duas possibilidades
- Árvore KD-Tree
  
  > Uma árvore quádrupla, às vezes quadtree, árvore Q ou QT, é um termo de ciência da computação que se refere a um método de organização de dados em quatro quadrantes. Os bancos de dados às vezes usam árvores quad para armazenar e encontrar seus registros. Esse tipo de estrutura organizacional funciona especialmente bem para encontrar um bit ou pixel específico em uma imagem bidimensional.
- Árvore Quad-Tree
  
  > A Kd-Tree  é uma árvore de busca binária de k
dimensões que se caracteriza por testar, em cada nodo
percorrido, um valor chave. Esse valor chave está
associado a um discriminador. O discriminador indica
qual dimensão da Kd-Tree foi utilizada para determinar
o valor chave que divide os nodos restantes em duas subárvores. Os nodos com os valores dessa dimensão
maiores que o valor chave são armazenados do lado
direito e os restantes do lado esquerdo do nodo
percorrido. A Kd-Tree é eficiente para consultas que
envolvam proximidade. As consultas de proximidade
geralmente são feitas com base em um ponto central e
um raio de busca. O resultado é um conjunto de pontos
contidos dentro dessa região circular (área de buffer).

Decidimos por utilizar a **Árvore KD-Tree** para este projeto, pois, utilizaríamos as coordenadas X e Y de geolocalização da nossa cidade.

# Árvore KD-TREE
A escolha desta árvore se dá principalmente pela adaptação do nosso problema, pois a estrutura da KD-TREE se encaixa de forma mais fácil para balancear os nós, diferente da Quad-Tree.
Pois utilizaremos as coordenadas X e Y, podendo desconsiderar a coordenada Z, que no nosso problema se refere à altura.

- ## Complexidade
Como a KD-TREE se destaca quando o assunto é busca por um raio, precisávamos de uma estrutura que tivesse um custo eficiente e não causasse problemas, sendo uma Árvore Binária de busca tem seu custo em procurar os nós em:
> Caso Médio: O (log n)

> Pior Caso: 	O (n)

- ## Vizinho mais próximo
Uma das questões levantadas durante nossos estudos foi sobre como encontrar o vizinho mais próximo a partir de um determinado ponto e chegamos a dois algoritmos
> Algoritmo de Dijkstra x K-nn (nearest neighbors)

Porém, o Algoritmo de Dijkstra envolvia uma complexidade que fugia da nossa possibilidade, então buscamos pelo Algoritmo K-nn, o Nearest Neighbors.<br>
Que tem como objetivo realizar uma busca em determinado conjunto qual elemento está mais próximo de um determinado ponto (No nosso caso, o click do mouse).<br>
Considerando que o algoritmo percorra todos os pontos de um determinado conjunto, e para cada ponto obtenha-se todas as informações do vizinho mais próximo obtêm-se uma complexidade a grosso modo de: O (n²)
</p>

