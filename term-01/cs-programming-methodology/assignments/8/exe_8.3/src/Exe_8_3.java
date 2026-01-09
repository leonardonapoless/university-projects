import java.util.Scanner;

public class Exe_8_3 {

    static String[] cidadeHotelValida = {
            "BELO HORIZONTE", "SAO PAULO", "RIO DE JANEIRO", "SALVADOR", "CURITIBA"
    };
    static String[] tipoQuartoValido = {
            "STANDARD", "LUXO", "SUPER-LUXO"
    };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String[] nomeHospede = new String[100];
        String[] tipoQuartoHospede = new String[100];
        String[] cidadeHospede = new String[100];
        int[] diaEntradaHospede = new int[100];
        int[] diaSaidaHospede = new int[100];
        float[] valorConta = new float[100];
        int contHospedes = 0;
        int diaEntrada;
        int diaSaida;
        String tipoQuartoDigitado;
        String cidadeDigitada;
        String nome;
        int i;
        float soma = 0f;
        float media = 0f;

        for (i = 0; i < 100; i++) {
            System.out.print("Digite o nome do hospede ('F' para encerrar): ");
            nome = sc.nextLine();
            if (nome.equalsIgnoreCase("F")) {
                break;
            }
            nomeHospede[i] = nome;

            do {
                System.out.print("Digite o dia da entrada do hospede (1-30): ");
                diaEntrada = sc.nextInt();
                sc.nextLine(); // Consumir a quebra de linha
            } while (diaEntrada < 1 || diaEntrada > 30);
            diaEntradaHospede[i] = diaEntrada;

            do {
                System.out.print("Digite o dia da saida do hospede (maior que entrada, até 30): ");
                diaSaida = sc.nextInt();
                sc.nextLine(); // Consumir a quebra de linha
            } while (diaSaida <= diaEntrada || diaSaida > 30);
            diaSaidaHospede[i] = diaSaida;

            do {
                System.out.print("Digite o tipo de quarto (STANDARD, LUXO ou SUPER-LUXO): ");
                tipoQuartoDigitado = sc.nextLine();
            } while (!quartoIsValid(tipoQuartoDigitado));
            tipoQuartoHospede[i] = tipoQuartoDigitado;

            do {
                System.out.print("Digite a cidade do hotel: ");
                cidadeDigitada = sc.nextLine();
            } while (!cidadeIsValid(cidadeDigitada));
            cidadeHospede[i] = cidadeDigitada;

            valorConta[i] = CalcValor(tipoQuartoDigitado, diaEntrada, diaSaida);
            soma = soma + valorConta[i];
            contHospedes = contHospedes + 1;
        }

        if (contHospedes != 0) {
            media = soma / contHospedes;
        }

        System.out.println("\nRelatório de contas acima da média:");
        System.out.println("Nome do Hospede          Valor da Diaria");
        System.out.println("----------------------------------------");
        for (i = 0; i < contHospedes; i++) {
            if (valorConta[i] >= media) {
                System.out.println(nomeHospede[i] + "                    R$ " + valorConta[i]);
            }
        }

        sc.close();
    }

    public static boolean cidadeIsValid(String cidade) {
        int i;
        for (i = 0; i < 5; i++) {
            if (cidadeHotelValida[i].equalsIgnoreCase(cidade)) {
                return true;
            }
        }
        return false;
    }

    public static boolean quartoIsValid(String quarto) {
        int i;
        for (i = 0; i < 3; i++) {
            if (tipoQuartoValido[i].equalsIgnoreCase(quarto)) {
                return true;
            }
        }
        return false;
    }

    public static float CalcValor(String quarto, int diaEntrada, int diaSaida) {
        float valorDiaria;
        if (quarto.equalsIgnoreCase("STANDARD")) {
            valorDiaria = 120f;
        } else if (quarto.equalsIgnoreCase("LUXO")) {
            valorDiaria = 150f;
        } else {
            valorDiaria = 180f;
        }
        return (diaSaida - diaEntrada) * valorDiaria;
    }
}
