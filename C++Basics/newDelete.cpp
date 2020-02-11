#include <iostream>
#include <string>

using namespace std;

int main(){
  int *ptr_number = new int;
  *ptr_number = 15;

  char *ptr_sign = new char;
  *ptr_sign = '!';

  string *ptr_text = new string;
  *ptr_text = "pancakes";

  cout << *ptr_number << endl; //15
  cout << *ptr_sign << endl; //A
  cout << *ptr_text << endl; //pancakes

  cout << "Addresses in memory: " << endl;
  cout << ptr_number << endl;
  cout << &ptr_sign << endl;
  cout << ptr_text << endl;

  delete ptr_number;
  delete ptr_sign;
  delete ptr_text;

  return 0;
}
