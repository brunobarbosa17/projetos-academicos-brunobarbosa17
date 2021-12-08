#include <iostream>
#include<bits/stdc++.h>

#include "winGL.h"
#include "cPonto.h"


// ******************************************************
// ***
// ******************************************************

cPonto::cPonto(){

	x		=	0.0f; 
	y		=	0.0f;
	cor 	= 	BLACK; 
	raio	=	1.0f;
	id 		= 	0;
}

// ******************************************************
// ***
// ******************************************************

cPonto::cPonto(float xP, float yP, eCor corP, float raioP, int idP) {

	x		=	xP; 
	y		=	yP;
	cor 	= 	corP; 
	raio	=	raioP;
	id		= 	idP;

	left	= 
	right 	= NULL;

}

// ******************************************************
// ***
// ******************************************************

std::ostream &operator<<( std::ostream &output, const cPonto &p ) { 

	output << "[ ( " << p.x <<  " , " << p.y << " ) , " << p.cor << " , " << p.raio  << "]" << std::endl;

	return output;            
}



// ******************************************************
// ***
// ******************************************************


cPonto::cPonto(const cPonto& n) {

	x		=	n.x;
	y		=	n.y;
	cor 	=	n.cor;
	raio	=	n.raio;
	id		= 	n.id;

	left 	= 	n.left;
	right 	= 	n.right;

}

// ***********************************************
// ******                                   ******
// ***********************************************

void cPonto::setLeftChild(cPonto* n) {

	left = n;
}

// ***********************************************
// ******                                   ******
// ***********************************************

cPonto* cPonto::getLeftChild() {

	return left;
}

// ***********************************************
// ******                                   ******
// ***********************************************

cPonto** cPonto::getRefLeftChild() {

	return &left;
}

// ***********************************************
// ******                                   ******
// ***********************************************

void cPonto::setRightChild(cPonto* n) {

	right = n;
}

// ***********************************************
// ******                                   ******
// ***********************************************

cPonto* cPonto::getRightChild() {

	return right;
}

cPonto** cPonto::getRefRightChild() {

	return &right;
}