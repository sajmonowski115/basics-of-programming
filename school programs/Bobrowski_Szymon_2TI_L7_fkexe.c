// date: 27/12/2020
// author ~Szymon Bobrowski
// description: lab7 ex.7

#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>

int main() {

    printf("Parent process has started.\n");
    sleep(1); // to maintain clarity of the program output

    int pid_of_child = 0;
    int stat;

    printf("Forking two new processes.\n");
    sleep(1);

    int a = fork();
    int b = fork();

    if(a != 0 && b == 0) { // enter only in nowy1.c
        printf("nowy1 process has started.\n");
        char *args[]={"./Bobrowski_Szymon_2TI_L7_nowy1",NULL};
        execvp(args[0],args);
    } else if (a != 0 && b != 0) { // enter only in parent process
        pid_of_child = wait(&stat);
        printf("nowy1 has termindated.\n");

        printf("Return code of nowy1 process: %d\n", WEXITSTATUS(stat));
        printf("Signal that terminated nowy1: %d\n", WTERMSIG(stat));
        printf("nowy1 pid: %d\n", pid_of_child);
    }

    if(b != 0 && a ==0) { // enter only in nowy2.c
        printf("nowy2  process has started.\n");
        char *args[]={"./Bobrowski_Szymon_2TI_L7_nowy2",NULL};
        execvp(args[0],args);
    } else if (a != 0 && b != 0) { // enter only in parent process
        pid_of_child = wait(&stat);
        printf("nowy2 has termindated.\n");

        printf("Return code of nowy2 process: %d\n", WEXITSTATUS(stat));
        printf("Signal that terminated nowy2: %d\n", WTERMSIG(stat));
        printf("nowy2 pid: %d\n", pid_of_child);
    }

    sleep(1);
    if(a != 0 && b != 0) { // enter only in parent process
        printf("Parent process has terminated.\n");
    }

    return 0;
}
