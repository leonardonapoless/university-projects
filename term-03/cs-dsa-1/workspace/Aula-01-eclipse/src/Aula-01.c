/*
 ============================================================================
 Name        : Aula-01.c
 Author      : Leonardo Nápoles
 Version     :
 Copyright   : Since 2002 xD
 Description : Hello World in C, Ansi-style
 ============================================================================
 */

#include <stdio.h>
#include <stdlib.h>

// global var
// char letra = 'A';

int main(void) {
	
	unsigned int variavel;
	char letra = 'A';
	
	printf("Hi mom!\n"); 

	printf("Tamanho do tipo %d - Endereço de memória %p", sizeof(int), &variavel);
	return 0;
}