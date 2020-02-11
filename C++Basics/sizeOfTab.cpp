#include <iostream>
using namespace std;

int main(){
  char letters[] = {'a', 'r', 'G', 'o'};
  int digits[] = {1, 2, 0, 5, 9, 8, 3};
  
  int sizeOfLetters = sizeof(letters)/sizeof(char); //number of elements
  int sizeOfDigits = sizeof(digits); //number of bytes

  cout << sizeOfLetters << endl; //4
  cout << sizeOfDigits << endl; //28

  return 0;
}
