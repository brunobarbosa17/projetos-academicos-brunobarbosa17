N, M = [int(x) for x in input().split()] 
# N = dimensao da matriz
# M = numero de teleportes
matriz = []

for i in range(N):
    linha = [int(x) for x in input().split()]
    matriz.append(linha)

quantidadeNavesDestruidas = 0

for i in range(M):
    l, c = [int(x) for x in input().split()]
    while l >= 0:
        l -= 1 # l = l - 1
        if matriz[l][c] == 1:
            quantidadeNavesDestruidas += 1 # quantidadeNavesDestruidas = quantidadeNavesDestruidas +1
            matriz[l][c] = 0
            break

print(quantidadeNavesDestruidas)
