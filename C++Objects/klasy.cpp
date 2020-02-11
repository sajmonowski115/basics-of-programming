#include <iostream>
using namespace std;

class vector{

  private:

  public:

    int x;
    int y;

  protected:
};

int main(){
  vector v1;
  v1.x = 5;
  v1.y = -8;

  cout << "first coordinate: " << v1.x << endl; // 5
  cout << "second coordinate: " << v1.y << endl; // -8

  return 0;
}
