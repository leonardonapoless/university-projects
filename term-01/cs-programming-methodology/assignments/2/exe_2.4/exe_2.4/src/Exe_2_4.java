// Leonardo Nápoles

import java.util.*;

public class Exe_2_4 {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        String nomeAluno;
        float nota1;
        float nota2;
        float nota3;
        float mediaNotas;

        System.out.print("Digite o nome do aluno: ");
        nomeAluno = sc.nextLine();
        System.out.print("Digite a primeira nota: ");
        nota1 = sc.nextFloat();
        System.out.print("Digite a terceira nota: ");
        nota2 = sc.nextFloat();
        System.out.print("Digite terceira nota: ");
        nota3 = sc.nextFloat();

        mediaNotas = nota1 + nota2 + nota3 / 3;

        if(mediaNotas >= 7){
            System.out.println("Aluno " + nomeAluno + " aprovado!");
        } else if(mediaNotas >= 4.1 && mediaNotas <= 6.9){
            System.out.println("Aluno " + nomeAluno + " em recuperação.");
        } else {
            System.out.println("Aluno " + nomeAluno + " reprovado.");
        }

    }
}
