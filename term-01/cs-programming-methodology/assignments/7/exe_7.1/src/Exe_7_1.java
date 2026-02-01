import java.util.Scanner;

public class Exe_7_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String[] cidades = new String[20];
        int[] distBH = new int[20];
        int contCidades = 0;
        int cont = 0;
        int indexCidade = 0;
        String nome = "";
        String busca = "";
        int distancia = 0;
        int tempo = 0;
        int escalas = 0;
        float preco = 0f;
        boolean encontrou = false;

        for (cont = 0; cont < 20; cont++) {
            do {
                System.out.print("Digite o nome da cidade (ou 'FIM'): ");
                nome = sc.nextLine();
                if (nome.equalsIgnoreCase("FIM")) {
                    break;
                }
                if (nome.equals("")) {
                    System.out.println("Nome da cidade obrigatorio.");
                    cont--;
                    continue;
                }
                cidades[cont] = nome;
                } while (nome.equalsIgnoreCase("FIM"));
                if (nome.equalsIgnoreCase("FIM")) {
                    break;
                }
            do {
                System.out.print("Digite a distancia ate BH (500 km ou mais): ");
                distancia = sc.nextInt();
                sc.nextLine();
                if (distancia < 500) {
                    System.out.println("Distancia invalida.");
                }
            } while (nome.equalsIgnoreCase("FIM"));
            distBH[cont] = distancia;
            contCidades++;
        }

            while (true) {
                System.out.print("Pesquise uma cidade (ou 'sair'): ");
                busca = sc.nextLine();
                if (busca.equalsIgnoreCase("sair")) {
                    break;
                }
                encontrou = false;
                indexCidade = -1;
                for (cont = 0; cont < contCidades; cont++) {
                    if (cidades[cont].equalsIgnoreCase(busca)) {
                        encontrou = true;
                        indexCidade = cont;
                        break;
                    }
                }
                if (!encontrou) {
                    System.out.println("Cidade nao encontrada. \n");
                } else {
                    distancia = distBH[indexCidade];
                    preco = distancia * 0.25f;
                    tempo = (distancia * 60) / 800;
                    escalas = tempo / 180;
                    System.out.println("Preco: R$ " + preco + "\n");
                    System.out.println("Tempo: " + tempo + "\n");
                    System.out.println("Escalas: " + escalas + "\n");
                }

            }
    }
}
