import java.util.*;

public class Main {
    static Scanner sc = new Scanner(System.in);

    public static void main(String[]args){
        Computador computador = new Computador();
        byte opcao;

        do {
            do {
                System.out.println("-".repeat(20) + "Cadastro de Computadores" + "-".repeat(20));
                System.out.println("[1] - Incluir Computador");
                System.out.println("[2] - Alterar Computador");
                System.out.println("[3] - Consultar Computador");
                System.out.println("[4] - Excluir Computador");
                System.out.println("[0] - Sair");
                System.out.println("Digite a opção desejada: ");
                opcao = sc.nextByte();
                if (opcao < 0 || opcao > 4){
                    System.out.println("\nOpção invalida, digite novamente.\n");
                }
            } while (opcao < 0 || opcao > 4);

            switch (opcao){
                case 0:
                    System.out.println( "-".repeat(15) + "Programa encerrado." + "-".repeat(15));
                    break;
                case 1:
                    Computador.incluir();
                    break;
                case 2:
                    Computador.alterar();
                    break;
                case 3:
                    Computador.consultar();
                    break;
                case 4:
                    Computador.excluir();
                    break;
            }

        } while (opcao != 0);

        //sc.close();

    }
}