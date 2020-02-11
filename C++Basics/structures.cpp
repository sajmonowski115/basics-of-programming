#include <iostream>
#include <string>
#include <cstdlib>
using namespace std;

struct person{
  string surname;
  int age;
  char favouriteLetter;
};

int main(){
  person John = {
  "Smith",
  45,
  'd',  
  };

  person Phoebe;
  Phoebe.surname = "Taylor";
  Phoebe.age = 20;
  Phoebe.favouriteLetter = 'a';

  cout << John.age << endl; //45
  cout << Phoebe.favouriteLetter << endl; //a
  
  return 0;
}
