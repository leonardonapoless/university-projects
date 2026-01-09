
import java.util.*;

public class exe_1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int nota1;
        int nota2;
        int nota3;
        int somaNotas;
        int mediaNotas;
        String nomeAluno;

        System.out.print("Digite o nome do aluno: ");
        nomeAluno = scanner.nextLine();

        System.out.print("Digite a primeira nota: ");
        nota1 = scanner.nextInt();

        System.out.print("Digite a segunda nota: ");
        nota2 = scanner.nextInt();

        System.out.print("Digite a terceira nota: ");
        nota3 = scanner.nextInt();

        somaNotas = nota1 + nota2 + nota3;
        mediaNotas = somaNotas / 3;

        System.out.println("Nome do aluno: " + nomeAluno + "\n" +
                "Nota 1: " + nota1 + "\n" +
                "Nota 2: " + nota2 + "\n" +
                "Nota 3: " + nota3 + "\n" +
                "Media de notas: " + mediaNotas
        );
    }
}
