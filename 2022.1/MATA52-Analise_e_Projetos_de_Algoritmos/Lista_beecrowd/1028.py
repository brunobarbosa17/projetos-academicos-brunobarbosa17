def trocaFigurinhas(f1, f2):   
    if(f1 % f2 == 0):
      return f2;
    else:
      return trocaFigurinhas(f2, f1 % f2);



N = int(input());
for i in range(N):
    f1, f2 = input().split();
    print(trocaFigurinhas(int(f1), int(f2))); 