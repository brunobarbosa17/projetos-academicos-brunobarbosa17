import math


x1, y1 = input().split(" ")
x2, y2 = input().split(" ")

distancia = math.sqrt(math.pow(float(x2) - float(x1), 2) + math.pow(float(y2) - float(y1), 2));
print(round(distancia, 4))
