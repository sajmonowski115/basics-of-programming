#include <iostream>
#include <ctime>
#include <cstdlib>

using namespace std;

int drawFrom(int minimum, int maximum){
  return rand()%(maximum-minimum+1)+minimum;
}

int main(){
  srand(time(0)); 
}
