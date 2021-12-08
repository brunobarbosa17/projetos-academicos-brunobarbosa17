#include<bits/stdc++.h>
#include "cPonto.h"
#include "winGL.h"

class cPonto;

class ckdTree {

    private:

        cPonto *root;

        bool insertRec( cPonto** r, 
                        float x, 
                        float y, 
                        eCor cor,
			            float raio,
                        int id, 
                        unsigned depth);
        
        cPonto* searchRec(cPonto* r, float x, float y,  unsigned depth, cPonto* testeRec);
        
        cPonto* preOrderRec(cPonto* r);

        void mergeSort(int first, int last, int cd, std::vector<cPonto> vetAux);
	    void merge(int first, int middle, int last, int cd,  std::vector<cPonto> aux);

        cPonto* desenhaTree(cPonto* r);

    public:
            
        ckdTree();

        std::vector<cPonto> pt;

        bool insertPonto(cPonto ponto);


        void insertVec(int tam, std::vector<cPonto> base);

        cPonto* search(float x, float y);
        
        void preOrder();
        void desenhaTree();


        cPonto* nearestRec(cPonto* x);
        cPonto* nearest(cPonto* r, float min, cPonto* x, unsigned depth);

        float distSquared(cPonto* p1, cPonto* p2);
        float distPerp(cPonto* p1, cPonto* p2, int k);

        void mergeSort(int first, int last, int cd);
        int findIndPonto(cPonto t);

        bool balancearInsercao(std::vector<cPonto> vet, unsigned depth, int first, int last);
};