#include <iostream>
#include <string>
using namespace std;

class animal{

  private:

    int age_;
    int weight_;
    string name_;

  public:

    animal(int age, int weight, string name){
      age_ = age;
      weight_ = weight;
      name_ = name;
    }

    int getAge(){
      return age_;
    }

    int getWeight(){
      return weight_;
    }

    string getName(){
      return name_;
    }

  protected:
};

//alternativly
class car{
  
  private:

    int wheels_;
    string color_;
    string brand_;
  
  public:
  
    car(int w, string c, string b);

  protected:

};

car::car(int w, string c, string b){
  wheels_ = w;
  color_ = c;
  brand_ = b;
};

int main(){
  
  animal dog(8, 35, "Daisy");

  cout << dog.getAge() << endl; //8
  cout << dog.getWeight() << endl; //35
  cout << dog.getName() << endl; //Daisy

  car myCar(4, "red", "BMW");

  return 0;
}
