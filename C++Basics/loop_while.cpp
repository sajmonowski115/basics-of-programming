#include <iostream>
using namespace std;

int main(){
	
	cout << "Do you want to get into the loop?[y/n] ";
	char answer;
	cin >> answer;

	while(answer != 'y' && answer != 'n'){
		cout << "Warning! Unrecognized answer!" << endl;
		cout << "Do you want to get into the loop?[y/n] ";
		cin >> answer;
	}

	char condition = false;
	while(answer == 'y'){
		cout << "You're in the loop" << endl;
		cout << "Do you want to stay in the loop?[y/n] ";
		cin >> answer;
		condition = true;
	}

	if(condition){
		cout << "You left the loop" << endl;
	}
	else{
		cout << "You didn't enter the loop" << endl;
	}

	return 0;
}
