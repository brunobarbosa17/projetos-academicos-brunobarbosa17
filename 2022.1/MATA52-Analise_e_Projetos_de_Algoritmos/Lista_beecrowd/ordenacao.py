array = [1,8,2,6,7,9,0,4,5,3];
# inserir a sua resposta aqui...
def decInsertionSort(array):
    # Primeiro partimos de um laço exterior que 
    # parte do segundo número no array, visto que
    # se houver somente 1, o array está ordenado.
    for step in range(1, len(array)):
        # Utilizamos esse número como chave/key
        key = array[step];
        # Temos um número j que sempre terá índices 
        # anteriores ao do valor key 
        j = step - 1;
        # Garantimos nunca sair dos limites de índice do array
        # e que só percorremos números anteriores à chave atual.
        while j >= 0 and key > array[j]:
            # Ao encontrar um valor maior que a chave, o 
            # movemos para a posição seguinte 
            # e assim sucessivamente com números anteriores
            array[j + 1] = array[j];
            j = j - 1;
        # Por último enviamos o número chave para a posição de 
        # menor número na lista.
        array[j + 1] = key;
    return array;

print(decInsertionSort(array));


# LINK AQUI IMEDIATAMENTE 

#Links

# https://www.coursehero.com/file/31580268/exercicios-analise-algoritmos-resolvidospdf/

# https://mtreviso.wordpress.com/2015/01/27/1-2-algoritmos-como-tecnologia/

# 1.2.2) Suponha que estamos comparando implementações de ordenação por inserção e ordenação por intercalação na mesma máquina. Para entradas de tamanho n, a ordenação por inserção é executada em 8n² passos, enquanto a ordenação por intercalação é executada em 64nlgn passos. Para quais valores de n a ordenação por inserção supera a ordenação por intercalação?

# 8n^2 \leq 64nlgn 

# n^2 \leq 8nlgn 

# n \leq 8lgn 

# \frac{n}{lgn} \leq 8 

# n \leq 43  [*]