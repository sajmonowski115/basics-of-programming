#include <stdio.h>

int main() {


    for(int i=1; i<5; i++) {
        for(int j=14; j>10; j--) {
            for(int g=111; g<114; g++) {
                printf("%d, %d, %d\n", i, j, g);
            }
        }
    }


    int i, j;
    for(i=1, j=5; i<3 || j>1; i++,j--) {
        printf("%d, %d\n",i ,j);
    }

    return 0;
}
