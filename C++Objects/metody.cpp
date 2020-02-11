#include <iostream>
using namespace std;

class Complex{

  private:

    int real_;
    int image_;

  public:

    Complex(int r, int i){
      real_ = r;
      image_ = i;
    }

    int getR(){
      return real_;
    }

    int getI(){
      return image_;
    }

    void add(Complex c){
      real_ += c.real_;
      image_ += c.image_;
    }

    bool isComplex(){
      if(image_ != 0){
        return true;
      }
      else{
        return false;
      } 
    }

  protected:

};

int main(){

  Complex c1(2, 7), c2(11, -2);


  cout << "First complex: " << c1.getR() << "+" << c1.getI() << "i" << endl;
  // 2+7i

  cout << "Second complex: " << c2.getR() << c2.getI() << "i" << endl;
  // 11-2i

  c1.add(c2);

  cout << "After addition: " << c1.getR() << "+" << c1.getI() << "i" << endl;
  // 13+5i

  if(c1.isComplex()){
    cout << "This is a complex number." << endl;
  }

  return 0;
}
