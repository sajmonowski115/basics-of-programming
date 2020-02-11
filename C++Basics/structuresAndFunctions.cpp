#include <iostream>
#include <string>
#include <cstdlib>
using namespace std;

struct userInterface{
  string nick;
  int positionInRanking;
};

void sortByRanking(userInterface user[], int users){
  userInterface temporaryUser;
  for(int i=0; i<users; i++){
    for(int j=0; j<users-1; j++){
      if(user[j].positionInRanking>user[j+1].positionInRanking){
        temporaryUser=user[j];
        user[j] = user[j+1];
        user[j+1] = temporaryUser;
      }
    }
  }
  
  for(int i=0; i<users; i++){
    cout << user[i].nick << endl;
  }
}

int main(){
  int users = 4;
  userInterface user[users];
  
  user[0].nick = "BoBo";
  user[0].positionInRanking = 20;

  user[1].nick = "Hugo";
  user[1].positionInRanking = 5;
  
  user[2].nick = "Pancake";
  user[2].positionInRanking = 41;

  user[3].nick = "Boss";
  user[3].positionInRanking = 2;

  cout << "The players: " << endl;
  for(int i=0; i<users; i++){
    cout << user[i].nick << ", ";
    cout << "Posiotion in rankig: " << user[i].positionInRanking << endl;
  } //Bobo, Hugo, Pancake, Boss
  cout << "The players by their position in ranking: " << endl;
  sortByRanking(user, users); //Boss, Hugo, Bobo, Pancake

  return 0;  
}
