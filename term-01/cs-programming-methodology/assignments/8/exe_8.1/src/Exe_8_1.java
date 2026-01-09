import java.util.*;

public class Exe_8_1 {
	public static void main(String[]args){
		Scanner sc = new Scanner(System.in);
		int numA, numB, numC;

		System.out.print("Digite o numero inteiro A: ");
		numA = sc.nextInt();
		System.out.print("Digite o numero inteiro B: ");
		numB = sc.nextInt();
		System.out.print("Digite o numero inteiro C: ");
		numC = sc.nextInt();

		System.out.println("O resultado da soma dos numeros inteiros A e B é: " + somaAB(numA, numB));
		System.out.println("Numeros inteiros entre A e B que são divisiveis por C: ");
		entreDivABC(numA, numB, numC);
		System.out.print("-- -- -- -- -- -- ");
		System.out.println("\nValor percentual do numero inteiro C em relação ao A: " + percentualAC(numA, numC) + "%");
	}

	// METODO 1
	public static int somaAB(int x, int y){
		int soma;
		soma = x + y;
		return soma;
	}

	// METODO 2
	public static void entreDivABC(int a, int b, int c){
		if (c == 0){
			System.out.println("Erro! Numero divisor não pode ser 0.");
			return;
		}
		for (int i = a; i <= b; i++){
			if (i % c == 0){
				System.out.println(i);
			}
		}
	}

	// METODO 3
	public static int percentualAC(int w, int q){
		return q * 100 / w;
	}
}
