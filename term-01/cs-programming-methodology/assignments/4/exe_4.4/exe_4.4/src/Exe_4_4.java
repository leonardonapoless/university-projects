

import java.util.*;

public class Exe_4_4 {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);

        int codOperario;
        char classe;
        int numPecas;
        float salario;
        float somaSalarios = 0;
        int somaNumPecas = 0;
        int menorNumPecas = 999;
        int codOperarioMenorNumPecas = 0;
        int somaPecasClasseB = 0;
        int contOperario = 0;
        int contOperarioClasseB = 0;

        do {
            System.out.print("Digite o codigo do operario (zero para finalizar): ");
            codOperario = sc.nextInt();
            if (codOperario == 0){
                break;
            }

            do {
                System.out.print("Digite a classe do operario: ");
                classe = sc.next().charAt(0);
                if (classe != 'A' && classe != 'B' && classe != 'C'){
                    System.out.println("Classe invalida, digite classe A, B ou C.");
                }

            }while (classe != 'A' && classe != 'B' && classe != 'C');

            do {
                System.out.print("Digite o numero de pecas fabricadas no mes: ");
                numPecas = sc.nextInt();
                if (numPecas <= 0){
                    System.out.println("Numero de pecas invalido, digite acima de acima zero.");
                }
            } while (numPecas <= 0);

            if (classe == 'A'){
                if (numPecas <= 30){
                    salario = 500 + 2 * numPecas;
                } else if (numPecas <= 40){
                    salario = 500 + 2.30f * numPecas;
                } else {
                    salario = 500 + 2.80f * numPecas;
                }
            } else if (classe == 'B'){
                salario = 1200;
                somaPecasClasseB = somaPecasClasseB + numPecas;
                contOperarioClasseB++;
            } else {
                if (numPecas <= 50){
                    salario = 40 * numPecas;
                } else {
                    salario = 45 * numPecas;
                }
            }

            somaSalarios = somaSalarios + salario;
            somaNumPecas = somaNumPecas + numPecas;

            if (numPecas < menorNumPecas){
                menorNumPecas = numPecas;
                codOperarioMenorNumPecas = codOperario;
            }

            System.out.println("Salario do operario: " + salario);

        }while(codOperario != 0);

        System.out.println("Total gasto com salarios: " + somaSalarios);
        System.out.println("Total de pecas fabricadas: " + somaNumPecas);
        System.out.println("Codigo do operario que fabricou o menor numero de pecas: " + codOperarioMenorNumPecas);
        if (contOperarioClasseB > 0){
            System.out.println("Media de pecas fabricadas na classe B: " + somaPecasClasseB / contOperarioClasseB);
        }
    }
}