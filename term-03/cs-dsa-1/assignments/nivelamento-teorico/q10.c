#include <stdio.h>

int main(){
    int A = 1, B = 0, C = 1;
    int resultado = (A && B) || C;

    printf("%d\n", resultado);
    
    return 0;
}
