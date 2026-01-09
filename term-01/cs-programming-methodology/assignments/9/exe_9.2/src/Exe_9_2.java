import java.util.*;

public class Exe_9_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String codigo = "";
        boolean valido = false;
        boolean sair = false;

        while (!valido) {
            System.out.print("Digite um codigo de 11 dígitos (ou 'sair' para encerrar): ");
            codigo = sc.nextLine();

            if (codigo.equals("sair")) {
                sair = true;
                valido = true;
            } else {
                if (codigo.length() != 11) {
                    System.out.println("Erro: devem ser exatamente 11 caracteres.");
                } else {
                    boolean todosDigitos = true;
                    for (int i = 0; i < 11; i++) {
                        if (Character.digit(codigo.charAt(i), 10) < 0) {
                            todosDigitos = false;
                            break;
                        }
                    }
                    if (!todosDigitos) {
                        System.out.println("Erro: todos os caracteres devem ser digitos (0–9).");
                    } else {
                        valido = true;
                    }
                }
            }
        }

        if (sair) {
            System.out.println("Programa encerrado.");
        } else {
            int digInfo1 = Character.digit(codigo.charAt(9), 10);
            int digInfo2 = Character.digit(codigo.charAt(10), 10);

            int digCalc1 = calculaPrimeiro(codigo);
            int digCalc2 = calculaSegundo(codigo);

            if (digInfo1 == digCalc1 && digInfo2 == digCalc2) {
                System.out.println("Digito Correto");
            } else {
                System.out.println("Dígito Invalido");
            }
        }
        sc.close();
    }

    // Mark: - Metodo parte inteira
    private static int calculaPrimeiro(String s) {
        int soma = 0;
        for (int i = 0; i < 9; i++) {
            soma += Character.digit(s.charAt(i), 10);
        }
        return soma / 10;
    }

    // Mark: - Metodo ultimo digito
    private static int calculaSegundo(String s) {
        int prod = 1;
        for (int i = 0; i < 9; i++) {
            prod *= Character.digit(s.charAt(i), 10);
        }
        int parteInteira = prod / 10;
        return prod - parteInteira * 10;
    }
}
