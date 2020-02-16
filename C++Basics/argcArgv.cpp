#include <iostream>
using namespace std;

int main(int argc, char** argv){
  cout << "Number of extra arguments added by running the file: ";
  cout << argc-1 << endl;

  for(int i=1; i<argc; i++){
    cout << "Argument number " << i << ": " << *(argv+i) << endl;
  }
  return 0;
}
