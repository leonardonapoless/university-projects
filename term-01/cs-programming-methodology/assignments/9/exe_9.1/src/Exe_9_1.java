import java.util.Scanner;

public class Exe_9_1{

    // Metodo
    public static void calcularEImprimirIdade(String dataNascimento, String dataAtual) {
        String[] n = dataNascimento.split("/");
        String[] h = dataAtual       .split("/");

        int diaN = Integer.parseInt(n[0]);
        int mesN = Integer.parseInt(n[1]);
        int anoN = Integer.parseInt(n[2]);

        int diaH = Integer.parseInt(h[0]);
        int mesH = Integer.parseInt(h[1]);
        int anoH = Integer.parseInt(h[2]);

        int idade = anoH - anoN;

        if (mesH < mesN || (mesH == mesN && diaH < diaN)) {
            idade--;
        }
        System.out.println("A idade da pessoa é: " + idade + " ano(s).");
    }

    // Main
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite a data de nascimento (DD/MM/AAAA): ");
        String nasc = sc.nextLine();

        System.out.print("Digite a data atual (DD/MM/AAAA): ");
        String hoje = sc.nextLine();

        calcularEImprimirIdade(nasc, hoje);
    }
}
