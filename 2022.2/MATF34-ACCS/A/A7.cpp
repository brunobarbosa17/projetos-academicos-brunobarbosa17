#include <iostream>
using namespace std;

int main (){
  int q1,q2,q3,e1,e2,e3;
  cin >> q1 >> q2 >> q3;
  cin >> e1 >> e2 >> e3;

  cout << (q1 + q2 + q3) - ((e1 + e2 + e3) * 3); 
}