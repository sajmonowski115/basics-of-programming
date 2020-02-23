#include <iostream>
using namespace std;

int main(){
	
	cout << "What grade did you get in the exam: ";
	char grade;
	cin >> grade;

	switch(grade){
		case 'A':
			cout << "Excellent!" << endl;
			break;
		case 'B':
			cout << "Well done!" << endl;
			break;
		case 'C':
			cout << "Quite allrigth" << endl;
			break;
		case 'D':
			cout << "Well.. you passed." << endl;
			break;
		case 'F':
			cout << "Sorry. Next time maybe!" << endl;
			break;
	}


	return 0;
}
