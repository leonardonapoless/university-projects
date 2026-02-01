import java.util.*;

public class Exe_10_2 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final String FLAG = "FIM";
        int nomesCont = 0;

        System.out.println("=== Programa Gerador de Login e Senha ===");
        System.out.println("-------------------------------------------");

        while (nomesCont < 30) {
            System.out.print("Digite o nome completo da pessoa " + (nomesCont + 1) +
                    " (ou digite '" + FLAG + "' para encerrar): ");
            String nomeCompleto = sc.nextLine();

            if (nomeCompleto.equalsIgnoreCase(FLAG)) {
                System.out.println("Programa encerrado.");
                break;
            }

            if (nomeIsValid(nomeCompleto)) {
                String login = gerarLogin(nomeCompleto);
                String senha = gerarSenha(login);

                System.out.println("\n--- Resultado ---");
                System.out.println("Nome digitado: " + nomeCompleto);
                System.out.println("Login gerado:  " + login);
                System.out.println("Senha gerada:  " + senha);

                nomesCont++;
            } else {
                System.out.println("Por favor, tente novamente para a pessoa " +
                        (nomesCont + 1) + ", seguindo as regras.");
            }
            System.out.println("-------------------------------------------");
        }
        sc.close();
    }

    public static boolean nomeIsValid(String nome) {
        if (nome == null) {
            System.out.println("Erro: Nome não pode ser nulo.");
            return false;
        }

        if (nome.length() < 15) {
            System.out.println("Erro: Nome deve ter no mínimo 15 caracteres. (Fornecido: " + nome.length() + ")");
            return false;
        }

        if (nome.startsWith(" ")) {
            System.out.println("Erro: Nome não deve começar com espaço.");
            return false;
        }

        if (nome.endsWith(" ")) {
            System.out.println("Erro: Nome não deve terminar com espaço.");
            return false;
        }

        if (nome.contains("  ")) {
            System.out.println("Erro: Nome não deve conter espaços duplos.");
            return false;
        }

        String[] partes = nome.split(" ");

        if (partes.length < 2) {
            System.out.println("Erro: Deve conter pelo menos um nome e um sobrenome, separados por um único espaço.");
            return false;
        }

        for (String parte : partes) {
            if (parte.isEmpty()) {
                System.out.println("Erro: Partes do nome não devem ser vazias (verifique espaços excessivos).");
                return false;
            }
            for (char c : parte.toCharArray()) {
                if (!Character.isLetter(c)) {
                    System.out.println("Erro: Cada parte do nome ('" + parte + "') " +
                            "deve conter apenas letras. Caractere inválido: '" + c + "'.");
                    return false;
                }
            }
        }
        return true;
    }

    public static String gerarLogin(String nomeCompleto) {
        String login = "";
        String[] partesNome = nomeCompleto.split(" ");
        for (String parte : partesNome) {
            if (!parte.isEmpty()) {
                login = login + Character.toUpperCase(parte.charAt(0));
            }
        }
        return login;
    }

    public static String gerarSenha(String login) {
        String senha = "";
        for (char c : login.toCharArray()) {
            int asciiValor = (int) c;
            String asciiString = Integer.toString(asciiValor);
            senha = senha + asciiString.charAt(0);
        }
        return senha;
    }
}
