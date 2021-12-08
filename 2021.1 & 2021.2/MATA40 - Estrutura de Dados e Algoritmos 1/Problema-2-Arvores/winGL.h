#pragma once


typedef enum 	{	BLACK,
					RED,
					GREEN,
					BLUE,
					MAGENTA,
					CYAN,
					YELLOW,
					GRAY
				} eCor;

#include "cPonto.h"
class cPonto;

void desenhaQuadrado(cPonto pMin, cPonto pMax);
void desenhaPonto(cPonto P0);
void desenhaCirculo(cPonto P0);
void desenhaCircunferencia(cPonto P0);
void desenhaLinha(cPonto P0, cPonto P1);

void display(void);

void initOpenGL(void);

void reshape(int w, int h);

void keyboard(unsigned char key, int x, int y);
void specialKeyboard(int key, int x, int y);

void timer(int delay);

void criaJanela(int argc, char** argv);

void initEventos(void);

