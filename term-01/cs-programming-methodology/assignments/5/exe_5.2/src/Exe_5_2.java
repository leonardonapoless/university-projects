import java.util.*;

public class Exe_5_2 {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);

        byte nota;
        int freqAbsoluta[] = new int[11];
        byte cont;

        for (cont = 1; cont <= 20; cont++){
            System.out.print("Digite a nota do aluno (de 0 a 10): ");
            nota = sc.nextByte();

            freqAbsoluta[nota] = freqAbsoluta[nota] + 1;

        }
        System.out.println("        TABELA DE NOTAS E FREQUENCIA ***");
        System.out.println("            Nota                             " + "Frequencia Absoluta");
        for (cont = 0; cont <= 10; cont++){
            System.out.println("              " + cont + "                                          " + freqAbsoluta[cont]);
        }

    }
}
