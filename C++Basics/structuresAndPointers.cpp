#include <iostream>
#include <string>
#include <cstdlib>
using namespace std;

struct animal{
  int weight;
  int price;
  string color;
};

int main(){
  animal cow = {
  450,
  1500,
  "white",
  };
  
  animal *ptr_cow = &cow;

  (*ptr_cow).price = 2000;

  cout << (*ptr_cow).color << endl; //white
  cout << (*ptr_cow).price << endl; //2000

  int numberOfPigs = 10;
  animal pig[numberOfPigs];
  animal *ptr_pig = pig;

  (*(ptr_pig+2)).weight = 300;
  (*(ptr_pig+2)).price = 650;
  for(int i=0; i<numberOfPigs; i++){
    (*(ptr_pig+i)).color = "pink";
  }

  cout << "Our third pig weights: " << (*(ptr_pig+2)).weight << endl; //300
  cout << "She costs: " << (*(ptr_pig+2)).price << endl; //650
  cout << "She is: " << (*(ptr_pig+2)).color << endl; //pink

  return 0;
}
