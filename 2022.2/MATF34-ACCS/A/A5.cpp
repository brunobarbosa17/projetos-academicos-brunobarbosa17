#include <iostream>
using namespace std;

int main (){
  int t,d,v,p;
  cin >> t >> d >> v >> p;
  int qntdPedagios = t /d;
  int valorPedagio = qntdPedagios * p;
  int valorKM = v * t;
  cout << valorPedagio + valorKM;  
}