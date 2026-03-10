#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(){
    char string1[30];
    char string2[30];

    printf("\nDigite a primeira string: ");
    scanf(" %[^\n]", string1);

    printf("\nDigite a segunda string: ");
    scanf(" %[^\n]", string2);

    printf("\nString 1 - %s, String 2 - %s", string1, string2);
    
    printf("\nTamanho da %s - %i", string1, strlen(string1));
    int tamanho = strlen(string2);
    printf("\nTamanho da %s - %i", string2, strlen(string2));

    strcpy(string2, string1);
    printf("\nString1 - %s copiada para String2", string1);
    printf("\nString2 - %s", string2);

    return 0;
}
