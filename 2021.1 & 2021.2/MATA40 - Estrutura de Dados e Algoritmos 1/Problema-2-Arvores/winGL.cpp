#include <iostream>
#include <cstdlib>
#include <cmath>

#include <GL/glut.h>

#include "winGL.h"
#include "problema2.h"
		
extern GLint	wLargura,
				wAltura;

extern float	xMin,
				yMin,
				xMax,
				yMax;
								
float Cores[8][3] = { 	{0.0, 0.0, 0.0},
						{1.0, 0.0, 0.0},
						{0.0, 1.0, 0.0},
						{0.0, 0.0, 1.0},
						{1.0, 0.0, 1.0},
						{0.0, 1.0, 1.0},
						{1.0, 1.0, 0.0},
						{0.5, 0.5, 0.5} };
						
/// ***********************************************************************
/// ** 
/// ***********************************************************************

void desenhaQuadrado(cPonto pMin, cPonto pMax) {
						
	glBegin(GL_QUADS);
	
		glColor3fv(Cores[RED]);
		glVertex2f(pMin.getX(), pMin.getY());
		glVertex2f(pMax.getX(), pMin.getY());
		glVertex2f(pMax.getX(), pMax.getY());
		glVertex2f(pMin.getX(), pMax.getY());
	
	glEnd();		
}							
						
/// ***********************************************************************
/// ** 
/// ***********************************************************************

void desenhaLinha(cPonto P0, cPonto P1) {
	
    glBegin(GL_LINES);
		glColor3fv(Cores[P0.getCor()]);
		glVertex2f(P0.getX(), P0.getY());
		glColor3fv(Cores[P1.getCor()]);
		glVertex2f(P1.getX(), P1.getY());
    glEnd();   
}

/// ***********************************************************************
/// ** 
/// ***********************************************************************

void desenhaPonto(cPonto P) {
	
	glColor3fv(Cores[P.getCor()]);

    glBegin(GL_POINTS);
		glVertex2f(P.getX(), P.getY());
    glEnd();   
}

/// ***********************************************************************
/// ** 
/// ***********************************************************************

void desenhaCirculo(cPonto P0) {
	
#define GRAD2RAD(a)	(a) * M_PI / 180.0

float teta = 360.0 / 30;
	
	glColor3fv(Cores[P0.getCor()]);

    glBegin(GL_TRIANGLE_FAN);

		glVertex2f(P0.getX(), P0.getY());

    	for (int i = 0.0 ; i <= 360.0 ; i += teta) {
    		glVertex2f(	P0.getX() + P0.getRaio() * cos(GRAD2RAD(i)), 
    					P0.getY() + P0.getRaio() * sin(GRAD2RAD(i)));
    		}

    glEnd(); 
}

/// ***********************************************************************
/// ** 
/// ***********************************************************************

void desenhaCircunferencia(cPonto P0) {
	
#define GRAD2RAD(a)	(a) * M_PI / 180.0

float teta = 360.0 / 30;
	
	glPolygonMode(GL_FRONT, GL_LINE);

	glColor3fv(Cores[P0.getCor()]);

    glBegin(GL_LINE_LOOP);

    	for (int i = 0.0 ; i <= 360.0 ; i += teta) 
    		glVertex2f(	P0.getX() + P0.getRaio() * cos(GRAD2RAD(i)), 
    					P0.getY() + P0.getRaio() * sin(GRAD2RAD(i)));
    	
    glEnd(); 
}

/// ***********************************************************************
/// ** 
/// ***********************************************************************

void initOpenGL() {
	glClearColor(0.0, 0.0, 0.0, 0.0);
	glPolygonMode(GL_FRONT_AND_BACK, GL_FILL);
	glEnable(GL_DEPTH_TEST);
	glPointSize(5.0);
}

/// ***********************************************************************
/// ** 
/// ***********************************************************************

void reshape(int w, int h) {

	wLargura 	= w;
	wAltura 	= h;

	glViewport(0, 0, (GLsizei) w, (GLsizei) h); 
	glMatrixMode(GL_PROJECTION);
	glLoadIdentity();
	glOrtho(xMin, xMax, yMin, yMax, -10.0, 10.0);
	glMatrixMode(GL_MODELVIEW);
	glLoadIdentity();
}

/// ***********************************************************************
/// ** 
/// ***********************************************************************

void criaJanela(int argc, char** argv) {
	
    glutInit(&argc, argv);
    glutInitDisplayMode (GLUT_DOUBLE | GLUT_RGB | GLUT_DEPTH);
    //glutInitWindowSize (wAltura, wLargura);
    glutInitWindowSize (wLargura, wAltura);
    glutInitWindowPosition (100, 100);
    glutCreateWindow ("Cobertura 5G");
}


/// ***********************************************************************
/// ** 
/// ***********************************************************************

void initEventos() {
	
    glutDisplayFunc(desenho);
    glutKeyboardFunc(teclado);
    glutSpecialFunc(tecladoEspecial);
	glutReshapeFunc(reshape);
	glutMouseFunc(mouse);
	
	glutMainLoop();

}


