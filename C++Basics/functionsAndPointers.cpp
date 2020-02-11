#include <iostream>
using namespace std;


void swapTwoElements(int *firstElement, int *secondElement){
  int temporaryElement = *firstElement;
  *firstElement = *secondElement;
  *secondElement = temporaryElement;
}


int main(){
  int a = 5;
  int b = 11;
  cout << "First value is: " << a << endl; //5
  cout << "Second value is: " << b << endl; //11
  swapTwoElements(&a, &b);//alternative: (ptr_a, ptr_b)
  cout << "After swaping" << endl;
  cout << "First value is: " << a << endl; //11
  cout << "Second value is: " << b << endl; //5
  return 0;
}
