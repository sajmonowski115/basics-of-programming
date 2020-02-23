#include <iostream>
#include <string>
using namespace std;

int main(){

	string answer = "";
	do{
		cout << "The 'do while' type of loop guarantees that the ";
		cout << "statement in the loop will be executed at least once." << endl;
		cout << "Do you want to stay in the loop?[y/n] ";
		cin >> answer;
		while(answer != "y" && answer != "n"){
			cout << "Warning! Incorrect input!" << endl;
			cout << "Do you want to stay in the loop?[y/n] ";
			cin >> answer;
		}
	} while(answer == "y");

	cout << "You left the loop" << endl;

	return 0;
}
