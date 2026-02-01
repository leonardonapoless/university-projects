
import java.util.*;

public class Exe_5_4 {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);

        char gabarito[] = new char[10];
        byte contGabarito;
        byte contQuestao = 0;
        int matriculaAluno = 0;
        int notas[] = new int[10];
        char resposta[] = new char[10];
        byte contResposta = 0;
        int contAlunos = 0;
        int alunosAprovados;
        char notaMaiorFreq;


        for (contGabarito = 0; contGabarito <= 9; contGabarito++){
            System.out.print("Digite o gabarito da questao " + (contGabarito+1) + ": ");
            gabarito[contGabarito] = sc.next().toUpperCase().charAt(0);
            if (gabarito[contGabarito] != 'A' && gabarito[contGabarito] != 'B' &&
                    gabarito[contGabarito] != 'C' && gabarito[contGabarito] != 'D' &&
                    gabarito[contGabarito] != 'E'){
                System.out.println("Gabarito invalido, digite A, B, C, D ou E. \n");
                contGabarito -= 1;
            }

        }

        do {
            System.out.print("\nDigite o numero de matricula do aluno ('00' para encerrar): ");
            matriculaAluno = sc.nextInt();

            if (matriculaAluno == 00){
                break;
            }

            for (contResposta = 0; contResposta <= 9; contResposta++) {
                System.out.print("Digite a resposta do aluno " + (contAlunos+1) + " para a questao " + (contResposta+1) + ": ");
                resposta[contResposta] = sc.next().toUpperCase().charAt(0);
                if (resposta[contResposta] != 'A' && resposta[contResposta] != 'B' &&
                        resposta[contResposta] != 'C' && resposta[contResposta] != 'D' &&
                        resposta[contResposta] != 'E') {
                        System.out.println("Resposta invalida, digite A, B, C, D ou E. \n");
                        contResposta -= 1;
                    }
                }

            contAlunos++;



        }while(matriculaAluno != 00);

        System.out.println(gabarito);

    }
}
