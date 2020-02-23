#include <iostream>
using namespace std;

int main(){

/*  Less than: a < b
Less than or equal to: a <= b
Greater than: a > b
Greater than or equal to: a >= b
Equal to a == b
Not Equal to: a != b  */

	int x = 25;
	int y = 15;

	cout << "x = " << x << endl;
	cout << "y = " << y << endl;

	if(x>y){
		cout << "x is greater than y" << endl;
	}  // x is greater than y
        
	if (y>x){
		cout << "y is greater than x" << endl;
	}
	else{
		cout << "y is smaller than x" << endl;
	} // y is smaller than x"
	
	if(y%2 == 0){
		cout << "y is an even number" << endl;
	}
	else if(x%5==0){
		cout << "x is divisable by five" << endl;
	}
	else{
		cout << "y is an odd number and x isn't divisable by five" << endl;
	} // x is divisable by five

		
	return 0;
}
