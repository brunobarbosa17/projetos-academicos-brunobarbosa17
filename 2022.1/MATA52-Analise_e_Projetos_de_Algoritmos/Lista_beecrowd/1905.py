def buscaLinhaColuna(linha, coluna):
    pontosVisitados[linha][coluna] = True
    if (coluna < 4) and (not pontosVisitados[linha][coluna+1]) and (matriz[linha][coluna+1] == "0"):
        buscaLinhaColuna(linha, coluna+1);
    if (coluna > 0) and (not pontosVisitados[linha][coluna-1]) and (matriz[linha][coluna-1] == "0"):
        buscaLinhaColuna(linha, coluna-1);
    if (linha < 4) and (not pontosVisitados[linha+1][coluna]) and (matriz[linha+1][coluna] == "0"):
        buscaLinhaColuna(linha+1, coluna);
    if (linha > 0) and not pontosVisitados[linha-1][coluna] and (matriz[linha-1][coluna] == "0"):
        buscaLinhaColuna(linha-1, coluna);


T = int(input())

for i in range(T):
    aux = 0
    pontosVisitados = [];
    matriz = [];
    while (aux < 5):
        linha = str(input()).split()
        if len(linha) > 0:
            aux = aux + 1
            matriz.append(linha)
            pontosVisitados.append([False] * 5)

    buscaLinhaColuna(0, 0)

    if (pontosVisitados[4][4]):
        print ("COPS")
        print (pontosVisitados[4][4])
    else:
        print ("ROBBERS")