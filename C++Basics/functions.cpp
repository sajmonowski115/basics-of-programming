#include <iostream>
using namespace std;

int addTwenty(int value){
  return value+20;
}

bool moreThanTen(int firstElement, int secondElement){
  if((firstElement+secondElement)>10) return true;
  else return false;
}

int main(){
  int x = 15;
  cout << addTwenty(x) << endl; //35

  int a(0), b(0);
  cout << "First number: "; cin >> a;
  cout << "Second number: "; cin >> b;
  if(moreThanTen(a, b)) cout << a << "+" << b << " is more than ten" << endl;
  else cout << a << "+" << b << " is less or equal ten" << endl;
  
  return 0;
}
