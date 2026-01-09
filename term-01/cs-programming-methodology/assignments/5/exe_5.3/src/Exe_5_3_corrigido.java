
import java.util.*;

public class Exe_5_3_corrigido {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);

        int ltp[] = new int[5];
        int calc[] = new int[5];
        int contLTP;
        int contCalc;
        int contMatriculaLTPeCalc = 0;
        int x = 0;


            for (contLTP = 0; contLTP <= 4; contLTP++) {
                System.out.print("Digite a matricula do aluno de LTP: ");
                ltp[contLTP] = sc.nextInt();
                if (ltp[contLTP] == 999) {
                    System.out.println("Programa Encerrado. \n");
                    break;
                }
            }

            for (contCalc = 0; contCalc <= 4; contCalc++) {
                System.out.print("Digite a matricula do aluno de Calculo: ");
                calc[contCalc] = sc.nextInt();
                if (calc[contCalc] == 999) {
                    System.out.println("Programa Encerrado. \n");
                    break;
                }

                // x para checar o vetor, ltp[contLTP] está em um valor fixo.
                for (x = 0; x < contLTP; x++){
                    if (calc[contCalc] == ltp[x]) {
                        contMatriculaLTPeCalc++;
                    }
                }
            }


            System.out.println("Alunos matriculados em LTP e Calculo: ==> " + contMatriculaLTPeCalc);



    }
}
