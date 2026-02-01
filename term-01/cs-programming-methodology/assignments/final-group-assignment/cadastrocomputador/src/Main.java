import java.util.*;
public class Main {
    static Scanner leia = new Scanner(System.in);

    public static void main(String[] args) {
        Computador computador = new Computador();
        byte opcao;

        do {
            do {
                System.out.println("\n *************** CADASTRO DE COMPUTADORES  ***************** ");
                System.out.println(" [1] INCLUIR COMPUTADOR ");
                System.out.println(" [2] ALTERAR COMPUTADOR");
                System.out.println(" [3] CONSULTAR COMPUTADOR ");
                System.out.println(" [4] EXCLUIR COMPUTADOR ");
                System.out.println(" [0] SAIR");
                System.out.print("\nDigite a opcao desejada: ");
                opcao = leia.nextByte();
                if (opcao < 0 || opcao > 4) {
                    System.out.println("opcao Invalida, digite novamente.\n");
                }
            }while (opcao < 0 || opcao > 4);

            switch (opcao) {
                case 0:
                    System.out.println("\n ************ PROGRAMA ENCERRADO  ************** \n");
                    break;
                case 1:
                    computador.incluir();
                    break;
                case 2:
                    computador.alterar();
                    break;
                case 3:
                    computador.exibirRelatorio();
                    break;
                case 4:
                    computador.excluir();
                    break;

            }
        } while ( opcao != 0 );
        //leia.close();
    }

}