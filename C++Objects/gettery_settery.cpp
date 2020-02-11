#include <iostream>
using namespace std;

class vector{

  private:
  
    int x_;
    int y_;
  
  public:

    int setX(int x){
      x_=x;
    }

    int setY(int y){
      y_=y;
    }

    int getX(){
      return x_;
    }

    int getY(){
      return y_;
    }

  protected:

};

int main(){

  vector v1;

  v1.setX(13);
  v1.setY(0);

  cout << v1.getX() << endl; //13
  cout << v1.getY() << endl; //0

  cout << 43 - v1.getX() << endl; //30  

  return 0;
}
