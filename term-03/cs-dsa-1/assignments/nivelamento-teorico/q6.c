#include <stdio.h>

int main(){
    const int i = 5;
    int j = i + i;
    printf("%d", j++);
    return 0;
}
