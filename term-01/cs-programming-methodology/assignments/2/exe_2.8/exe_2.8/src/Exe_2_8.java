// Leonardo Nápoles

import java.util.*;

public class Exe_2_8 {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        float tempoCasa;
        float salario;
        float bonusSal = 0;
        float valeTransp = 0;
        float salarioTotal;

        System.out.println("Bem vindo(a) a ABCDario LTDA! \n" +
                "Calculo de Bonus Salarial e Desconto de Vale Transporte ↓");
        System.out.print("Digite o tempo de casa do empregado em anos (ex.: 1, 4, 6): ");
        tempoCasa = sc.nextFloat();
        System.out.print("Digite o salario do empregado: R$");
        salario = sc.nextFloat();

        if (tempoCasa <= 5 && (salario <= 300)){
            bonusSal = 50;
            valeTransp = salario * 5 / 100;
        } else if (tempoCasa <= 5 && (salario > 300)){
            bonusSal = 80;
            valeTransp = salario * 6 / 100;
        } else if (tempoCasa >= 6 && tempoCasa <= 10 && (salario <= 500)){
            bonusSal = salario * 15 / 100;
            valeTransp = 70;
        } else if (tempoCasa >= 6 && (tempoCasa <= 10) && (salario > 500)
            && (salario <= 2000)){
            bonusSal = salario * 13 / 100;
            valeTransp = 90;
        } else if (tempoCasa >= 6 && (tempoCasa <= 10) && (salario > 2000)){
            bonusSal = salario * 12 / 100;
            valeTransp = salario * 8 / 100;
        } else if (tempoCasa > 10){
            bonusSal = 300;
            valeTransp = salario * 4 / 100;
        }

        salarioTotal = salario + bonusSal;

        System.out.println("\n" + "O Bonus Salarial do empregado e de: R$" + bonusSal + "\n" +
                "Salario total do empregado: R$" + salarioTotal);
        System.out.println("O desconto de Vale Transporte e de: R$" + valeTransp);

    }
}