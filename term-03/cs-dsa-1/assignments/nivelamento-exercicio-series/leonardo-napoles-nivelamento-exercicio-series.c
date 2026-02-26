//// Leonardo Nápoles
#include <stdio.h>

int lerNumTermos();
void serieA();
void serieB();
void serieC();

int main(){
    char opt;

    do {
        printf("\n--- MENU ---\n"
               "A) Serie A: (1+0)/1 + (2+1)/4 + (3+2)/9 + ...\n" 
               "B) Serie B: 1/1 + 8/10 + 27/100 + ...\n"
               "C) Serie C: 1/(3x2) + 2/(3x4) + 3/(3x6) + ...\n"
               "D) Finalizar programa\n"
               "Escolha uma opcao: ");
        scanf(" %c", &opt);

        switch (opt) {
            case 'A':
            case 'a':
                serieA();
                break;
            case 'B':
            case 'b':
                serieB();
                break;
            case 'C':
            case 'c':
                serieC();
                break;
            case 'D': 
            case 'd':
                printf("Programa finalizado. Ate mais!\n");
                break;
            default:
                printf("Erro: opcao invalida. Tente novamente.\n");
        }

    } while (opt != 'D' && opt != 'd');

    return 0;
}

int lerNumTermos(){
    int n;

   do {
    printf("Quantos termos deseja somar? ");
    scanf("%d", &n);

    if (n <= 0) {
        printf("Erro, o numero deve ser inteiro e positivo.\n");
    }
   } while(n <= 0); 

   return n;
}

void serieA(){
    int n = lerNumTermos();
    double sum = 0.0;
    int i = 1;

    while (i <= n) {
        sum += (double)(2 * i - 1) / (i * i);
        i++;
    }
    printf("Soma da serie A com %d termos: %.2f\n", n, sum);
}

void serieB(){
    int n = lerNumTermos();
    double sum = 0.0;
    int i = 1;
    double den = 1.0;

    do {
        sum += (i * i * i) / den;
        den *= 10;
        i++;
    } while (i <= n);
    printf("Somatorio da serie B com %d termos: %.2f\n", n, sum);
}

void serieC(){
    int n = lerNumTermos();
    double sum = 0.0;

    for (int i = 1; i <= n; i++){
        sum += (double)i / (3 * 2 * i);
    }
    printf("Somatorio da serie C com %d termos: %.2f\n", n, sum);
}
