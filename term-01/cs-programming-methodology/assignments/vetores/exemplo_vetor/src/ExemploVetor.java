
import java.util.*;

public class ExemploVetor {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);

        float notas[] = new float[40];
        byte cont;
        float somaNotas = 0;
        float mediaNotas;
        byte contAcimaMedia = 0;

        for (cont = 0; cont <= 9; cont++){
            System.out.print("Digite a nota do aluno " + (cont+1) + ": ");
            notas[cont] = sc.nextFloat();

            somaNotas = somaNotas + notas[cont];
        }

        mediaNotas = somaNotas / 40;
        for (cont = 0; cont <= 39; cont++){
            if (notas[cont] > mediaNotas){
                contAcimaMedia++;
            }
        }

        System.out.println("Media de notas da turma: " + mediaNotas);
        System.out.println("Quantidade de alunos com nota acima da media: " + contAcimaMedia);
    }
}
