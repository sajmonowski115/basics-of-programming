#include <iostream>
#include <string>
using namespace std;

class Time{

  private:

    int minutes_;
    string time_;

  public:

    Time(int minutes){
      minutes_ = minutes;
    }

    Time(int hour, int minutes){
      minutes_ = hour*60 + minutes;
    }

    Time(string time){
      time_ = time;
    }

    string getT(){
      return time_;
    }

    int getM(){
      return minutes_;
    }

  protected:

};

int main(){

  Time A(100), B(2, 30), C("12:45");

  cout << A.getM() << endl; //100
  cout << B.getM() << endl; //150
  cout << C.getT() << endl; //12:45

  return 0;
}
