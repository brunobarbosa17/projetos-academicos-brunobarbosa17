#include <iostream>
#include <string>

using namespace std;

int main () {
  int n1,n2,n3,n4,n5,n6;

  cin >> n1 >> n2 >> n3 >> n4 >> n5 >> n6;

  int total = n1 + n2 + n3 + n4 + n5 + n6;

  if (total >= 250) {
    cout << "S+";
  } else if (total >= 200) {
    cout << "S";
  } else if (total >= 180) {
    cout << "S-";
  }  else if (total >= 150) {
    cout << "A+";
  } else if (total >= 100) {
    cout << "A";
  } else if (total >= 80) {
    cout << "A-";
  } else if (total >= 60) {
    cout << "B+";
  } else if (total >= 40) {
    cout << "B";
  } else if (total < 40) {
    cout << "B-";
  }

}