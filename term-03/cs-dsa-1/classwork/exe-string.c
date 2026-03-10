#include <stdio.h>
#include <stdlib.h>
#include <string.h>

int main(void) {
	//Declaração de strings
	char string1[30];
	char string2[30];

	//Exercício 01 - Solicitar 2 strings
	printf("\nDigite a primeira string: ");
	scanf(" %[^\n]", string1);
    //	fflush(stdin);
    //	gets(string1);

	printf("\nDigite a segunda string: ");
	scanf(" %[^\n]", string2);
    //	fflush(stdin);
    //	fgets(string2, 29, stdin);

	printf("\nString 01 - %s e String 02 - %s", string1, string2);

	//Exercício 02 - Tamanho das strings
	// printf("\nTamanho de %s - %i", string1, strlen(string1));
	// int tamanho = strlen(string2);
	// printf("\nTamanho de %s - %i", string2, tamanho);
    //
    int tamanho1 = 0;
    while (string1[tamanho1] != '\0') {
            tamanho1++;
    }
    printf("\nTamanho da string1: %i", tamanho1);

    int tamanho2 = 0;
    while (string2[tamanho2] != '\0') {
        tamanho2++;
    }
    printf("\nTamanho da string2: %i", tamanho2);


	//Exercício 03 - Cópia de strings
	strcpy(string1, string2);
	printf("\nString 01 - %s e String 02 - %s", string1, string2);

	strcpy(string2, "Leonardo");
	printf("\nString 01 - %s e String 02 - %s", string1, string2);

    //strcmp
    int cmpRes = strcmp(string1, string2);
    if (cmpRes == 0){
        printf("\nAs strings são iguais");
    } else if (cmpRes < 0) {
        printf("\n%s vem antes de %s", string1, string2);
    } else {
        printf("\n%s vem depois de %s", string1, string2);
    }

    
	return 0;
}
