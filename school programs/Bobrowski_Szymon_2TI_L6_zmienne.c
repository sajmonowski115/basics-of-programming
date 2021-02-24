// date: 15/12/2020
// author ~Szymon Bobrowski
// description: lab6 ex.5

#include <stdio.h>
#include <stdlib.h>
#include <stdbool.h>

main(int argc, char *argv[], char *envp[]) {
	
	// calculate how many environmental variables there are
	 int count = 0;
    	while(envp[count] != NULL) { // continue until NULL appears (NULL is the last value in envp[])
        	count++;
        	if(count == 10000) break; // protect from endless loop
    	} 
    	
    	if(argc > 1) {
    		for(int i=1; i<argc; i++) {
    			char * arg; 
    			char * val; 
    			
    			arg = argv[i]; // store the value of user input
			val = getenv(arg); // store the value returned from getenv(char *arg)
			
			if(val != NULL) {
				printf("%s is: %s\n", arg, val);
			} else {
				fprintf(stderr, "%s: such variable has not been found\n", arg);
			}
    		}
    	} else { // if no additional arguments are provided display all environmental variables
    		for(int i=0; i<count-1; i++) {
    			printf("%s\n", envp[i]);
    		}
    	}
	
	return 0;
}
