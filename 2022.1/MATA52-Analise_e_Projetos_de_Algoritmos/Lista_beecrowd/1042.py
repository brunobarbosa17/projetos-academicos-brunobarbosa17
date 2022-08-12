numeros = []

# n1 = int(input());
# n2 = int(input());
# n3 = int(input());

n1, n2, n3 = input().split();

# n1, n2, n3 = [int(x) for x in input().split()]

numeros.append(int(n1));
numeros.append(int(n2));
numeros.append(int(n3));

numeros.sort();


for num in numeros:
    print(num);
    
print();

print(n1);
print(n2);
print(n3);