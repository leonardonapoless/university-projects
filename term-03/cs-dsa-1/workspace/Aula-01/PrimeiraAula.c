#include <stdio.h>
#include <stdlib.h>

int main(void){
    // setbuf(stdout, NULL); windows video buffer!!!!

    /* int x = 13;
    int y = x++;
    printf("\nx = %d e y %d", x, y);
    printf("\n%i", x);*/

    printf("\nUniversidade FUMEC");

    int x = 13;
    //printf("\n%i", x);

    printf("\nDigite um valor: ");
    scanf("%i", &x);
    printf("\nO valor %d dividido por 2 é %.2f", x, (float) x/2);

    return 0;
}
