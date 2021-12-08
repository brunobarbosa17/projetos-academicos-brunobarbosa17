.cpp.o:	$*.h
	g++	-Wall -c $*.cpp

all:	nucleo

nucleo: nucleo.o filaEspera.o noPaciente.o gerador.o pilhaHospital.o
	g++ -o $@ $^

clean:
	rm *.o nucleo
	