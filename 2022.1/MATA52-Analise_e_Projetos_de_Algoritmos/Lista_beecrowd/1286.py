while True:
  n = int(input());
  if (n == 0): break;
  p = int(input());
  
  pedido = []
  tempoPedido = []
  for i in range(n):
    pedidoVar, tempoPedidoVar = map(int, input().split());
    pedido.append(pedidoVar)
    tempoPedido.append(tempoPedidoVar)
  M = [[0 for x in range(31)] for x in range(21)]
  for i in range(n+1):
    for u in range(p+1):
      if (u == 0 or i == 0):
        M[i][u] = 0;
      else:
        if (tempoPedido[i-1] > u):
          M[i][u] = M[i-1][u];
        else:
          M[i][u] = max(M[i-1][u-tempoPedido[i-1]] + pedido[i-1], M[i-1][u]);
  print('%d min.' % M[n][p]);
          
          
          
          
          