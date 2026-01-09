
import java.util.*;

public class Exe_5_1 {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);

        int numNotas = 5;
        int numAlunos = 10;
        float notas[] = new float[numNotas];
        float mediaNotasAlunos[] = new float[numAlunos];
        float mediaNotaTurma = 0;
        float somaNotasAluno = 0;
        float somaMediaTurma = 0;
        byte contAlunos = 0;
        byte contNotas = 0;

        for (contAlunos  = 0; contAlunos < 9; contAlunos++){
            somaNotasAluno = 0;
            for (contNotas = 0; contNotas < 5; contNotas++){
                System.out.print("Digite a nota " + (contNotas+1) + " do aluno " + (contAlunos+1) + ": ");
                notas[contNotas] = sc.nextFloat();

                somaNotasAluno = somaNotasAluno + notas[contNotas];
            }

            mediaNotasAlunos[contAlunos] = somaNotasAluno / numNotas;

            somaMediaTurma = somaMediaTurma + mediaNotasAlunos[contAlunos];

        }

        mediaNotaTurma = somaMediaTurma / numAlunos;
        System.out.println("\n Numero do aluno " + "       " + "Media do aluno \n");

        for (contAlunos = 0; contAlunos < numAlunos; contAlunos++){
            System.out.println("        " + (contAlunos+1) + "                    " + mediaNotasAlunos[contAlunos]);
        }

        System.out.println("\nMedia da turma: " + mediaNotaTurma);

    }
}
