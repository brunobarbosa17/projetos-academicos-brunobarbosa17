# N = Numero de palavras
# L = Numero máximo de linhas por página
# C = Número máximo de caracteres por linha

while True:
    try:
        N, L, C = input().split();
        frase = input();
        fraseSeparada = frase.split(' ');
        qntdLinhas = 0;
        qntdCaracteres = 0;
        aux = 0;
        for palavra in fraseSeparada:
            qntdPalavra = len(palavra);
            if qntdPalavra + qntdCaracteres > int(C):
                qntdLinhas += 1;
                qntdCaracteres = qntdPalavra;
            else:
                qntdCaracteres += qntdPalavra
            if aux != len(fraseSeparada) - 1:
                if qntdCaracteres + 1 < int(C):
                    qntdCaracteres += 1;
                else:
                    qntdLinhas += 1;
                    qntdCaracteres = 0;
            aux = aux + 1;
        print (int((qntdLinhas/int(L) + 1)));
    except EOFError:
        break;