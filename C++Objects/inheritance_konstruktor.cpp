#include <iostream>
using namespace std;


class Hero{

  private:

  public:

    Hero(int hp, int power){
      HP_ = hp;
      power_=power;
    }

    int getHP(){
      return HP_;
    }

    int getPower(){
      return power_;
    }


  protected:

  int HP_;
  int power_;

};

class Magus:public Hero{

  private:

    int luck_;
    int ability_;
  
  public:

    Magus(int luck, int hp, int power)
    : Hero(hp, power){
      luck_ = luck;
      ability_ = HP_ * power_;
    }

    int getLuck(){
      return luck_;
    }

    int getAbility(){
      return ability_;
    }
};


int main(){

  Magus lois(20, 11, 37);

  cout << lois.getHP() << endl; // 11
  cout << lois.getPower() << endl; // 37
  cout << lois.getLuck() << endl;  // 20
  cout << lois.getAbility() << endl; // 407

  return 0;
}
