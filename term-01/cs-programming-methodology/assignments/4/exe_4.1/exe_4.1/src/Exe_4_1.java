// Leonardo Napoles

import java.util.*;

public class Exe_4_1 {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);

        String nomeEmp;
        float salario;
        float novoSalario;
        float mediaNovoSalario;
        float sumNovoSalario = 0;
        int salarioAcima1700 = 1700;
        byte contAcima1700 = 0;
        byte numDep = 0;

        for (byte cont = 1; cont <= 10; cont++) {
            System.out.print("Digite o nome do empregado: ");
            nomeEmp = sc.next();
            System.out.print("Digite o salario do empregado: ");
            salario = sc.nextFloat();
            System.out.print("Digite o numero de dependentes do empregado: ");
            numDep = sc.nextByte();

        if (salario > 1000){
            novoSalario = salario * 1.30f;
        } else if (salario <= 2000) {
            novoSalario = salario * 1.20f;
        } else {
            novoSalario = salario * 1.10f;
        }

        novoSalario = novoSalario + 50 + numDep;
        sumNovoSalario = sumNovoSalario + novoSalario;

        if (novoSalario > 1700){
            contAcima1700++;
        }

            System.out.println("Soma dos novos salarios: " + novoSalario);
            sc.nextLine();
        }

        System.out.println("Soma dos novos salarios: " + sumNovoSalario);
        System.out.println("Media dos novos salarios: " + sumNovoSalario / 10);
        System.out.println("Numero de empregados que passaram a receber acima de R$1700: " + contAcima1700);



    }
}

