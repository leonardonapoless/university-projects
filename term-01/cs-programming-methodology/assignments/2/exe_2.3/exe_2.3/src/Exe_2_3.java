// Leonardo Nápoles

import java.util.*;

public class Exe_2_3 {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        String nome;
        float salario;
        float novoSalario;

        System.out.print("Empresa ABC" + "\n" + "Digite o nome do empregado: ");
        nome = sc.nextLine();
        System.out.print("Digite o salario do empregado: R$");
        salario = sc.nextFloat();

        if(salario < 1000){
            salario = salario + (salario / 100 * 15);
        } else {
            salario = salario + (salario / 100 * 10);
        }

        novoSalario = salario;

        System.out.println("O novo salario do empregrado " + nome + " é: R$" + novoSalario);
    }
}
