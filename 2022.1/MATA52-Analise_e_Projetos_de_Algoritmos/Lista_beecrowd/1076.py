from collections import defaultdict

def init__graf(grafo):
  for l in range(V):
    for c in range(V):
      grafo[l][c] = 0;
  return grafo;
        

def dfs(grafeno, inicio, vertices):
  # grafo = grafeno, lembrei dessa perola
  visitados = [1 for i in range(vertices)]
  aux = 0;
  stack = [inicio];
  
  while stack:
    v_aux = stack.pop();
    if (visitados[v_aux] == True):
      aux +=1;
      visitados[v_aux] = 0
      stack.extend(grafeno[v_aux]);
  return aux;
    
  
T = int(input());

for i in range(T):
  grafeno = defaultdict(list)
  N = int(input());
  V, A = [int(i) for i in input().split(" ")];
  for aresta in range(A):
    a1, a2 = [int(i) for i in input().split(" ")]
    grafeno[a1].append(a2);
    grafeno[a2].append(a1);
  result_dfs = dfs(grafeno, N, V)
  print(2 * result_dfs - 2);

  