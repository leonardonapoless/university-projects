
import java.util.*;

public class Exe_4_6 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numVoo;
        int voo1 = 0;
        int voo2 = 0;
        int voo3 = 0;
        float precoVoo1 = 100;
        float precoVoo2 = 150;
        float precoVoo3 = 200;
        float valArrecVoo1 = 0;
        float valArrecVoo2 = 0;
        float valArrecVoo3 = 0;
        int passVendidas;
        float vooDescLot60;
        float vooDescLot30;
        float vooArrecMaiorValor = 0;
        float vooArrecMenorValor = 999;
        float mediaArrec3voos;

        do {

            do {
                System.out.print("Digite o numero do voo (1, 2 ou 3) [999 para sair]: ");
                numVoo = sc.nextInt();

                if(numVoo == 999){
                    break;
                }
                if (numVoo < 1 && numVoo > 3) {
                    System.out.println("Numero do voo invalido, digite 1, 2 ou 3.");
                }

                if (numVoo == 1) {
                voo1++; 
                } else if (numVoo == 2) {
                voo2++;
                } else {
                voo3++;
                }
            }while (numVoo < 1 && numVoo > 3);

            if(numVoo == 999){
                System.out.println("Programa encerrado.");
                break;
            }

            do {
                System.out.print("Digite o numero de passagens (0 a 100): ");
                passVendidas = sc.nextInt();
                if (passVendidas < 0 && passVendidas > 100) {
                    System.out.println("Numero de passagens invalido, digite um numero de 0 a 100.");
                }

                System.out.println("Numero do Voo: " + numVoo);

                if (passVendidas >= 70 && passVendidas <= 100) {

                    if (numVoo == 1) {
                        precoVoo1 = precoVoo1 - (precoVoo1 * 60 / 100);
                        System.out.println("Preco das passagens: R$" + precoVoo1);
                        vooDescLot60 = precoVoo1;
                    } else if (numVoo == 2) {
                        precoVoo2 = precoVoo2 - (precoVoo2 * 60 / 100);
                        System.out.println("Preco das passagens: R$" + precoVoo2);
                        vooDescLot60 = precoVoo1;
                    } else {
                        System.out.println("Preco das passagens: R$" + precoVoo3);
                    }

                    if (passVendidas >= 50 && passVendidas <= 69) {

                        if (numVoo == 1) {
                            precoVoo1 = precoVoo1 - (precoVoo1 * 30 / 100);
                            System.out.println("Preco das passagens: R$" + precoVoo1);
                            vooDescLot30 = precoVoo1;
                        } else if (numVoo == 2) {
                            precoVoo2 = precoVoo2 - (precoVoo2 * 30 / 100);
                            System.out.println("Preco das passagens: R$" + precoVoo2);
                            vooDescLot30 = precoVoo1;
                        } else {
                            System.out.println("Preco das passagens: R$" + precoVoo3);
                        }
                    }
                    while (passVendidas < 0 && passVendidas > 100) ;

                    valArrecVoo1 = passVendidas * voo1;
                    valArrecVoo2 = passVendidas * voo2;
                    valArrecVoo3 = passVendidas * voo3;

                    if (numVoo == 0) {
                        break;
                    }

                }

            }while (numVoo < 1 && numVoo > 3);

        }while (numVoo != 0);

        mediaArrec3voos = valArrecVoo1 + valArrecVoo2 + valArrecVoo3 / 3;
        System.out.println("Media arrecadada pelos 3 voos: R$" + mediaArrec3voos);

        if (valArrecVoo1 > vooArrecMaiorValor) {
            System.out.println("O voo 1 arrecadou o maior valor: R$: " + valArrecVoo1);
        } else if (valArrecVoo2 > vooArrecMaiorValor) {
            System.out.println("O voo 2 arrecadou o maior valor: R$: " + valArrecVoo2);
        } else {
            System.out.println("O voo 3 arrecadou o maior valor: R$: " + valArrecVoo3);
        }

        if (valArrecVoo1 < vooArrecMenorValor) {
            System.out.println("Valor da passagem mais barata R$: " + valArrecVoo1);
        } else if (valArrecVoo2 < vooArrecMenorValor) {
            System.out.println("Valor da passagem mais barata R$: " + valArrecVoo2);
        } else {
            System.out.println("Valor da passagem mais barata R$: " + valArrecVoo3);
        }
    }
}