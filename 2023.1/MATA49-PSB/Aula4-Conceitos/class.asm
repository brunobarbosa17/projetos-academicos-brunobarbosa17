
# 1. Faça um programa que subtraia os valores imediatos 6 e 2 utilizando apenas um registrador.
MOV A, 6
SUB A, 2
ADD A, 2

# 2. Faça um programa que subtraia os valores imediatos 6 e 2 utilizando dois registradores e mantenha o resultado no primeiro registrdor.
MOV A, 6
MOV B, 2

SUB A,B

# 3. Faça um programa que subtraia os valores imediatos 6 e 2 utilizando dois registradores e coloque o resultado no segundo registrador.
MOV R1, 6
MOV R2, 2
SUB R2, R1


# 4. Faça um programa que insira os valores 6 e 2 na memória, subtraia e coloque o resultado em uma variável N
MOV R0, #6
SUB R0, #2
MOV N, R0

N: DW 0