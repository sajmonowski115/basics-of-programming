#include <iostream>
#include <string>
#include <cstdlib>
using namespace std;

struct product{
  int price;
  string color;
  char category;
};


int main(){
  product *ptr_book = new product;

  (*ptr_book).price = 25;
  (*ptr_book).color = "green";
  (*ptr_book).category = 'A';
  cout << (*ptr_book).price << endl; //25
  cout << (*ptr_book).color << endl; //green
  cout << (*ptr_book).category << endl; //A

  delete ptr_book;

  product *ptr_computer = new product[5];
  
  *(ptr_computer+2) = {
    3000,
    "white",
    'F',
  };

  cout << (*(ptr_computer+2)).color << endl; //white

  delete [] ptr_computer;

  return 0;
}
