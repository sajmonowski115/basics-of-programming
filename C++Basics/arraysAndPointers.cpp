#include <iostream>
using namespace std;

int main(){
  int tabSize = 20;
  int tab[tabSize];
  int *ptr_tab = tab;
  for(int i=0; i<tabSize; i++){
    *(ptr_tab+i)=i+15;
    cout << *(ptr_tab+i) << ", "; //15, 16, 17, ... , 34 
  }
  return 0;
}
