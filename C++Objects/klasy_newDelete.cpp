#include <iostream>
using namespace std;

class Box{

  private:

    int size_;
    int weight_;    

  public:

    Box(int size, int weight){
      size_ = size;
      weight_ = weight;
    }  

    Box(){}

    void setS(int size){
      size_ = size;
    }

    void setW(int weight){
      weight_ = weight;
    }

    int getS(){
      return size_;
    }

    int getW(){
      return weight_;
    }

  protected:

};


int main(){
  
  Box *Box1_ptr = new Box(2, 3);

  cout << (*Box1_ptr).getS() << ", ";
  cout << (*Box1_ptr).getW() << endl; // 2, 3

  Box *Boxes_ptr = new Box[3]; 

  Boxes_ptr[0].setS(8);
  Boxes_ptr[0].setW(7);
  (*(Boxes_ptr+1)).setS(43);
  (*(Boxes_ptr+1)).setW(1);
  (Boxes_ptr+2)->setS(6);
  (Boxes_ptr+2)->setW(19);

  cout << Boxes_ptr[0].getS() << ", ";
  cout << Boxes_ptr[0].getW() << endl; // 8, 7

  cout << (*(Boxes_ptr+1)).getS() << ", "; 
  cout << (*(Boxes_ptr+1)).getW() << endl; // 43, 1

  cout << (Boxes_ptr+2)->getS() << ", ";
  cout << (Boxes_ptr+2)->getW() << endl; // 6, 19

  delete Box1_ptr;
  delete [] Boxes_ptr;  

  return 0;
}





