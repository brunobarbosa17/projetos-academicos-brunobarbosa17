.c.o:   $*.h
	gcc -c $*.c

.cpp.o:	$*.h
	g++	-c $*.cpp

all:	problema2

problema2:  problema2.o cPonto.o winGL.o ckdTree.o
	g++ -o $@ $^ -lGL -lGLU -lglut

clean:
	rm *.o problema2