// Leonardo Nápoles

import java.util.*;

public class Exe_1_6 {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        float taxa;
        float valorDepositado;
        float totalDescontado;
        float saldo;
        float valorCheque1;
        float valorCheque2;
        float taxaCheque1;
        float taxaCheque2;

        System.out.print("Digite o valor depositado: R$");
        valorDepositado = sc.nextFloat();

        System.out.print("Digite o valor do primeiro cheque: R$");
        valorCheque1 = sc.nextFloat();

        System.out.print("Digite o valor do segundo cheque: R$");
        valorCheque2 = sc.nextFloat();

        taxa = (float) (1 * 0.2);

        taxaCheque1 = valorCheque1 - taxa;
        taxaCheque2 = valorCheque2 - taxa;

        totalDescontado = valorCheque1 + taxaCheque1 + valorCheque2 + taxaCheque2;
        saldo = valorDepositado - totalDescontado;


        System.out.println("Saldo final: R$" + saldo);



    }
}
