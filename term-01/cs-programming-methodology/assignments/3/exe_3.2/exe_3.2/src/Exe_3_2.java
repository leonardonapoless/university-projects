// Leonardo Napoles

import java.util.*;

public class Exe_3_2 {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite um numero inteiro para calcular o fatorial: ");
        int numero = sc.nextInt();
        int contador = numero;
        long fatorial = 1;

        while(contador > 0){
            fatorial = fatorial * contador;
            contador--;
        }

        System.out.println("O fatorial do numero '" + numero + "'" + " e: " +
                fatorial);
    }
}