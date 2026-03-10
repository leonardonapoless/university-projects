#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(){
    // manipular caractere
    char letra = 'A';
    printf("\nLetra %c - Decimal %d", letra, letra);

    // manipular string
    char frase[30] = "Estrutura";
    printf("\n%s", frase);

    // manipulação de cada indice
    // frase[0] = '0';
    // frase[1] = '1';
    // frase[2] = 'a';
    // frase[3] = '\0';

    printf("\n%s", frase);

    printf("\nDigite uma string: ");
    // fflush(stdin); // usado com gets() e fgets()
    // gets(frase);
    // fgets(frase, 29, stdin);
    scanf(" %[ˆ\n]", frase);
    printf("\n%s - Frase digitada.", frase);
    printf("\nTamanho da frase digitada %i", strlen(frase));

    // strcopy
    char palavra[] = "FUMEC - Teste";
    strcpy(frase, palavra);
    printf("\n%s - Frase copiada.", frase);

    strcpy(frase, "Teste");
    printf("\n%s - Frase copiada.", frase);

    // strncpy
    strncpy(frase, palavra, 10);
    printf("\n%s - Frase copiada.", frase);

    strcat(...)

    return 0;
}
