; Simple example // Comentário
; Writes Hello World to the output // Comentário

	JMP start // 
hello: DB "Hello World!" ; Variable // Alocando a palavra na variável
       DB 0	; String terminator // Aidiconando um byte 0 na variável

start: // Definindo o macro
	MOV C, hello    ; Point to var //Movendo a variavel hello para o registrador C 
	MOV D, 232	; Point to output //Movendo um valor para o registrador D
	CALL print // Chamando o macro print
        HLT; // Encerra a execução

print: ; print(C:*from, D:*to) // Definindo o macro
	PUSH A // Adicionando o registrador A
	PUSH B // Adicionando o registrador B
	MOV B, 0 // Adicionando o valor 0 no registrador B

.loop: // Começando um laço de repetição
	MOV A, [C]	; Get char from var //Move um caractere da vaiável para o registrador A
	MOV [D], A	; Write to output // Escrevendo na saída
	INC C // Incrementando o registrador C
	INC D  // Incrementando o registrador D
	CMP B, [C]	; Check if end // Comparando o valor do registrador B com o próximo valor de C
	JNZ .loop	; jump if not // Caso seja diferente, volta ao loop

	POP B 
	POP A
	RET