#include <stdio.h>

int main() {

    int num = 0;
    printf("Enter number: ");
    scanf("%d", &num);

    switch(num) {
        case 1:
            printf("case 1");
            break;
        case 2:
            printf("case 2");
            break;
        case 5:
            printf("case 5");
            break;
        case 10:
            printf("case 10");
            break;
        case 40:
            printf("case 40");
            break;
        default:
            printf("default case");
    }
}
