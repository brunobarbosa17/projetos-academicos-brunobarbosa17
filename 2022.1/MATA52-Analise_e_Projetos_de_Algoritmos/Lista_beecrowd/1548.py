N = int(input());

notas1 = []
notas2 = []

for u in range(N):
  M = int(input());
  vezes = 0;
  notas1.clear()
  notas2.clear()
  notas1 = [ int(i) for i in input().split() ]
  # for i in range(M):
  #     nota = input().split();
  #     notas1.append(nota);
  notas2 = sorted(notas1);
  notas2.reverse();
  for j in range(len(notas1)):
    if (notas1[j] == notas2[j]):
      vezes+=1;
  print(vezes);
      
      
  

# n = int(input())
# while n > 0:
#     n -= 1
#     m = int(input())
#     a = input().split()
#     for ind, i in enumerate(a):
#         a[ind] = int(a[ind])
#     b = sorted(a)
#     print(sorted(a))
#     b.reverse()
#     print(b)
#     total = 0
#     for ind, i in enumerate(a):
#         if (a[ind] == b[ind]):
#             total +=1
#     print(total)