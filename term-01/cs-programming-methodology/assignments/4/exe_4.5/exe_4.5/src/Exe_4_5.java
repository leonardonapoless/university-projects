import java.util.*;

public class Exe_4_5 {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);

        String jogada1;
        String jogada2;

        do {
            System.out.print("Digite a jogada do jogador 1: ");
            jogada1 = sc.next();
            System.out.print("Digite a jogada do jogador 2: ");
            jogada2 = sc.next();

            if (!jogada1.equals("pedra") && !jogada1.equals("papel") && !jogada1.equals("tesoura") &&
                    !jogada2.equals("pedra") && !jogada2.equals("papel") && !jogada2.equals("tesoura")){
                System.out.println("Jogo terminado.");
                break;
            }

            if (jogada1.equals(jogada2)){
                System.out.println("Empate!");
            } else if (jogada1.equals("pedra") && jogada2.equals("tesoura") ||
                jogada1.equals("tesoura") && jogada2.equals("papel") ||
                jogada1.equals("papel") && jogada2.equals("pedra")) {
                System.out.println("Jogador 1 venceu o jogo!");
            } else {
                System.out.println("Jogador 2 venceu o jogo!");
            }

        } while (true);
    }
}