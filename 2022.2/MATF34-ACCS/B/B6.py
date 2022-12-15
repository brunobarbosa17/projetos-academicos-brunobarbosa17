N = int(input())

fases = [int(x) for x in input().split()]

M = int(input())
vidaAtual = M
morreu = False

for x in fases:
  if (vidaAtual <= 0): morreu = True
  if (x == 0):
    continue   
  elif (x == 1):
    vidaAtual = M
  else:
    vidaAtual -= x

if (morreu):
  print("You Died")
else :
  print("Yes, you can")

# 0 -> Caminho Livre
# 1 -> Tem Altar
# 2 -> X