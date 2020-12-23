#include <stdio.h>

int main() {

    //calculate sum and average

    int avg=0;
    int sum=0;

    int num[4];

    for(int i=0; i<4; i++) {
        printf("Enter number %d: ", i+1);
        scanf("%d", &num[i]);
    }

    for(int i=0; i<4; i++) {
        sum += num[i];
    }

    avg = sum/4;
    printf("Sum: %d\n", sum);
    printf("Average: %d\n ", avg);

    int arr[6] = {1, 2, 5, 10, 20, 100};
    int arr_2[] = {2, 4, 8};

    for(int i=0; i<6; i++) {
        printf("arr[%d]: %d\n", i, arr[i]);
    }

    return 0;
}
