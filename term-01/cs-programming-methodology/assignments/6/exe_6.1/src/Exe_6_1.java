import java.util.*;

public class Exe_6_1 {
    public static String inicialMaiuscula(String nomePassageiro){
        return nomePassageiro.substring(0,1).toUpperCase() + nomePassageiro.substring(1);
    }
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);

        String[][] assentoPassageiro = new String[20][6];
        byte contFileira;
        byte contCadeira;
        String nomePassageiro = "";
        float valorPass1aClasse = 0;
        float valorPassClasseExe = 0;
        float valorPassClasseCom = 0;
        float totalFaturado;
        byte assentosVagos = 0;

            for (contFileira = 0; contFileira <= 19; contFileira++){
                    while (true){
                    System.out.print("Digite o nome do passageiro (ou 'F' para encerrar): ");
                    nomePassageiro = sc.nextLine();
                    nomePassageiro = inicialMaiuscula(nomePassageiro);
                    if (nomePassageiro.equals("F")){
                        break;
                    }

                    do {
                        System.out.print("Digite a fileira do assento do passageiro: ");
                        contFileira = sc.nextByte();

                        if (contFileira < 1 || contFileira > 20) {
                            System.out.println("Numero da fileira invalido, digite de 1 a 20");
                            contFileira--;
                        }
                    } while (contFileira < 1 || contFileira > 20);

                    do {
                        System.out.print("Digite a cadeira do passageiro: ");
                        contCadeira = sc.nextByte();

                        if (contCadeira < 1 || contCadeira > 6) {
                            System.out.println("Numero da cadeira invalido, digite de 1 a 6");
                            contCadeira--;
                        }
                    } while (contCadeira < 1 || contCadeira > 6);

                        sc.nextLine();

                        if (assentoPassageiro[contFileira-1][contCadeira-1] != null){
                            System.out.println("Assento ocupado. Tente outro.");
                            continue;
                        }
                        assentoPassageiro[contFileira - 1][contCadeira - 1] = nomePassageiro;

                        if (contFileira >= 1 && contFileira <= 3) {
                            valorPass1aClasse = valorPass1aClasse + 900;
                        } else if (contFileira >= 4 && contFileira <= 8) {
                            valorPassClasseExe = valorPassClasseExe + 700;
                        } else {
                            valorPassClasseCom = valorPassClasseCom + 350;
                        }
                    }

                for (byte x = 0; x < 20; x++){
                    if (assentoPassageiro[x][0] == null){
                        assentosVagos++;
                    }
                    if (assentoPassageiro[x][5] == null){
                        assentosVagos++;
                    }
                }

                if (nomePassageiro.equals("F")){
                        break;
                    }

            }

        totalFaturado = valorPass1aClasse + valorPassClasseExe + valorPassClasseCom;

        System.out.println("\n     Mapa de assentos do voo:");
        for (byte c = 1; c < 7; c++){ // numero das cadeiras
            if (c == 1){
                System.out.print("---| " + c);
            } else if (c == 6){
                System.out.print("---| ");
            } else {
                System.out.print("--| " + c);
            }
        }

        System.out.println();
        int tamanhoString = nomePassageiro.length();
        for (contFileira = 0; contFileira < 20; contFileira++){
            if (contFileira < 9){
                System.out.print(" " + (contFileira + 1) + " | ");
            }else {
                System.out.print((contFileira + 1) + " | ");
            }
            for (contCadeira = 0; contCadeira < 6; contCadeira++){
                if (assentoPassageiro[contCadeira][contCadeira] == null){
                    System.out.print("----" + " " );
                } else if (tamanhoString == 1) {
                        System.out.print(assentoPassageiro[contFileira][contCadeira] + "  ");
                } else if (tamanhoString == 0) {
                        System.out.print(assentoPassageiro[contFileira][contCadeira] + "    ");
                } else {
                        System.out.print(assentoPassageiro[contFileira][contCadeira]);
                }
            }
            System.out.println();
        }


        }

        System.out.println("---------------------------------------");
        System.out.println("Total faturado no voo: R$" + totalFaturado);
        System.out.println("Total faturado na 1ª classe: R$" + valorPass1aClasse);
        System.out.println("Numero de assentos vagos nas janelas: " + assentosVagos);
    }
}
