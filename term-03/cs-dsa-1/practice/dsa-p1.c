#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main() {
    int bananas = 20;
    int apples = 30;

    while(bananas < apples){
        printf("you have fewer bananas than apples %d", bananas);
        bananas++;
    }

    return 0;
}