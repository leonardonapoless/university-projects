// Leonardo Nápoles

import java.util.*;

public class Exe_2_5 {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);

        int votosCandidato1sec1;
        int votosCandidato2sec1;
        int votosCandidato3sec1;
        int votosCandidato1sec2;
        int votosCandidato2sec2;
        int votosCandidato3sec2;
        int somaCandidato1;
        int somaCandidato2;
        int somaCandidato3;


        // SEÇÃO 1
        System.out.print("Digite o numero de votos do candidato 1 na primeira seção: ");
        votosCandidato1sec1 = sc.nextInt();
        System.out.print("Digite o numero de votos do candidato 2 na primeira seção: ");
        votosCandidato2sec1 = sc.nextInt();
        System.out.print("Digite o numero de votos do candidato 3 na primeira seção: ");
        votosCandidato3sec1 = sc.nextInt();

        // SEÇÃO 2
        System.out.print("Digite o numero de votos do candidato 1 na segunda seção: ");
        votosCandidato1sec2 = sc.nextInt();
        System.out.print("Digite o numero de votos do candidato 2 na segunda seção: ");
        votosCandidato2sec2 = sc.nextInt();
        System.out.print("Digite o numero de votos do candidato 3 na segunda seção: ");
        votosCandidato3sec2 = sc.nextInt();

        somaCandidato1 = votosCandidato1sec1 + votosCandidato1sec2;
        somaCandidato2 = votosCandidato2sec1 + votosCandidato2sec2;
        somaCandidato3 = votosCandidato3sec1 + votosCandidato3sec2;

        if(somaCandidato1 != somaCandidato2 && (somaCandidato1 != somaCandidato3) &&
                ((somaCandidato1 > somaCandidato2) && (somaCandidato1 > somaCandidato3))){
            System.out.println("O candidato 1 é o vencedor com " + somaCandidato1 + " votos." );
        } else if(somaCandidato2 != somaCandidato1 && (somaCandidato2 != somaCandidato3) &&
                (somaCandidato2 > somaCandidato1) && somaCandidato2 > somaCandidato3){
            System.out.print("O candidato 2 é o vencedor com " + somaCandidato2 + " votos.");
        } else if(somaCandidato3 != somaCandidato1 && (somaCandidato3 != somaCandidato2) &&
                (somaCandidato3 > somaCandidato2) && (somaCandidato3 > somaCandidato1)){
            System.out.print("O candidato 3 é o vencedor com " + somaCandidato3 + " votos.");
        } else if(somaCandidato1 == somaCandidato2){
            System.out.print("O candidato 1 empatou com o candidato 2 com " + somaCandidato1 + " votos.");
        } else if(somaCandidato1 == somaCandidato3){
            System.out.print("O candidato 1 empatou com o canddidato 3 com " + somaCandidato1 + " votos.");
        } else if(somaCandidato2 == somaCandidato1){
            System.out.print("O candidato 2 empatou com candidato 1 com " + somaCandidato2 + " votos.");
        } else if(somaCandidato2 == somaCandidato3){
            System.out.print("O candidato 2 empatou com o candidato 3 com " + somaCandidato2 + " votos.");
        } else if(somaCandidato3 == somaCandidato1){
            System.out.print("O candidato 3 empatou com o candidato 1 com " + somaCandidato3 + " votos.");
        } else if(somaCandidato3 == somaCandidato2){
            System.out.print("O candidato 3 empatou com o candidato 2 com " + somaCandidato3 + " votos.");
        }

    }
}
