matriz = []

N, M = [int(x) for x in input().split()] #linha e coluna

for i in range(N):
    linha = [int(x) for x in input().split()]
    matriz.append(linha)
# [1, 2, 3]
# linha = cima pra baixo
# coluna = esquerda para direita
for i in range(N):
    for j in range(M):
        if matriz[i][j] == 0:
            if matriz[i-i][j] == 1:
                if matriz[i][j+1] == 1:
                    if matriz[i+1][j] == 1:
                        if matriz[i][j-1] == 1:
                            print(i, j)
                            break
print("0 0")


