#include <iostream>
using namespace std;

int main(){
  int x=2;
  int y=6;
  int *ptr_x = &x;
  int *ptr_y = &y;
  
  int z = x*y;
  cout << z << endl; //10

  z = *ptr_y / *ptr_x;
  cout << z << endl; //3

  cout << x << endl; //2;
  cout << *ptr_x << endl; //2;
  cout << ptr_x << endl; //address of variable x
  cout << &x << endl; //address of variable x
  cout << &ptr_x << endl; //address of pointer to x
  
  return 0;
}
