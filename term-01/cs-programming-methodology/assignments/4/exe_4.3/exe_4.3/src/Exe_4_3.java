// Leonardo Napoles

import java.util.*;

public class Exe_4_3 {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);

        float altura = 0;
        char sexo = ' ';
        int contAtletasM = 0;
        int contAtletasF = 0;
        float maiorAltura = 0;
        float menorAltura = 2.5f;
        float mediaAlturaMasc = 0;
        float mediaAlturaGeral = 0;
        float somaAlturasMasc = 0;
        float somaAlturasGeral = 0;
        int totalAtletas = 0;

        do {

            do {
                System.out.print("Digite a altura do (da) atleta (ou 0 para sair): ");
                altura = sc.nextFloat();

                if (altura < 0 || altura > 2.5){
                    System.out.println("Altura invalida, digite altura maior que 0 e menor ou igual a 2.5");
                }
            } while (altura < 0 || altura > 2.5);

            if (altura == 0){
                break;
            }


            do {
                System.out.print("Digite o sexo do (da) atleta (M/F): ");
                sexo = sc.next().charAt(0);

                if (sexo != 'M' && sexo != 'F'){
                    System.out.println("Sexo invalido, digite 'M' ou 'F'");
                }
            } while (sexo != 'M' && sexo != 'F');


            if (sexo == 'M'){
                contAtletasM++;
                somaAlturasMasc += altura;
            } else {
                contAtletasF++;
            }


            if (altura > maiorAltura){
                maiorAltura = altura;
            }

            if (altura < menorAltura){
                menorAltura = altura;
            }

            somaAlturasGeral += altura;
            totalAtletas = contAtletasM + contAtletasF;

        } while (altura != 0);


        if (contAtletasM > 0) {
            mediaAlturaMasc = somaAlturasMasc / contAtletasM;
        }

        if (totalAtletas > 0) {
            mediaAlturaGeral = somaAlturasGeral / totalAtletas;

            if (menorAltura == 2.5) {
                menorAltura = 0;
            }
        }

        System.out.println("Maior altura: " + maiorAltura);
        System.out.println("Menor altura: " + menorAltura);
        System.out.println("Numero de atletas femininas: " + contAtletasF);
        System.out.println("Media geral de alturas: " + mediaAlturaGeral);
        if (contAtletasM > 0){
            System.out.println("Media de altura masculina: " + mediaAlturaMasc);
        }
    }
}

