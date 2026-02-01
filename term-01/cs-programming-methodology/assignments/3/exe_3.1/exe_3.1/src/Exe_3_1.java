// Leonardo Nápoles

import java.util.*;

public class Exe_3_1 {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);

        byte notaAluno;
        int contAluno = 1;

        System.out.println("LTP");
        while (contAluno <= 10) {
            System.out.print("Digite a nota do aluno " + contAluno + ": ");
            notaAluno = sc.nextByte();

            contAluno = contAluno + 1;

                if (notaAluno < 60) {
                    System.out.println("Aluno Reprovado");
                } else {
                    System.out.println("Aluno Aprovado");
                }

        }
    }
}
