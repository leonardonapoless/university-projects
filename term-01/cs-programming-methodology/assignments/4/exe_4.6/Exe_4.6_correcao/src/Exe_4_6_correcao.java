
import java.util.*;

public class Exe_4_6_correcao {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);

        byte numVoo = 0;
        byte quantPassagens = 0;
        float precoPassagem;
        float valorArrecadadoVoo;
        float maiorVlrArrecadVoo = 0;
        byte numVooMaiorVlrArrec = 0;
        float somaVlrArrecadVoo = 0;
        float menorPrecoPassagem = 200;
        byte numVooMenorPrecoPass = 0;

        for (byte cont = 1; cont <= 3; cont++) {

            do {
                System.out.print("Digite o numero do voo: ");
                numVoo = sc.nextByte();
                if (numVoo < 1 || numVoo > 3) {
                    System.out.println("Numero invalido, digite 1, 2 ou 3.");
                }
            } while (numVoo < 1 || numVoo > 3);

            do {
                System.out.print("Digite a quantidade de passagens vendidas: ");
                quantPassagens = sc.nextByte();
                if (quantPassagens < 0 || quantPassagens > 100) {
                    System.out.println("Quantidade invalida, digite entre 0 a 100.");
                }
            } while (quantPassagens < 0 || quantPassagens > 100);


            if (numVoo == 1) {
                precoPassagem = 100;
            } else if (numVoo == 2) {
                precoPassagem = 150;
            } else {
                precoPassagem = 200;
            }

            if (quantPassagens >= 70) {
                precoPassagem = precoPassagem - 0.60f * precoPassagem;
            } else if (quantPassagens >= 50) {
                precoPassagem = precoPassagem - 0.30f * precoPassagem;
            }

            valorArrecadadoVoo = precoPassagem * quantPassagens;
            if (valorArrecadadoVoo > maiorVlrArrecadVoo) {
                maiorVlrArrecadVoo = valorArrecadadoVoo;
                numVooMaiorVlrArrec = numVoo;
            }
            somaVlrArrecadVoo = somaVlrArrecadVoo + valorArrecadadoVoo;

            if (precoPassagem < menorPrecoPassagem) {
                menorPrecoPassagem = precoPassagem;
                numVooMenorPrecoPass = numVoo;
            }

            System.out.println("Preco da passagem no voo " + numVoo + ": " + precoPassagem);
        }

        System.out.println("Numero do voo que arrecadou o maior valor: " + numVooMaiorVlrArrec);
        System.out.println("Maior valor arrecadado: " + maiorVlrArrecadVoo);
        System.out.println("Media de arrecadacao por voo: " + somaVlrArrecadVoo / 3);
        System.out.println("Valor da passagem mais barata: " + menorPrecoPassagem);
        System.out.println("Numero do voo que teve o menor preco de passagem: " + numVooMenorPrecoPass);
    }
}
