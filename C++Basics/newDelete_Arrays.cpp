#include <iostream>
#include <string>
#include <ctime>
#include <cstdlib>

using namespace std;

int drawFrom(int minimum, int maximum){
  return rand()%(maximum-minimum+1)+minimum;
}

int main(){
  srand(time(0));
  int size(0);
  cout << "Size of the tab: "; cin >> size;
  int *ptr_array = new int[size];
  cout << "Elements in the tab: " << endl;

  //values between 150 and 200
  for(int i=0; i<size; i++){
    *(ptr_array+i) = drawFrom(150, 200);
    cout << *(ptr_array+i); if(i==size-1) break; cout << ", ";
  }
  
  delete [] ptr_array;  

  cout << endl;

  int signs;
  cout << "How many signs: "; cin >> signs;
  char *ptr_array2 = new char[signs];
  cout << "Picked signs: " << endl;

  //signs converted from ASCII [in decimal between 33, 43]
  for(int i=0; i<signs; i++){
    *(ptr_array2+i) = drawFrom(33, 43);
    cout << *(ptr_array2+i); if(i==signs-1) break; cout << ", ";
  }

  delete [] ptr_array2;

  cout << endl;

  return 0;
}
