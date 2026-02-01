import java.util.*; public class Main { static Scanner sc = new Scanner(System.in);

    public static void main(String[]args){
        Livro livro = new Livro();
        byte opcao;

        do {

            do {
                System.out.println("\n----------  Sistema de Gestão - Páginas de Saber  ----------");
                System.out.println("[1] - INCLUIR LIVRO");
                System.out.println("[2] - ALTERAR LIVRO");
                System.out.println("[3] - CONSULTAR LIVRO");
                System.out.println("[4] - EXCLUIR LIVRO");
                System.out.println("[0] - SAIR");
                System.out.println("Digite a opção desejada: ");
                opcao = sc.nextByte();
                if (opcao < 0 || opcao > 4) {
                    System.out.println("Opção invalida, digite novamente.");
                }
            } while (opcao < 0 || opcao > 4);

            switch (opcao){
                case 0:
                    System.out.println("\n **************** PROGRAMA ENCERRADO **************** \n");
                    break;
                case 1:
                    livro.incluir();
                case 2:
                    livro.alterar();
                case 3:
                    livro.consultar();
                case 4:
                    livro.excluir();
            }
        } while (opcao != 0);
    }

}