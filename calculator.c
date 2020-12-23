#include <stdio.h>
#include <stdbool.h>

int main() {
    printf("This program is a simple calculator application.\n");

    int num = 0;

    printf("To to open the calculator type 1. To stop the program type 0. [1/0]: ");
    scanf("%d", &num);

    while(num != 1 && num != 0) {
        printf("Wrong number typed!\n");
        printf("To to open the calculator type 1. To stop the program type 0. [1/0]: ");
        scanf("%d", &num);
    }

    bool flag = 1;
    if(num == 1) {
        flag = true;
    } else {
        flag = false;
    }

    int iter = 1;
    char chr = 'r';
    int operation = 1;

    float a = 0;
    float b = 0;
    float ai = 0;
    float bi = 0;

    while(flag) {
        printf("Do you want to calculate on real numbers or imaginary numbers? [r/i]: ");
        scanf(" %c", &chr);

        while(chr != 'r' && chr != 'i') {
            printf("Unrecognized command! Do you want to calculate on real numbers or imaginary numbers? [r/i]: ");
            scanf(" %c", &chr);
        }

        if(chr == 'r') {
            printf("Available operations:\n");
            printf("1. add\n2. subtract\n3. multiply\n4. divide\n");
            printf("What operation would you like to perform? [1, 2, 3, 4]: ");
            scanf("%d", &operation);

            while(operation != 1 && operation != 2 && operation != 3 && operation != 4) {
                printf("Unrecognized command! What operation would you like to perform? [1, 2, 3, 4]: ");
                scanf("%d", &operation);
            }

            printf("First number: "); scanf("%f", &a);
            printf("Second number: "); scanf("%f", &b);

            switch(operation) {
                case 1:
                    printf("%f + %f = %f\n", a, b, a+b);
                    break;
                case 2:
                    printf("%f - %f = %f\n", a, b, a-b);
                    break;
                case 3:
                    printf("%f * %f = %f\n", a, b, a*b);
                    break;
                case 4:
                    printf("%f / %f = %f\n", a, b, a/b);
                    break;
            }
        } else if(chr == 'i') {
            printf("Available operations:\n");
            printf("1. add\n2. subtract\n");
            printf("What operation would you like to perform? [1, 2]: ");
            scanf("%d", &operation);

            while(operation != 1 && operation != 2) {
                printf("Unrecognized command! What operation would you like to perform? [1, 2]: ");
                scanf("%d", &operation);
            }

            printf("First number real part: "); scanf("%f", &a);
            printf("First number imaginary part: "); scanf("%f", &ai);
            printf("Second number real part: "); scanf("%f", &b);
            printf("Second number imaginary part: "); scanf("%f", &bi);

            switch(operation) {
                case 1:
                    printf("(%f + %fi) + (%f + %fi) = %f + %fi\n", a, ai, b, bi, a+b, ai+bi);
                    break;
                case 2:
                    printf("(%f + (%fi)) - (%f + (%fi)) = %f + (%fi)\n", a, ai, b, bi, a-b, ai-bi);
                    break;
            }

        }

        printf("To start another calculation type 1. To stop the program type 0. [1/0]: ");
        scanf("%d", &num);

        while(num != 1 && num != 0) {
            printf("Wrong number typed!\n");
            printf("To to open the calculator type 1. To stop the program type 0. [1/0]: ");
            scanf("%d", &num);
        }


        if(num == 1) {
            flag = true;
        } else {
            flag = false;
        }

        iter++;
        if(iter == 100) break;
    }

    printf("Program closed successfully\n");
    return 0;
}
