import java.util.*;

public class exe_2 {
    public static void main (String[] args){
        Scanner sc = new Scanner(System.in);
        String nomeEmpregado;
        float salario;
        float novoSalario;

        System.out.print("Digite o nome do empregado: ");
        nomeEmpregado = sc.nextLine();

        System.out.print("Digite o salario do empregado R$: ");
        salario = sc.nextFloat();

        novoSalario = salario + (salario / 15);

        System.out.println("O novo salario do empregado é R$: " + novoSalario);
    }
}
