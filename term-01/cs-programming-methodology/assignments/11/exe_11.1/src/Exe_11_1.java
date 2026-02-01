import java.io.*;
import java.util.Scanner;

public class Exe_11_1 {

    public static class Cliente {
        public int codCliente;
        public String nomeCliente;
        public float vlrCompra;
        public int anoPrimeiraCompra;
        public boolean emDia;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean encontrou;
        char continuar;
        RandomAccessFile arquivo;
        do {
            Cliente cliente = new Cliente();

            System.out.println("\n---------------------------------------------------");
            System.out.println("        ---   INCLUSÃO DE CLIENTES   ---");
            System.out.println("--- (Digite 'FIM' a qualquer momento para sair) ---");
            System.out.println("---------------------------------------------------");

            // codigo do cliente
            do {
                encontrou = false;
                System.out.print("Digite o codigo do cliente: ");

                // verifica se a entrada e um numero inteiro
                if (sc.hasNextInt()) {
                    cliente.codCliente = sc.nextInt();
                    sc.nextLine();

                    if (cliente.codCliente <= 0) {
                        System.out.println("ERRO: O código deve ser maior que zero ");
                        encontrou = true;
                        continue;
                    }

                    // verifica se o codigo do cliente ja existe
                    try {
                        arquivo = new RandomAccessFile("CLIENTES.DAT", "r");
                        while (true) {
                            char ativo = arquivo.readChar();
                            int codigo = arquivo.readInt();
                            arquivo.readUTF();
                            arquivo.readFloat();
                            arquivo.readInt();
                            arquivo.readBoolean();

                            if (codigo == cliente.codCliente && ativo == 'S') {
                                System.out.println("ERRO: Código já cadastrado, digite outro \n");
                                encontrou = true;
                                break;
                            }
                        }
                        arquivo.close();
                    } catch (EOFException e) {
                        encontrou = false;
                    } catch (IOException e) {
                        System.out.println("Erro na abertura do arquivo - o programa será finalizado");
                    }

                } else {
                    String texto = sc.next().toUpperCase();
                    if (texto.equals("FIM")) {
                        System.out.println("\n--- Programa finalizado ---");
                        System.exit(0);
                    } else {
                        System.out.println("ERRO: Por favor, digite um número válido.");
                        encontrou = true;
                        sc.nextLine();
                    }
                }
            } while (encontrou);

            // nome do cliente
            do {
                System.out.print("Digite o nome do cliente (min. 10 caracteres): ");
                cliente.nomeCliente = sc.nextLine();
                if (cliente.nomeCliente.equalsIgnoreCase("FIM")) {
                    System.out.println("\n--- Programa finalizado ---");
                    System.exit(0);
                }
                if (cliente.nomeCliente.length() < 10) {
                    System.out.println("ERRO: O nome precisa ter no mínimo 10 caracteres.\n");
                }
            } while (cliente.nomeCliente.length() < 10);

            // valor da compra
            do {
                System.out.print("Digite o Valor da Compra: ");
                if (sc.hasNextFloat()) {
                    cliente.vlrCompra = sc.nextFloat();
                    sc.nextLine();
                    if (cliente.vlrCompra <= 0) {
                        System.out.println("ERRO: O valor da compra deve ser maior que zero.\n");
                    }
                } else {
                    String texto = sc.next().toUpperCase();
                    if (texto.equals("FIM")) {
                        System.out.println("\n--- Programa finalizado ---");
                        System.exit(0);
                    } else {
                        System.out.println("ERRO: Por favor, digite um valor numérico.");
                        cliente.vlrCompra = 0;
                        sc.nextLine();
                    }
                }
            } while (cliente.vlrCompra <= 0);

            // ano da primeira compra
            do {
                System.out.print("Digite o ano da primeira compra: ");
                if (sc.hasNextInt()) {
                    cliente.anoPrimeiraCompra = sc.nextInt();
                    sc.nextLine();
                    if (cliente.anoPrimeiraCompra > 2013) {
                        System.out.println("ERRO: O ano não pode ser maior que 2013.\n");
                    }
                } else {
                    String flag = sc.next().toUpperCase();
                    if (flag.equals("FIM")) {
                        System.out.println("\n--- Programa finalizado ---");
                        System.exit(0);
                    } else {
                        System.out.println("ERRO: Por favor, digite um ano válido.");
                        cliente.anoPrimeiraCompra = 9999;
                        sc.nextLine();
                    }
                }
            } while (cliente.anoPrimeiraCompra > 2013);

            // verificacao do em dia
            do {
                System.out.print("O cliente está em dia? (S/N): ");
                String emDiaChar = sc.nextLine().toUpperCase();
                if (emDiaChar.equals("FIM")) {
                    System.out.println("\n--- Programa finalizado ---");
                    System.exit(0);
                }
                if (emDiaChar.equals("S") || emDiaChar.equals("N")) {
                    cliente.emDia = emDiaChar.equals("S");
                    break;
                } else {
                    System.out.println("ERRO: Resposta inválida. Digite apenas 'S' ou 'N'.");
                }
            } while (true);

            // confirmar e gravar os dados
            char confirma = ' ';
            do {
                System.out.print("\nConfirma a gravação dos dados? (S/N): ");
                String confirmGravacao = sc.nextLine().toUpperCase();
                if (!confirmGravacao.isEmpty()) {
                    confirma = confirmGravacao.charAt(0);
                } else {
                    System.out.println("ERRO: Digite S ou N ");
                    confirma = 'X';
                }
            } while (confirma != 'S' && confirma != 'N');


            if (confirma == 'S') {
                try {
                    arquivo = new RandomAccessFile("CLIENTES.DAT", "rw");
                    arquivo.seek(arquivo.length());
                    arquivo.writeChar('S');
                    arquivo.writeInt(cliente.codCliente);
                    arquivo.writeUTF(cliente.nomeCliente);
                    arquivo.writeFloat(cliente.vlrCompra);
                    arquivo.writeInt(cliente.anoPrimeiraCompra);
                    arquivo.writeBoolean(cliente.emDia);
                    arquivo.close();
                    System.out.println("\n>> Cliente cadastrado com sucesso! :D <<");
                } catch (IOException e) {
                    System.out.println("ERRO: Falha ao escrever no arquivo.");
                    System.exit(0);
                }
            } else {
                System.out.println("\n>> Gravação cancelada <<");
            }

            do {
                System.out.print("\nDeseja incluir um novo cliente? (S/N): ");
                String resposta = sc.nextLine().toUpperCase();
                if (!resposta.isEmpty()) {
                    continuar = resposta.charAt(0);
                } else {
                    continuar = 'N';
                }
            } while (continuar != 'S' && continuar != 'N');


        } while (continuar == 'S');

        System.out.println("\n--- Programa finalizado ---");
        sc.close();
    }
}