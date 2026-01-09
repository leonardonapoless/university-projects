// Leonardo Nápoles

import java.util.*;

public class Exe_2_6 {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);

        int lado1;
        int lado2;
        int lado3;

        System.out.print("Digite o valor do primeiro lado: ");
        lado1 = sc.nextInt();
        System.out.print("Digite o valor do segundo lado: ");
        lado2 = sc.nextInt();
        System.out.print("Digite o valor do terceiro lado: ");
        lado3 = sc.nextInt();

        if (lado1 + lado2 <= lado3 || (lado1 + lado3 <= 2) || (lado2 + lado2 <= lado1)){
            System.out.println("Não é um triangulo.");
        } else if (lado1 == lado2 && lado1 == lado3){
            System.out.println("Triangulo equilatero.");
        } else if (lado1 == lado2 || lado2 == lado3 || lado1 == lado3){
            System.out.println("Triangulo isosceles");
        } else {
            System.out.println("Triangulo escaleno.");
        }



    }
}
