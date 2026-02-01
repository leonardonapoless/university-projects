// Leonardo Napoles

import java.util.*;

public class Exe_3_3 {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);

        char tipoVinho = ' ';
        int cont = 0;
        int quantTotal;
        int quantC = 0;
        int quantM = 0;
        int quantT = 0;


            while (cont >= 0){
                System.out.print("Digite um tipo de vinho C, M ou T \n" +
                        "(Cabernet Sauvion, Malbec, Tanat) ou F para encerrar: ");
                tipoVinho = sc.next().charAt(0);
                if (tipoVinho == 'F'){
                    break;
                }
                cont++;

                if (tipoVinho == 'C'){
                    quantC++;
                } else if (tipoVinho == 'M'){
                    quantM++;
                } else {
                    quantT++;
                }
            }


            System.out.println("A quantidade total de vinhos em estoque e: " + cont);
            System.out.println("A quantidade de Cabernet Savion e: " + quantC);
            System.out.println("A quantidade de Malbec e: " + quantM);
            System.out.println("A quantidade de Tanat e: " + quantT);

        }
    }
