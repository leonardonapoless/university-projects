// Leonardo Nápoles

import java.util.Scanner;

public class Exe_9_4 {

    // MARK: - Vetor para validação das string dos meses
    private static final String[] MESES = { "01","02","03","04","05","06","07","08","09","10","11","12" };

    // MARK: - Main
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        boolean continuar = true;
        String placa;
        String dataMulta;
        float valorMulta;
        float sumVlrMulta = 0;
        float avgVlrMulta;
        float menorMulta = 0;
        int quantVlrMulta = 0;
        boolean primeiraMulta = true;

        // MARK: - Inputs
        do {
            do {
                System.out.print("Digite a placa do veiculo (ex.: GVP5566, ou 'F' para finalizar): ");
                placa = sc.next().toUpperCase();
                if (placa.equals("F")) {
                    continuar = false;
                    break;
                }
            } while (!placaIsValid(placa));
            if (!continuar) break;

            do {
                System.out.print("Digite a data da multa (DD/MM/AAAA) ou 'F' para finalizar: ");
                dataMulta = sc.next();
                if (dataMulta.equalsIgnoreCase("F")) {
                    continuar = false;
                    break;
                }
            } while (!dataIsValid(dataMulta));
            if (!continuar) break;

            do {
                System.out.print("Digite o valor da multa (ou 0 para finalizar): R$ ");
                if (!sc.hasNextFloat()) {
                    System.out.println("Valor invalido! Digite um numero.");
                    sc.next();
                    valorMulta = -1;
                } else {
                    valorMulta = sc.nextFloat();
                    if (valorMulta < 0) {
                        System.out.println("Valor invalido! Digite um numero maior ou igual a zero.");
                    }
                }
            } while (valorMulta < 0);

            if (valorMulta == 0) {
                continuar = false;
                break;
            }

            sumVlrMulta += valorMulta;
            quantVlrMulta++;
            if (primeiraMulta) {
                menorMulta = valorMulta;
                primeiraMulta = false;
            } else if (valorMulta < menorMulta) {
                menorMulta = valorMulta;
            }

        } while (continuar);

        // MARK: - Outputs
        if (quantVlrMulta > 0) {
            avgVlrMulta = sumVlrMulta / quantVlrMulta;
            System.out.println("Soma das multas: R$ " + sumVlrMulta);
            System.out.println("Valor medio das multas: R$ " + avgVlrMulta);
            System.out.println("Valor da menor multa: R$ " + menorMulta);
        } else {
            System.out.println("Nenhuma multa valida foi registrada.");
        }

        sc.close();
    }

    // MARK: - Metodos
    public static boolean placaIsValid(String placa) {
        if (placa == null || placa.length() != 7) {
            System.out.println("Placa invalida: deve ter 7 caracteres (Ex.: OAP4552)");
            return false;
        }
        for (int i = 0; i < 3; i++) {
            if (!Character.isLetter(placa.charAt(i))) {
                System.out.println("Placa invalida: os primeiros 3 caracteres devem ser letras.");
                return false;
            }
        }
        for (int i = 3; i < 7; i++) {
            if (!Character.isDigit(placa.charAt(i))) {
                System.out.println("Placa invalida: os ultimos 4 caracteres devem ser digitos.");
                return false;
            }
        }
        return true;
    }

    public static boolean dataIsValid(String data) {
        if (data == null || data.length() != 10) {
            System.out.println("Data invalida: formato deve ser DD/MM/AAAA");
            return false;
        }
        if (data.charAt(2) != '/' || data.charAt(5) != '/') {
            System.out.println("Data invalida: insira '/' nos lugares corretos (DD/MM/AAAA)");
            return false;
        }

        String diaStr = data.substring(0, 2);
        String mesStr = data.substring(3, 5);
        String anoStr = data.substring(6, 10);

        boolean mesValido = false;
        for (String m : MESES) {
            if (m.equals(mesStr)) {
                mesValido = true;
                break;
            }
        }
        if (!mesValido) {
            System.out.println("Mes invalido: deve ser entre 01 e 12.");
            return false;
        }

        int dia, mes, ano;
        try {
            dia = Integer.parseInt(diaStr);
            mes = Integer.parseInt(mesStr);
            ano = Integer.parseInt(anoStr);
        } catch (NumberFormatException e) {
            System.out.println("Data invalida: dia, mes e ano devem ser numeros.");
            return false;
        }

        if (ano < 1900 || ano > 2025) {
            System.out.println("Ano invalido: deve ser entre 1900 e 2025.");
            return false;
        }

        // validar dias de cada mes
        int maxDia;
        switch (mes) {
            case 1: case 3: case 5: case 7: case 8: case 10: case 12:
                maxDia = 31; break;
            case 4: case 6: case 9: case 11:
                maxDia = 30; break;
            case 2:
                boolean bissexto = (ano % 4 == 0 && ano % 100 != 0) || (ano % 400 == 0);
                maxDia = bissexto ? 29 : 28;
                break;
            default:
                return false;
        }

        if (dia < 1 || dia > maxDia) {
            System.out.println("Dia invalido: para " + mesStr + "/" + anoStr +
                    ", deve ser entre 1 e " + maxDia);
            return false;
        }

        return true;
    }

}
