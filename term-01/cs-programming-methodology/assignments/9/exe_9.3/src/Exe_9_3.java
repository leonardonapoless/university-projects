import java.util.*;

public class Exe_9_3 {

    static final int[] horaInicio = { 0, 6, 8, 18 };
    static final int[] horaFim = { 5, 7, 17, 23 };
    static final float[] tarifas = { 0.10f, 0.15f, 0.20f, 0.15f };

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String horarioInicial;
        String horarioFinal;
        String horarioInicialHoras;
        String horarioInicialMins;
        String horarioFinalHoras;
        String horarioFinalMins;
        int minInicial;
        int minFinal;
        int duracao;
        float custo;
        boolean continuar = true;

        while (continuar) {
            System.out.print("Digite a hora do horario inicial da chamada (ou 'F' para sair): ");
            horarioInicialHoras = sc.next();
            if (horarioInicialHoras.equalsIgnoreCase("F")) {
                continuar = false;
                break;
            }

            if (!horaIsValid(horarioInicialHoras)) {
                System.out.println("Horario invalido. Deve estar entre 00 e 23.");
                continue;
            }

            System.out.print("Digite os minutos do horario inicial da chamada (ou 'F' para sair): ");
            horarioInicialMins = sc.next();
            if (horarioInicialMins.equalsIgnoreCase("F")) {
                continuar = false;
                break;
            }

            if (!minutoIsValid(horarioInicialMins)) {
                System.out.println("Minutos invalidos. Deve estar entre 00 e 59.");
                continue;
            }

            System.out.print("Digite a hora do horario final da chamada (ou 'F' para sair): ");
            horarioFinalHoras = sc.next();
            if (horarioFinalHoras.equalsIgnoreCase("F")) {
                continuar = false;
                break;
            }

            if (!horaIsValid(horarioFinalHoras)) {
                System.out.println("Horario invalido. Deve estar entre 00 e 23.");
                continue;
            }

            System.out.print("Digite os minutos do horario final da chamada (ou 'F' para sair): ");
            horarioFinalMins = sc.next();
            if (horarioFinalMins.equalsIgnoreCase("F")) {
                continuar = false;
                break;
            }

            if (!minutoIsValid(horarioFinalMins)) {
                System.out.println("Minutos invalidos. Deve estar entre 00 e 59.");
                continue;
            }

            horarioInicial = horarioInicialHoras + ":" + horarioInicialMins;
            horarioFinal = horarioFinalHoras + ":" + horarioFinalMins;

            minInicial = paraMinutos(horarioInicial);
            minFinal = paraMinutos(horarioFinal);

            if (minFinal <= minInicial) {
                System.out.println("Horario final deve ser após o inicial.");
                continue;
            }

            duracao = minFinal - minInicial;
            custo = calcCustoChamada(horarioInicial, duracao);

            System.out.println("--------------------------");
            System.out.println("Duração: " + duracao + " min.");
            System.out.printf("Custo total: R$ %.2f\n", custo);
            System.out.println("--------------------------");
        }

        System.out.println("Programa encerrado.");
        sc.close();
    }

    public static boolean horaIsValid(String s) {
        if (s == null || s.length() != 2) return false;
        try {
            int hh = Integer.parseInt(s);
            return hh >= 0 && hh <= 23;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static boolean minutoIsValid(String s) {
        if (s == null || s.length() != 2) return false;
        try {
            int mm = Integer.parseInt(s);
            return mm >= 0 && mm <= 59;
        } catch (NumberFormatException e) {
            return false;
        }
    }

    public static int paraMinutos(String s) {
        int hh = Integer.parseInt(s.substring(0, 2));
        int mm = Integer.parseInt(s.substring(3, 5));
        return hh * 60 + mm;
    }

    public static float calcCustoChamada(String horaInicioStr, int duracaoMin) {
        int hh = Integer.parseInt(horaInicioStr.substring(0, 2));
        float tarifa = 0;
        for (int i = 0; i < horaInicio.length; i++) {
            if (hh >= horaInicio[i] && hh <= horaFim[i]) {
                tarifa = tarifas[i];
                break;
            }
        }
        return tarifa * duracaoMin;
    }
}