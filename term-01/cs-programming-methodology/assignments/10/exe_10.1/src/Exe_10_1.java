import java.util.*;

public class Exe_10_1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Digite seu nome completo: ");
        String nomeDigitado = sc.nextLine();

        String nomeCorrigido = eliminarEspacosEsquerda(nomeDigitado);
        nomeCorrigido = eliminarEspacosDireita(nomeCorrigido);
        nomeCorrigido = eliminarEspacosExcessivos(nomeCorrigido);
        String nomeFinal = converterIniciaisMaiusculas(nomeCorrigido);

        System.out.println("Nome formatado: " + nomeFinal);

        sc.close();
    }

    public static String converterIniciaisMaiusculas(String nome) {
        if (nome == null || nome.isEmpty()) {
            return nome;
        }

        String nomeConvertido = "";
        boolean proximaMaiuscula = true;
        int tamanho = nome.length();

        for (int i = 0; i < tamanho; i++) {
            char caractereAtual = nome.charAt(i);

            if (proximaMaiuscula && caractereAtual != ' ') {
                nomeConvertido = nomeConvertido + Character.toUpperCase(caractereAtual);
                proximaMaiuscula = false;
            } else {
                nomeConvertido = nomeConvertido + caractereAtual;
            }

            if (caractereAtual == ' ') {
                proximaMaiuscula = true;
            }
        }
        return nomeConvertido;
    }

    public static String eliminarEspacosEsquerda(String nome) {
        while (nome.length() > 0 && nome.charAt(0) == ' ') {
            nome = nome.substring(1);
        }
        return nome;
    }

    public static String eliminarEspacosDireita(String nome) {
        while (nome.length() > 0 && nome.charAt(nome.length() - 1) == ' ') {
            nome = nome.substring(0, nome.length() - 1);
        }
        return nome;
    }

    public static String eliminarEspacosExcessivos(String nome) {
        while (nome.contains("  ")) {
            nome = nome.replace("  ", " ");
        }
        return nome;
    }
}