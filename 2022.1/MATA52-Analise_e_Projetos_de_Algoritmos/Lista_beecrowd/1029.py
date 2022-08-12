chamadas = [1,1]
fibomemo = [0,1]

for i in range(2, 41):
  chamadas.append(chamadas[i-1] + chamadas[i-2] + 1)
  fibomemo.append(fibomemo[i-1] + fibomemo[i-2])
  
N = int(input());
for i in range(N):
    X = int(input());
    print('fib({}) = {} calls = {}'.format(X, chamadas[X]-1, fibomemo[X]))
        
    