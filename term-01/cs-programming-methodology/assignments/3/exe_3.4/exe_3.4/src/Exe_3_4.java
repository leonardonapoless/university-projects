// Leonardo Napoles

import java.util.*;

public class Exe_3_4 {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);

        int numMatricula;
        int nota1;
        int nota2;
        int nota3;
        int notaFinal = 0;
        int mediaNotaFinal;
        int maiorNotaFInal = 0;
        String nomeAluno = "";
        String alunoMaiorNota;
        int cont = 0;

        while (cont >= 0){
            System.out.print("Digite o numero de matricula do aluno (ou 999 para encerrar): ");
            numMatricula = sc.nextInt();

            if (numMatricula == 999){
                break;
            }

            System.out.print("Digite o nome do aluno: ");
            nomeAluno = sc.next();
            System.out.print("Digite a primeira nota do semestre: ");
            nota1 = sc.nextInt();
            System.out.print("Digite a segunda nota do semestre: ");
            nota2 = sc.nextInt();
            System.out.print("Digite a terceira nota do semestre: ");
            nota3 = sc.nextInt();

            notaFinal = nota1 + nota2 + nota3;

            if (notaFinal >= 60){
                System.out.println("Aluno Aprovado.");
            } else {
                System.out.println("Aluno Reprovado.");
            }

            if (notaFinal > maiorNotaFInal){
                maiorNotaFInal = notaFinal;
                alunoMaiorNota = nomeAluno;
            }

            cont++;
        }

        mediaNotaFinal = notaFinal / cont;

        System.out.println("Quantidade total de alunos da turma: " + cont);
        System.out.println("Media de notas finais da turma: " + mediaNotaFinal);
        System.out.println("Aluno com maior nota final ↓ \n" + "Nome: " + nomeAluno +
                "\nNota: " + maiorNotaFInal);

    }
}