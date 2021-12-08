#include <iostream>
#include <cstdlib>
#include <ctime>

#include<bits/stdc++.h>
#include <iostream>
#include <fstream>


#include <vector>

#include <GL/glut.h>

#include "winGL.h"
#include "cPonto.h"
#include "ckdTree.h"

		
int		wLargura 	= 800,
		wAltura 	= 800;

float	xMin =  -10,
		yMin =  -10,
		xMax =  10,
		yMax =  10;

bool 	quadrado 	= false,
		linhas 		= false,
		pontos 		= true,
		cobertura 	= false;

eCor 	defCor = GRAY;


std::vector<cPonto> nuvemDePontos;
ckdTree tree;

/// ***********************************************************************
/// ** 
/// ***********************************************************************

void initNuvemDePontos(int num) {

	for (int i = 0 ; i < num ; i++) {

		cPonto pto 	(	((rand() % static_cast<int>(xMax-xMin)) - (xMin>0? xMin : -xMin)), //rand() % 20) - 10.0f,
						((rand() % static_cast<int>(yMax-yMin)) - (yMin>0? yMin : -yMin)), 
						(defCor), //(rand() % 8),
						raio, //(rand() % 6) + 1.0f
						i 
					);

		nuvemDePontos.push_back(pto);
	}
}
	
/// *********************************************************************** 
/// ** 
/// ***********************************************************************

void desenho(void) {
	
    glClear(GL_COLOR_BUFFER_BIT | GL_DEPTH_BUFFER_BIT);

    if (pontos)
	    tree.desenhaTree();
		//for (int i = 0 ; i < nuvemDePontos.size() ; i++)
	    //	desenhaPonto(nuvemDePontos[i]);

    if (cobertura)
	    for (int i = 0 ; i < nuvemDePontos.size() ; i++)
	    	desenhaCircunferencia(nuvemDePontos[i]);


    if (quadrado)
	    desenhaQuadrado(	nuvemDePontos[rand() % nuvemDePontos.size()], 
	    					nuvemDePontos[rand() % nuvemDePontos.size()]);

    if (linhas)
	    for (int i = 0 ; i < nuvemDePontos.size()-1 ; i++)
		    desenhaLinha(nuvemDePontos[i], nuvemDePontos[i+1]);

    glutSwapBuffers();
	}


/// ***********************************************************************
/// ** 
/// ***********************************************************************
	
void tecladoEspecial(int key, int x, int y) {
	switch (key) {
		case GLUT_KEY_UP	:	std::cout << "Pressionada tecla UP" << std::endl; 	
								break;

		case GLUT_KEY_DOWN	: 	std::cout << "Pressionada tecla DOWN" << std::endl; 	
								break;	

		case GLUT_KEY_LEFT	: 	std::cout << "Pressionada tecla LEFT" << std::endl; 	
								break;

		case GLUT_KEY_RIGHT	: 	std::cout << "Pressionada tecla RIGHT" << std::endl; 	
								break;						
		}
	glutPostRedisplay();
}
				
/// ***********************************************************************
/// **
/// ***********************************************************************

void delay(int value) {

	std::cout << "Delay = " << value << std::endl;
	glutPostRedisplay();
}

/// ***********************************************************************
/// ** 
/// ***********************************************************************

void idle() {

	std::cout << "idle()" << std::endl;

	glutPostRedisplay();
}							

/// ***********************************************************************
/// ** 
/// ***********************************************************************

void teclado(unsigned char key, int x, int y) {
	switch (key) {
		case 27		: 	std::cout << "ESC pressionada - Fim do programa" << std::endl;
						exit(0);
						break;
		case 't'	:
		case 'T'	:	std::cout << "Ligando Timer" << std::endl;
						glutTimerFunc(500, delay, 0);
						break;
						
		case 'q'	:
		case 'Q'	:	quadrado = !quadrado;
						break;
						
		case 'r'	:
		case 'R'	:	cobertura = !cobertura;
						break;
						
		case 'l'	:
		case 'L'	:	linhas = !linhas;
						break;
						
		case 'p'	:
		case 'P'	:	pontos = !pontos;
						break;
						
		case 'i'	:
		case 'I'	:	std::cout << "Ligando idle" << std::endl;
						glutIdleFunc(idle);
						break;
						
		case 'f'	:
		case 'F'	:	std::cout << "Deligando idle" << std::endl;
						glutIdleFunc(NULL);
						break;	

		case 'o'	:
		case 'O'	:	std::cout << "Pre order" << std::endl;
						tree.preOrder();
						break;

		}
	glutPostRedisplay();
}
		

/// ***********************************************************************
/// **
/// ***********************************************************************
cPonto* t = NULL;
void mouse(int button, int button_state, int x, int y ) {
	

	if 	(button_state == GLUT_DOWN ) {
		switch (button) {
			
			case GLUT_LEFT_BUTTON	: 	std::cout << "Mouse -> Botao Esquerdo" << std::endl;
										break;
	
			case GLUT_RIGHT_BUTTON	:	std::cout << "Mouse -> Botao Direito" << std::endl;
										break;
			}


		//Ajustes nas proporções das coordenadas:
		float Mx = (((x-wLargura)*(xMin-xMax))/-wLargura) + xMax;
		float My = (((y-wAltura)*(yMax-yMin))/-wAltura) + yMin;

		std::cout << "click *( " << Mx << ", " << My << " )" << std::endl;

		// Busca do ponto mais próximo

		cPonto* tut = new cPonto(Mx, My, (eCor)(1), raio);

		if (t)
			t->setCor(defCor); // redefine resultado da ultima pesquisa
			
		t = tree.nearestRec(tut);

		if (t == NULL) {
			std::cout << "NULL" << std::endl;
		}
		else {
			std::cout << "Antena mais próxima { " << t->getX() << ", " << t->getY() << "}" << std::endl;
			
			double dist = sqrt(pow(t->getX() - tut->getX(), 2) + pow(t->getY() - tut->getY(), 2) );
			std::cout << "Distancia: " << dist << std::endl;
			

			bool alcance = false ;
			if (dist <= raio)
				alcance = true;

	
			desenhaPonto(*tut);
			t->setCor(alcance? GREEN : RED);
			desenhaCircunferencia(*t);			

			// Atualizar janela
			glutIdleFunc(idle);
			glutTimerFunc(100, delay, 0);
			glutIdleFunc(NULL);

			//Atualizar desenhos (cobertura) ?
			glutSwapBuffers();

		}
		
		std::cout << std::endl;


	}
}


/// ***********************************************************************
/// **
/// ***********************************************************************

bool readFile(std::string fileName){

	// Create a text string, which is used to output the text file
	std::string myText;
	
	// Read from the text file
	std::ifstream MyReadFile(fileName);
	
	if (!MyReadFile){
		std::cout << "NO FILE" << std::endl;
		return false;
	}
	
	std::cout << "FILE" << std::endl;
	
	//A 1 linha contém as dimensões do mapa.
	getline (MyReadFile, myText); 	
	int pos0 = 0;
	int posF = myText.find(" ");
	xMin = std::stof(myText.substr(pos0, posF));

    myText = myText.substr(posF+1);
	posF = myText.find(" ");
    
    yMin = std::stof(myText.substr(pos0, posF));

	myText = myText.substr(posF+1);
	posF = myText.find(" ");

	xMax = std::stof(myText.substr(pos0, posF));
	yMax = std::stof(myText.substr(posF));
	int id = 0;
	while (getline (MyReadFile, myText)) { // Ler cada linha do arquivo
	
		// Get coordinates
		int pos0 = 0;
		int posF = myText.find(" ");
		
		float x = std::stof(myText.substr(pos0, posF));

		pos0 = posF +1;
		posF = myText.find(" ", pos0);
		
		float y = std::stof(myText.substr(pos0, posF-pos0));
		float z = std::stof(myText.substr(posF+1));
		
		cPonto pto 	(	x,
						y,
						defCor,
						raio,
						id
					);

		// Leitura do arquivo
		//std::cout << pto.getX() << ", " << pto.getY() << std::endl;
		
		nuvemDePontos.push_back(pto);					// # Alterar
		id++;
	}

	int n = nuvemDePontos.size();
	tree.insertVec(n, nuvemDePontos);
	 
	tree.mergeSort(0, n-1, 0);
	
	tree.balancearInsercao(tree.pt, 0, 0, n-1);

	// Close the file
	MyReadFile.close(); 
	return true;
}

/// ***********************************************************************
/// ***********************************************************************
/// ** 
/// ***********************************************************************
/// ***********************************************************************

int main(int argc, char** argv) {
	
	srand(time(NULL));

	criaJanela(argc, argv);
	
	
	if (argc>1){
		if (!readFile(argv[1]))
 			initNuvemDePontos(30);
		
	} else{	
 		initNuvemDePontos(30);
	}

	int n = nuvemDePontos.size();
	std::cout << n << std::endl;
	tree.insertVec(n, nuvemDePontos);
	 
	tree.mergeSort(0, n-1, 0);

	
	tree.balancearInsercao(tree.pt, 0, 0, n-1);

    initOpenGL();
    
    initEventos();
        
    return 0; 
}
