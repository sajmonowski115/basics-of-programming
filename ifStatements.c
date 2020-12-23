#include <stdio.h>

int main() {
    int x = 20;
    int y = 22;

    printf("x= ");
    scanf("%d", &x);
    printf("y= ");
    scanf("%d", &y);

    if(x%2 == 0 && y%2 == 0) {
        printf("x and y are both even numbers");
    } else if (x%2 == 0 || y%2 == 0) {
        printf("x or y is an even number");
    } else {
        printf("Neither x nor y is an even number");
    }

    return 0;
}
