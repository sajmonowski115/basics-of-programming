#include <iostream>
#include <string>
using namespace std;


class Team{

  private:

  public:
 
    Team(string p1, string p2, int t, int n){
      player_ = new string[n];
      player_[0] = p1;
      player_[1] = p2;
      trophies_ = t;
    }

    void printData(int number){
      cout << "Players: " << endl;
      for(int i=0; i<number; i++){
        cout << player_[i] << endl;
      }
      cout << "Trophies: " << trophies_ << endl;
    }

    ~Team(){
      delete [] player_;
      player_ = NULL;
    }

  protected:

    string *player_;
    int trophies_;
};

class Club:public Team{

  private:

    string coach_;

  public:

    Club(string p1, string p2, string p3, int t, int n, string c) 
    : Team(p1, p2, t, n){
      player_[2] = p3;
      coach_ = c;
    }

    void printData(int number){
      Team::printData(number);
      cout << "Coach: " <<  coach_ << endl;
    }

    ~Club(){
      if(player_ != NULL){
        delete [] player_;
        player_ = NULL;
      }
    }
    
  protected:

};


int main(){
  
  Club FC("Roney", "Sanches", "Alves", 128, 3, "Murinho");
  FC.printData(3);  

  return 0;
}
