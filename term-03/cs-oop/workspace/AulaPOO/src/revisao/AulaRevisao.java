/// Leonardo Nápoles
package revisao;
import java.util.Scanner;

public class AulaRevisao {
    static Scanner sc = new Scanner(System.in);

    public static float receberLado(int numero) {
        float valor = 0;
        boolean valido = false;
        while (!valido) {
            try {
                System.out.printf("Digite o valor do %dº lado: ", numero);
                valor = sc.nextFloat();
                if (valor <= 0)
                    System.out.println("Valor invalido! Digite um valor positivo.");
                else
                    valido = true;
            } catch (Exception e) {
                System.out.println("Entrada invalida! Digite um numero.");
                sc.next();
            }
        }
        return valor;
    }

    public static void preencherLados(float lados[]) {
        for (int i = 0; i < 3; i++)
            lados[i] = receberLado(i + 1);
    }

    public static boolean verificarTriangulo(float lados[]) {
        return lados[0] <= lados[1] + lados[2] &&
                lados[1] <= lados[0] + lados[2] &&
                lados[2] <= lados[0] + lados[1];
    }

    public static String tipoTriangulo(float lados[]) {
        if (lados[0] == lados[1] && lados[1] == lados[2])
            return "Equilatero";
        if (lados[0] == lados[1] || lados[1] == lados[2] || lados[0] == lados[2])
            return "Isosceles";
        return "Escaleno";
    }

    public static void main(String[] args) {
        float lados[] = new float[3];

        do {
            preencherLados(lados);
            if (!verificarTriangulo(lados))
                System.out.println("Os valores digitados nao formam um triangulo. Tente novamente.\n");
        } while (!verificarTriangulo(lados));

        System.out.println("É um triangulo do tipo: " + tipoTriangulo(lados));
        sc.close();
    }
}
