// Leonardo Napoles

import java.util.*;

public class Exe_4_2 {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);

        byte voto = 0;
        int contCand1 = 0;
        int contCand2 = 0;
        int contCand3 = 0;
        int contNulo = 0;
        int contBranco = 0;
        int x;

        for (x = 1; x <= 10; x++){
            do {
                System.out.print("Digite o voto do eleitor " + x + " : ");
                voto = sc.nextByte();

                if (voto < 1 || voto > 5){
                    System.out.println("Voto invalido, digite de 1 a 5");
                }

            } while (voto < 1 || voto > 5);


            if (voto == 1){
                contCand1++;
            } else if (voto == 2) {
                contCand2++;
            } else if (voto == 3) {
                contCand3++;
            } else if (voto == 4) {
                contNulo++;
            } else {
                contBranco++;
            }
        }

        if (contCand1 > contCand2 && contCand1 > contCand3){
            System.out.println("O candidato 1 venceu com " + contCand1 + " votos.");
        } else if (contCand2 > contCand3) {
            System.out.println("O candidato 2 venceu com " + contCand2 + " votos.");
        } else {
            System.out.println("O candidato 3 venceu com " + contCand3 + " votos.");
        }

        System.out.println("Votos nulos: " + contNulo);
        System.out.println("Votos em branco: " + contBranco);
    }
}