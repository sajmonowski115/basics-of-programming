#include <iostream>
using namespace std;

class Father{
  private:

      int _kids;
      int _bears;
      string _wife;

  public:
      Father(int k, int b){
        _kids = k;
        _bears = b;
      }

      friend class Uncle;
      friend int happiness(Father F);

  protected:

};

class Uncle{
  private:
      int _nephews;
      int _nieces;

  public:
      Uncle(Father F){
        _nephews = F._kids/2;
        _nieces = F._kids/2;
      }

      int getNi(){
        return _nieces;
      }

      int getNe(){
        return _nephews;
      }

};

int happiness(Father F){
  int levelOfHappiness = F._kids * F._bears;
  return levelOfHappiness;
}

int main(){
  Father Papa(4, 16);
  cout << "Level of happiness of our daddy: " << happiness(Papa) << endl; //64

  Uncle John(Papa);
  cout << "Our uncle John has " << John.getNi() << " nieces and " << John.getNe() << " nephews." << endl; //2 and 2
}
