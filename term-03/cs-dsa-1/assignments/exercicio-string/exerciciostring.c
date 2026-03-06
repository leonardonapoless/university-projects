#include <stdio.h>

int main(){
    // maipulação de vetor
    int vetor[] = {8, 45, 93};
    vetor[2] = 1245; // atribuição
    for (int i = 0; i < 3; i++) {
        printf("\nDigite o valor: ");
        scanf("%i" ,&vetor[i]);
        printf("\n%d - %p", vetor[i], &vetor[i]);
    }
    printf("\nOnde começa o meu vetor? %p", vetor);

    char matriz[][3] = {'R', 'T', 'O', '9'};
    matriz[0][0] = 'a';
    for (int l = 0; 1 < 2; l++) {
        printf("\n%i linha: ", l+l);
        for (int c = 0; c < 3; c++) {
            printf("\n[%i][%i]Digite o valor: ", l, c);
            scanf("%c" ,&matriz[l][c]);
            printf("\n%c - %p", matriz[l][c], &matriz[l][c]);
        }
    }

    return 0;
}

/*
 1         - 0x16f8e2ba0
-1         - 0x16f8e2ba4%                                                                                                                                              
*/

/*
8          - 0x16b2e6ba0
45         - 0x16b2e6ba4%   
*/

/*
8          - 0x16b59ab88
45         - 0x16b59ab8c
93         - 0x16b59ab90
0          - 0x16b59ab94
1885536483 - 0x16b59ab98%
*/


/*
8 - 0x16ba62b88
45 - 0x16ba62b8c
1245 - 0x16ba62b90
Onde começa o meu vetor? 0x16ba62b88%
*/
