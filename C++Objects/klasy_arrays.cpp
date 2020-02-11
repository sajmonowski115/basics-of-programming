#include <iostream>
using namespace std;

class Vector{

  private:

    int *coordinates_;

  public:

    Vector(int x, int y){
      coordinates_ = new int[2];
      coordinates_[0] = x;
      coordinates_[1] = y;
    }

    Vector(int x, int y, int z){
      coordinates_ = new int[3];
      coordinates_[0] = x;
      coordinates_[1] = y;
      coordinates_[2] = z;
    }

    void printV(int size){
      for(int i=0; i<size; i++){
        cout << coordinates_[i];
        if(i==(size-1)) break;
        cout << ", ";
      }
      cout << endl;
    }

    ~Vector(){
      delete [] coordinates_;
    }

  protected:

};


int main(){

  Vector V[3] = {Vector(1, -3), Vector(7, 15), Vector(-13, 0, 3)};
 
  V[0].printV(2);
  V[1].printV(2);
  V[2].printV(3);

  return 0;
}
