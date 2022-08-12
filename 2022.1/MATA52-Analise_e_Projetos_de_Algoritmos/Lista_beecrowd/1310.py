while True:
  try:
    n = int(input());
    custoDia = int(input());
    
    soma = 0;
    receitaFinal = 0;
    
    for i in range(n):
      receita = int(input())
      lucroDia = receita - custoDia;
      soma = max(lucroDia, soma+lucroDia);
      receitaFinal = max(soma, receitaFinal);
    print(receitaFinal)
    
  except EOFError:
      break;