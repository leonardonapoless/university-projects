import java.util.*;

public class Exe_1_3 {
    public static void main(String []args){
        Scanner sc = new Scanner(System.in);
        float valorDinheiro;
        float taxaJuros;
        float valorRendimento;
        float valorTotal;

        System.out.print("Digite o valor a ser colocado na aplicação financeira: R$");
        valorDinheiro = sc.nextFloat();

        System.out.print("Digite o valor da taxa de juros: %");
        taxaJuros = sc.nextFloat();

        valorRendimento = valorDinheiro * taxaJuros / 100;

        valorTotal = valorDinheiro + valorRendimento;

        System.out.println("O valor recebido como rendimento é: R$" + valorRendimento);
        System.out.println("O valor total após o rendimento é: R$" + valorTotal);
    }
}
