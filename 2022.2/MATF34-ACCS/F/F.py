a = int(input()) # N

pontosJogador1 = 0
pontosJogador2 = 0

baralhoDeCartas = [int(x) for x in input().split()] # BARALHO DE CARTAS [2 3 5 9 8]

rodadas = int(input()) # QNTD DE RODADAS

for x in range(rodadas):
  jogada1, jogada2 = input().split() # 1
  intJogada1 = int(jogada1)
  intJogada2 = int(jogada2)
  pontosJogador1 += baralhoDeCartas[intJogada1-1]
  pontosJogador2 += baralhoDeCartas[intJogada2-1]
  
if pontosJogador1 > pontosJogador2:
  print("Venci")
else:
  print("Perdi")

