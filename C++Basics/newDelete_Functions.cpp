#include <iostream>
using namespace std;

void swapTwoElements(int *firstElement, int *secondElement){
  int temporaryElement = *firstElement;
  *firstElement = *secondElement;
  *secondElement = temporaryElement;
}

int main(){
  int *ptr_x = new int;
  int *ptr_y = new int;

  *ptr_x = 5;
  *ptr_y = 10;
  cout << "Element first: " << *ptr_x << endl;//5
  cout << "Element second: " << *ptr_y << endl;//10

  swapTwoElements(ptr_x, ptr_y);

  cout << "After swaping: " << endl;
  cout << "Element first: " << *ptr_x << endl;//10
  cout << "Element second: " << *ptr_y << endl;//5

  delete ptr_x; delete ptr_y;

  return 0;
}
