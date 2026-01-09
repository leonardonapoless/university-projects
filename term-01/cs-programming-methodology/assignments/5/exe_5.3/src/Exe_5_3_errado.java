import java.util.*;

public class Exe_5_3_errado {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);

        int ltp[] = new int[5];
        int calc[] = new int[8];
        int contLTP = 1;
        int contCalc = 1;
        int cont2Mat = 1;

        for (int cont = 1; cont <= 5; cont++){

            do {
                System.out.print("Digite a matricula do aluno da materia LTP (999 para sair): ");
                ltp[contLTP] = sc.nextInt();
                if (contLTP == 999){
                    break;
                }
            } while (contLTP < 1 || contLTP > 5);

             do {
                System.out.print("Digite a matricula do aluno da materia Calculo (999 para sair): ");
                calc[contCalc] = sc.nextInt();
                if (contCalc == 999){
                    break;
                }
            } while (contCalc < 1 || contCalc > 8);


            for (cont2Mat = 0; cont2Mat <= 7; cont2Mat++){
                if (contLTP == contCalc){
                    cont2Mat++;
                }

            }
        }

        System.out.println("ALUNOS MATRICULADOS ");
        System.out.println("                  LTP" + "                          Calculo" + "                    " +
                "Matriculado na mesma disciplina ");
        System.out.println("                   " + contLTP + "                   " + contCalc +
                "                           " + cont2Mat);
    }
}
