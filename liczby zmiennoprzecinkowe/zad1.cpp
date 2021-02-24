#include <iostream>

using namespace std;

int main() {

    double x1 = -1 + (1 + 1e-20);
    double x2 = (-1 + 1) + 1e-20;
    double x3 = -1 + 1 + 1e-20;
    double x4 = 1e-20 - 1 + 1;

    cout << "x1= " << x1 << endl;
    cout << "x2= " << x2 << endl;
    cout << "x3= " << x3 << endl;
    cout << "x4= " << x4 << endl;

}

