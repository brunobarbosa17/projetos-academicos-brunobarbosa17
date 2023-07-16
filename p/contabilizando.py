pokemonsRegistrados = [int(x) for x in input().split()]
pokemonsNovos = [int(x) for x in input().split()]

resultado = [0, 0, 0]
resultado[0] = pokemonsRegistrados[0] + pokemonsNovos[0]
resultado[1] = pokemonsRegistrados[1] + pokemonsNovos[1]
resultado[2] = pokemonsRegistrados[2] + pokemonsNovos[2]

print(resultado[0], resultado[1], resultado[2])