#include <stdio.h>

int main(){
    int i,x,y;
    i = 0;
    while (i < 5) {
        i++;
        if (i % 2) {
            x = i -2;
            printf("%d",x);
        } else {
            y = i + 3;
            printf("%d",y);
        }
    }
    return 0;
}
