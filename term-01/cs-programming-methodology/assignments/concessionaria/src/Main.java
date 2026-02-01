// concessionaria/src/Main.java

import java.util.Scanner;

public class Main {

    public static Scanner leia = new Scanner(System.in);

    public static void main(String[] args) {

        // --- Declaração de Variáveis ---
        Veiculo veiculo;
        int opcao;

        // --- Início da Lógica ---
        veiculo = new Veiculo();

        do {
            System.out.println("\n--- CONCESSIONÁRIA --- MENU PRINCIPAL ---");
            System.out.println("[1] Incluir Veículo");
            System.out.println("[2] Alterar Veículo");
            System.out.println("[3] Excluir Veículo");
            System.out.println("[4] Consultar Veículos");
            System.out.println("[0] Sair");
            System.out.print("Digite a opção desejada: ");

            try {
                opcao = Integer.parseInt(leia.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Erro: Por favor, digite um número válido.");
                opcao = -1;
            }

            switch (opcao) {
                case 1:
                    veiculo.incluir();
                    break;
                case 2:
                    veiculo.alterar();
                    break;
                case 3:
                    veiculo.excluir();
                    break;
                case 4:
                    veiculo.consultar();
                    break;
                case 0:
                    System.out.println("Programa encerrado.");
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
            }

        } while (opcao != 0);

        leia.close();
    }
}