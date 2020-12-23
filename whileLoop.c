#include<stdio.h>

int main() {

    int num=0;
    printf("5*12= ");
    scanf("%d", &num);

    while(num != 60) {
        printf("incorrect result\n");
        printf("5*12= ");
        scanf("%d", &num);
    }

    printf("correct result");

    return 0;

}
