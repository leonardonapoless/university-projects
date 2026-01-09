// Leonardo Nápoles

import java.util.*;

public class Exe_2_2 {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);

        int idade;
        int anoNascimento;
        byte mesNascimento;
        byte diaNascimento;
        int anoAtual;
        byte mesAtual;
        byte diaAtual;

        System.out.print("Digite o ano do seu nascimento (ex.: 2002, 1984): ");
        anoNascimento = sc.nextInt();
        System.out.print("Digite o mês do seu nascimento (ex.: 8, 11, 4): ");
        mesNascimento = sc.nextByte();
        System.out.print("Digite o dia do seu nascimento (ex.: 29, 3, 11): ");
        diaNascimento = sc.nextByte();

        System.out.print("Digite o ano atual (ex.: 2020, 2025): ");
        anoAtual = sc.nextInt();
        System.out.print("Digite o mês atual (ex.: 8, 11, 4): ");
        mesAtual = sc.nextByte();
        System.out.print("Digite o dia atual (ex.: 29, 3, 11): ");
        diaAtual = sc.nextByte();

        idade = anoAtual - anoNascimento;

        if(mesAtual < mesNascimento && diaAtual < diaNascimento ||
                (mesAtual == mesNascimento && diaAtual < diaNascimento)){
            idade = idade - 1;
        }

        System.out.println("A idade é: " + idade);

    }
}
