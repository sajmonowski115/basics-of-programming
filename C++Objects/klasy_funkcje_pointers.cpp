#include <iostream>
using namespace std;

class vector2D{

  private:

    int x_, y_;  

  public:

    vector2D(int x, int y){
      x_ = x;
      y_ = y;
    }

    int getX(){
      return x_;
    }

    int getY(){
      return y_;
    }

    friend void triple(vector2D *V);

  protected:

};

void triple(vector2D *V){
  (*(V)).x_ = (*(V)).x_ * 3;
  (*(V)).y_ = (*(V)).x_ * 3;
  cout << (*(V)).x_ << endl;
  cout << (*(V)).y_ << endl;
}

int main(){

  vector2D U(4, 9);

  cout << U.getX() << endl; //4
  cout << U.getY() << endl; //9

  triple(&U); // 12, 27

  cout << U.getX() << endl; //12
  cout << U.getY() << endl; //27

  return 0;
}
