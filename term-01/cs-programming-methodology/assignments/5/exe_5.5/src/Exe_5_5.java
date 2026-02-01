import java.util.*;
public class Exe_5_5 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int nota;
        char sexo;
        String nomeAluno;
        byte contReprovFem = 0;
        byte contAprovMasc = 0;
        byte contFem = 0;
        int somaNotasFem = 0;
        int somaNotas = 0;
        int notaAprovados[] = new int[50];
        String nomeAprovados[] = new String[50];
        byte contAprovados = 0;



        for (byte cont = 0; cont <= 49; cont++ ) {
            System.out.print("Digite o nome do aluno: ");
            nomeAluno = sc.nextLine();

            do {
                System.out.print("Digite a nota: ");
                nota = sc.nextInt();
                if (nota < 0 || nota > 100) {
                    System.out.println("Nota invalida, digite de 0 a 100");
                }
            }while(nota < 0 || nota > 100);

            do {
                System.out.print("Digite o sexo: ");
                sexo = sc.next().toUpperCase().charAt(0);
                if (sexo != 'M' && sexo != 'F') {
                    System.out.println("Sexo invalido, digite M ou F");
                }
            } while (sexo != 'M' && sexo != 'F');



            if (nota >= 60) {
                System.out.println("Aluno Aprovado!");
                if (sexo == 'M') {
                    contAprovMasc ++;
                }
                nomeAprovados[contAprovados] = nomeAluno;
                notaAprovados[contAprovados] = nota;
                contAprovados ++;

            } else {
                System.out.println("Aluno Reprovado!");
                if (sexo == 'F') {
                    contReprovFem ++;
                }
            }

            if (sexo == 'F') {
                contFem ++;
                somaNotasFem = somaNotasFem + nota;
            }
            somaNotas = somaNotas + nota;

            sc.nextLine();
        }

        System.out.println("Numero de aprovados do sexo masculino: " + contAprovMasc);
        System.out.println("Numero de reprovados do sexo feminino: " + contReprovFem);
        if (contFem > 0) {
            System.out.println("Media notas sexo feminino: " + somaNotasFem / contFem);
        }
        System.out.println("Media geral de notas: " + somaNotas / 50f);

        System.out.println("RELATORIO DE APROVADOS");
        System.out.println("  NOME     NOTA");
        for (byte x = 0; x < contAprovados; x++ ) {
            System.out.println(nomeAprovados[x] + "          " + notaAprovados[x]);
        }
    }

}
