#pragma once

#include <iostream>
#include <bits/stdc++.h>
#include "winGL.h"

const int k = 2; //depth 
const float raio = 0.5; 

class cPonto {
	
	private:

		float 	x;
		float 	y;
		eCor 	cor;
		float	raio;
		int 	id;

		cPonto* left;
		cPonto* right;

	public:

		cPonto();
		cPonto(float x=0.0f, float y=0.0f, eCor cor = BLACK, float raio=1.0f, int id=0);
		cPonto(const cPonto& n); // Criar a partir de endereço??

		float 	getX() 		{ return x; };
		float 	getY() 		{ return y; };
		float 	getRaio() 	{ return raio; };
		eCor 	getCor() 	{ return cor; };
		int 	getId()		{ return id; };
		
		void 	setCor(eCor c) {cor = c;};

		friend std::ostream &operator<<( std::ostream &output, const cPonto &p);


		void 		setLeftChild(cPonto* node);
		cPonto* 	getLeftChild();
		cPonto**	getRefLeftChild();

		void 		setRightChild(cPonto* node);
		cPonto* 	getRightChild();
		cPonto**	getRefRightChild();
};