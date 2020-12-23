#include <stdio.h>

int main() {

    //console output
    printf("C Programming\n");
    int i_num = 5;
    float f_num = 13.5;
    double d_num = 11.4;
    char chr = 'a';
    printf("int number = %d\n", i_num);
    printf("float number = %f\n", f_num);
    printf("double number = %lf\n", i_num);
    printf("character = %c", chr);

    //console input

    printf("Enter an integer: ");
    scanf("%d", &i_num);
    printf("int number = %d\n", i_num);

    printf("Enter a float: ");
    scanf("%f", &f_num);
    printf("float number = %f\n", f_num);

    printf("Enter a double: ");
    scanf("%lf", &d_num);
    printf("double number = %lf\n", i_num);

    printf("Enter a character: ");
    scanf(" %c", &chr);
    printf("character = %c", chr); */

    int a;
    float b;

    printf("Enter integer and then a float: ");

    scanf("%d%f", &a, &b);

    printf("You entered %d and %f", a, b);

    return 0;

}
