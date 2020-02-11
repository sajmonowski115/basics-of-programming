#include <iostream>
#include <string>
using namespace std;

class Server{

  private:

    string *player_;
    int serverSize_;

  public:

    Server(string p1, int size){
      player_ = new string;
      serverSize_ = size;
      *player_ = p1;
    }

    Server(string p1, string p2, int size){
      player_ = new string[2]; 
      serverSize_ = size;
      *player_ = p1; // alternativly player_[0], player_[1];
      *(player_+1) = p2;
    }

    void playerList(){
      switch(serverSize_){
        
        case 1:
        cout << player_[0] << endl;
        break;

        case 2:
        cout << player_[0] << endl;
        cout << player_[1] << endl;
        break;
      }      
    }

   ~Server(){
     delete [] player_;
   }
};

int main(){

  Server LeagueA("marco123", "lucky_XX", 2);
  
  LeagueA.playerList(); // marcon 123, lucky_xx

  return 0;
}
