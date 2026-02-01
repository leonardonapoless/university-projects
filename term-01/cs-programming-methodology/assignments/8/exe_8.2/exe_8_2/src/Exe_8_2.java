import java.util.*;

public class Exe_8_2 {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);

        String nome[] = new String[100];
        int codEmp;
        int numPecas;
        int contNome;
        float mediaSalarios;
        float totalSalarios = 0;
        float salarioEmp[] = new float[100];
        int quantEmp = 0;

        for (contNome = 0; contNome < 100; contNome++){
            do {
                System.out.print("Digite o nome do empregado ('F' para encerrar): ");
                nome[contNome] = sc.nextLine();
                if (nome[contNome].equalsIgnoreCase("F")){
                    break;
                }
            } while (nome[contNome].equalsIgnoreCase("F"));
            if (nome[contNome].equalsIgnoreCase("F")){
                break;
            }
            do {
                System.out.print("Digite o codigo do empregado: ");
                codEmp = sc.nextInt();
                if (codEmp < 1 || codEmp > 999){
                    System.out.println("Codigo invalido, digite entre 1 e 999.");
                    codEmp--;
                }
            }while (codEmp < 1 || codEmp > 999);

            do {
                System.out.print("Digite o numero de pecas fabricadas no mes: ");
                numPecas = sc.nextInt();
                if (numPecas == 0){
                    System.out.println("Numero de pecas invalido, digite um numero maior que zero.");
                    numPecas--;
                }
            }while (numPecas < 1);

            sc.nextLine();

            salarioEmp[quantEmp] = calcSalario(numPecas);
            totalSalarios = totalSalarios + salarioEmp[quantEmp];
            quantEmp++;
        }

        mediaSalarios = totalSalarios / quantEmp;

            System.out.println("Nome                " + "Salario");
            System.out.println("\n--------------    " + "--------");
            for (int i = 0; i < quantEmp; i++){
                    System.out.println(nome[i] + "                " + salarioEmp[i]);
            }


        System.out.println("\nTotal pago com salarios: R$" + totalSalarios);
        System.out.println("Media dos salarios: R$" + mediaSalarios);
    }

    // MARK: Metodo
    public static float calcSalario(int numPecasCalc){
        float salario;

        if (numPecasCalc > 0 && numPecasCalc <= 200){
            salario = numPecasCalc * 2f;
        } else if (numPecasCalc > 200 && numPecasCalc <= 400){
            salario = numPecasCalc * 2.30f;
        } else {
            salario = numPecasCalc * 2.50f;
        }

        return salario;
    }
}
