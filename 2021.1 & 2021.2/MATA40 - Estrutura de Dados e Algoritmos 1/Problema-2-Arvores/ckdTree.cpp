#include<bits/stdc++.h>
#include "ckdTree.h"

// ***********************************************
// ******                                   ******
// ***********************************************

ckdTree::ckdTree() {

    root = NULL;
}

// ***********************************************
// ******                                   ******
// ***********************************************

bool ckdTree::insertRec(cPonto** r, float x, float y, eCor cor, float raio, int id, unsigned depth)
{   

    cPonto *novoNo;
    if ((*r) == NULL) {
        novoNo = new cPonto(x, y, cor, raio, id++);

        if (novoNo == NULL) {
            return false;
        }

        (*r) = novoNo;
        return true;
    }
	
	unsigned cd = depth % k;


	switch (cd) {
        
        case 0:
            if ((*r)->getX() <= x) {
                return insertRec((*r)->getRefRightChild(), x, y, cor, raio, id, depth + 1);
            }
            else {
                return insertRec((*r)->getRefLeftChild(), x, y, cor, raio, id,  depth + 1);
            }
        
        case 1:
            if ((*r)->getY() <= y) {
                return insertRec((*r)->getRefRightChild(), x, y, cor, raio, id, depth + 1);
            }
            else {
                return insertRec((*r)->getRefLeftChild(), x, y, cor, raio, id, depth + 1);
            }
    }

    return false;

}

// ***********************************************
// ******                                   ******
// ***********************************************


bool ckdTree::insertPonto(cPonto ponto){
    return insertRec(&root, ponto.getX(), ponto.getY(), ponto.getCor(), ponto.getRaio(), ponto.getId(), 0 );  
 
}

void ckdTree::insertVec(int tam, std::vector<cPonto> base) {
    
    for (int i = 0; i < tam; i++) {
        pt.push_back(base[i]);
    }
    
}


// ***********************************************
// ******                                   ******
// ***********************************************

bool arePointsSame(float x, float y, float x1, float y1)
{
	if (x != x1 || y != y1)
		return false;

	return true;
}

// ***********************************************
// ******                                   ******
// ***********************************************

cPonto* ckdTree::searchRec(cPonto* r, float x, float y, unsigned depth, cPonto* testeRec)
{

	if (r == NULL) {        
        return testeRec;
    }

	if (arePointsSame(r->getX(), r->getY(), x, y)) {
        return testeRec;
    }

	unsigned cd = depth % k;

    testeRec = r;

	switch (cd) {

        case 0:
            if (r->getX() < x) {
                return searchRec(r->getRightChild(), x, y, depth + 1, testeRec);
            }
            else {
                return searchRec(r->getLeftChild(), x, y, depth + 1, testeRec);
            }
        
        default:
            if (r->getY() < y) {
                return searchRec(r->getRightChild(), x, y, depth + 1, testeRec);
            }
            else {
                return searchRec(r->getLeftChild(), x, y, depth + 1, testeRec);
            }
    }
}

cPonto* ckdTree::search(float x, float y) {
	
	return searchRec(root, x, y, 0, NULL);
}

// ***********************************************
// ******                                   ******
// ***********************************************

cPonto* ckdTree::preOrderRec(cPonto* r) {

    if (r != NULL) {
        //desenhaPonto(r);
        std::cout << "{" << r->getX() << ", " << r->getY() << "}" << std::endl;
		preOrderRec(r->getLeftChild());
		preOrderRec(r->getRightChild());
        
	}
    else {
        std::cout << ".\n";
    }

    return r;

}

void ckdTree::preOrder() {
    preOrderRec(root);
}

// ***********************************************
// ******                                   ******
// ***********************************************

void ckdTree::desenhaTree() {
    desenhaTree(root);
}


cPonto* ckdTree::desenhaTree(cPonto* r) {

    if (r != NULL) {
        desenhaPonto(*r);
		desenhaTree(r->getLeftChild());
		desenhaTree(r->getRightChild());
        
	}

    return r;

}


// ***********************************************
// ******                                   ******
// ***********************************************

float ckdTree::distSquared(cPonto* p1, cPonto* p2) {

    float dist = pow(p1->getX() - p2->getX(), 2) + pow(p1->getY() - p2->getY(), 2);
    return sqrt(dist);
}

// ***********************************************
// ******                                   ******
// ***********************************************

float ckdTree::distPerp(cPonto* p1, cPonto* p2, int k) {
    
    if (k == 0) {
        return (p1->getX() - p2->getX());
    }
    
    return (p1->getY() - p2->getY());
}

// ***********************************************
// ******                                   ******
// ***********************************************

cPonto* ckdTree::nearestRec(cPonto* x) {

    if (root == NULL || x == NULL) {
        return NULL;
    }

    cPonto* n = search(x->getX(), x->getY());

    float min = distSquared(n, x);

    cPonto* better = nearest(root, min, x, 0);

    if (better != NULL) {
        return better;
    }

    return n;
}


cPonto* ckdTree::nearest(cPonto* r, float min, cPonto* x, unsigned depth){

    cPonto* result = NULL;

    float d = distSquared(r, x);

    if (d >= 0 && d < min) {
        result = r;
        min = d;
    }

    unsigned cd = depth % k;

    float dp = distPerp(r, x, cd);
    cPonto* point = NULL;

    if (dp < min) {
        

        if (r->getRightChild() != NULL) {
            point = nearest(r->getRightChild(), min, x, depth + 1);
            
            if (point != NULL && distSquared(x, point)<min) {
                min = distSquared(x, point);
                result = point;
            }
        }

        if (r->getLeftChild() != NULL) {
            point = nearest(r->getLeftChild(), min, x, depth + 1);
        
            if (point != NULL && distSquared(x, point)<min) {
                min = distSquared(x, point);
                result = point;
            }
        }
    }
    else {

        switch (cd) {

        case 0:
            if ( x->getX() < r->getX()) {
                if (r->getRightChild() != NULL) {
                    point = nearest(r->getRightChild(),min, x, depth + 1);
                }
            }
            else {
                if (r->getLeftChild() != NULL) {
                    point = nearest(r->getLeftChild(),min, x, depth + 1);
                }
            }
        
        default:
            if (x->getY() < r->getY() ) {
                if (r->getRightChild() != NULL) {
                    point = nearest(r->getRightChild(),min, x, depth + 1);
                }
            }
            else {
                if (r->getLeftChild() != NULL) {
                    point = nearest(r->getLeftChild(),min, x, depth + 1);
                }
            }
        }

        if (point != NULL) {
            return point;
        }

    }

    return result;
}

// ***********************************************
// ******                                   ******
// ***********************************************

void ckdTree::merge(int first, int middle, int last, int cd,  std::vector<cPonto> aux) {
    int n1 = first, n2 = middle;
    
    if (cd == 0) {
        for (int i = first; i < last; ++i) {
                
            if ((n1 < middle) and ((n2 >= last) or (pt[n1].getX() < pt[n2].getX()))) {
                aux[i] = pt[n1];
                ++n1;
            }
            else {
                aux[i] = pt[n2];
                ++n2;
            }
        }
    }
    else {
        for (int i = first; i < last; ++i) {

            if ((n1 < middle) and ((n2 >= last) or (pt[n1].getY() < pt[n2].getY()))) {
                aux[i] = pt[n1];
                ++n1;
            }
            else {
                aux[i] = pt[n2];
                ++n2;
            }
        }
    }

    for (int i = first; i < last; ++i) {
        pt[i] = aux[i];
    }
}

void ckdTree::mergeSort(int first, int last,int cd, std::vector<cPonto> vetAux) {

	if ((last - first) >= 2){

		int middle = ((first + last)/2);
		mergeSort(first, middle, cd, vetAux);
		mergeSort(middle, last, cd, vetAux);
		merge(first, middle, last, cd, vetAux);
	}
}

void ckdTree::mergeSort(int first, int last, int cd) {

    std::vector<cPonto> vetorAux;

    cPonto pto(0 , 0 , (eCor) (0) , 0);

    for (int i = 0; i < last+1; i++)
    {
        vetorAux.push_back(pto);
    }
    
    mergeSort(first, last+1, cd, vetorAux);

}

// *************************************************
// *************************************************
// *************************************************

int ckdTree::findIndPonto(cPonto t) {
	for (int i = 0 ; i < pt.size(); i++){
		if ((pt[i].getX() == t.getX()) && (pt[i].getY() == t.getY()))
			return (i);	  
	}
	return -1;
}


bool ckdTree::balancearInsercao(std::vector<cPonto> vet, unsigned depth, int first, int last){
    
    if (vet.size() == 1){
        insertPonto(vet[0]);
        return true;
    }


    unsigned cd = (depth+1) % k;
   
    int middle;

    if (vet.size()%2 == 0)
    {
        middle = vet.size()/2 - 1;
    }
    else {
        middle = vet.size()/2;
    }
    
    insertPonto(vet[middle]);
 
    mergeSort(first, findIndPonto(vet[middle])-1, cd);
    mergeSort(findIndPonto(vet[middle])+1, last, cd);

    std::vector<cPonto> subVetE;

    for (int i=first; i<findIndPonto(vet[middle]); i++){

        subVetE.push_back(pt[i]);
    }
    std::vector<cPonto> subVetD;

    for (int i=findIndPonto(vet[middle])+1; i<(last+1); i++){

        subVetD.push_back(pt[i]);
    }
    

    if (subVetE.size() > 0)
    {
        balancearInsercao(subVetE, depth, first, findIndPonto(vet[middle])-1);
    }

    if (subVetD.size() > 0)
    {
        balancearInsercao(subVetD, depth, findIndPonto(vet[middle])+1, last);
    }
    
    return true;
}
