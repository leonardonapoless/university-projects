import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;
import java.util.*;

public class Computador {

    char ativo;
    String codComp;
    String marca;
    String modelo;
    String processador;
    int quantMemoria;
    int tamanhoTela;
    int quantEstoque;
    float preco;
    int quantTotalVendida;
    int quantUltimaVenda;
    String dtUltimaVenda;

    static String[] vetMarca = { "Dell", "Lenovo", "HP", "Positivo", "Asus", "Apple", "IBM" };
    static String[] vetProcessador = { "Intel Core Ultra 3", "Intel Core Ultra 5", "Intel Core Ultra 7",
            "Intel Core Ultra 9", "AMD Ryzen 7", "AMD Ryzen 7", "AMD Ryzen 9" };
    static int[] vetTamanhoTela = { 10, 12, 15, 20, 25, 28 };

    public long pesquisarComputador(String codCompPesquisa) {
        // metodo para localizar um registro no arquivo em disco
        long posicaoCursorArquivo = 0;
        try (RandomAccessFile arqComputador = new RandomAccessFile("COMPUTADOR.DAT", "rw")) {
            while (true) {
                posicaoCursorArquivo = arqComputador.getFilePointer(); // posicao do inicio do registro no arquivo
                ativo = arqComputador.readChar();
                this.codComp = arqComputador.readUTF();
                marca = arqComputador.readUTF();
                modelo = arqComputador.readUTF();
                processador = arqComputador.readUTF();
                quantMemoria = arqComputador.readInt();
                tamanhoTela = arqComputador.readInt();
                quantEstoque = arqComputador.readInt();
                preco = arqComputador.readFloat();
                quantTotalVendida = arqComputador.readInt();
                quantUltimaVenda = arqComputador.readInt();
                dtUltimaVenda = arqComputador.readUTF();

                if (this.codComp.equalsIgnoreCase(codCompPesquisa) && ativo == 'S') {
                    return posicaoCursorArquivo;
                }
            }
        } catch (EOFException e) {
            return -1; // registro nao foi encontrado
        } catch (IOException e) {
            System.out.println("Erro na abertura do arquivo  -  programa sera finalizado");
            System.exit(0);
            return -1;
        }
    }

    public void salvarComputador() {
        // metodo para incluir um novo registro no final do arquivo em disco
        try (RandomAccessFile arqComputador = new RandomAccessFile("COMPUTADOR.DAT", "rw")) {
            arqComputador.seek(arqComputador.length()); // posiciona o ponteiro no final do arquivo (EOF)
            arqComputador.writeChar(ativo);
            arqComputador.writeUTF(codComp);
            arqComputador.writeUTF(marca);
            arqComputador.writeUTF(modelo);
            arqComputador.writeUTF(processador);
            arqComputador.writeInt(quantMemoria);
            arqComputador.writeInt(tamanhoTela);
            arqComputador.writeInt(quantEstoque);
            arqComputador.writeFloat(preco);
            arqComputador.writeInt(quantTotalVendida);
            arqComputador.writeInt(quantUltimaVenda);
            arqComputador.writeUTF(dtUltimaVenda);
            System.out.println("Dados gravados com sucesso!\n");
        } catch (IOException e) {
            System.out.println("Erro na abertura do arquivo  -  programa sera finalizado");
            System.exit(0);
        }
    }

    public void desativarComputador(long posicao) {
        // metodo para alterar o valor do campo ATIVO para N, tornando assim o registro
        // excluido
        try (RandomAccessFile arqComputador = new RandomAccessFile("COMPUTADOR.DAT", "rw")) {
            arqComputador.seek(posicao);
            arqComputador.writeChar('N'); // desativar o registro antigo
        } catch (IOException e) {
            System.out.println("Erro na abertura do arquivo  -  programa sera finalizado");
            System.exit(0);
        }
    }

    // *********************** INCLUSAO *****************************
    public void incluir() {
        String codCompChave;
        char confirmacao;
        long posicaoRegistro;

        do {
            do {
                Main.leia.nextLine();
                System.out.println("\n *************** INCLUSAO DE COMPUTADOR  ***************** ");
                System.out.print("Digite o código do computador( FIM para encerrar): ");
                codCompChave = Main.leia.nextLine();
                if (codCompChave.equalsIgnoreCase("FIM")) {
                    break;
                }
                posicaoRegistro = pesquisarComputador(codCompChave);

                if (posicaoRegistro >= 0) {
                    System.out.println("Código do computador já cadastrado, digite outro valor\n");
                }
            } while (posicaoRegistro >= 0);

            if (codCompChave.equalsIgnoreCase("FIM")) {
                break;
            }

            ativo = 'S';
            codComp = codCompChave;

            do {
                System.out.print("Digite a MARCA do PC.........................: ");
                marca = Main.leia.nextLine();
            } while (!consistirMarca(vetMarca, marca));

            System.out.print("Digite o MODELO do PC.......: ");
            modelo = Main.leia.nextLine();

            do {
                System.out.print("Digite o PROCESSADOR do PC..................: ");
                processador = Main.leia.nextLine();
            } while (!consistirProcessador(vetProcessador, processador));

            do {
                System.out.print("Digite a quantidade de MEMÓRIA do PC...................: ");
                quantMemoria = Main.leia.nextInt();
            } while (!consistirMemoria(quantMemoria));

            do {
                System.out.print("Digite o tamanho da TELA do PC.........................: ");
                tamanhoTela = Main.leia.nextInt();
            } while (!consistirTamanhoTela(vetTamanhoTela, tamanhoTela));

            System.out.print("Digite a quantidade do PC em ESTOQUE.........................: ");
            quantEstoque = Main.leia.nextInt();

            do {
                System.out.print("Digite o PREÇO do PC.........................: ");
                preco = Main.leia.nextFloat();
            } while (!consistirPreco(preco));

            quantTotalVendida = 0;
            quantUltimaVenda = 0;
            dtUltimaVenda = "";

            do {
                System.out.print("\nConfirma a gravacao dos dados (S/N) ? ");
                confirmacao = Main.leia.next().toUpperCase().charAt(0);
                if (confirmacao == 'S') {
                    salvarComputador();
                }
            } while (confirmacao != 'S' && confirmacao != 'N');

        } while (!codCompChave.equalsIgnoreCase("FIM"));
    }

    // ************************ ALTERACAO *****************************
    public void alterar() {
        String codCompChave;
        char confirmacao;
        long posicaoRegistro = -1;
        byte opcao;

        do {
            Main.leia.nextLine();
            System.out.println("\n *************** ALTERACAO DE COMPUTADORES  ***************** ");
            System.out.print("Digite o código do computador que deseja alterar( FIM para encerrar ): ");
            codCompChave = Main.leia.nextLine();
            if (codCompChave.equalsIgnoreCase("FIM")) {
                break;
            }

            posicaoRegistro = pesquisarComputador(codCompChave);
            if (posicaoRegistro == -1) {
                System.out.println("Código não cadastrado no arquivo, digite outro valor\n");
                continue;
            }

            ativo = 'S';

            do {
                System.out.println("[ 1 ] CodComp............: " + codComp);
                System.out.println("[ 2 ] Nome da Marca ......: " + marca);
                System.out.println("[ 3 ] Modelo.....: " + modelo);
                System.out.println("[ 4 ] Processador............: " + processador);
                System.out.println("[ 5 ] Memoria............: " + quantMemoria);
                System.out.println("[ 6 ] Tamanho Tela............: " + tamanhoTela);
                System.out.println("[ 7 ] Estoque............: " + quantEstoque);
                System.out.println("[ 8 ] Preço............: " + preco);
                System.out.println("[ 9 ] Quant Vend............: " + quantUltimaVenda);
                System.out.println("[ 10 ] Dt Ult Venda............: " + dtUltimaVenda);

                do {
                    System.out.print("Digite o numero do campo que deseja alterar (0 para finalizar as alterações): ");
                    opcao = Main.leia.nextByte();
                    if (opcao < 0 || opcao > 10) {
                        System.out.println("opcao Invalida, digite novamente.");
                    }
                } while (opcao < 0 || opcao > 10);

                Main.leia.nextLine();

                switch (opcao) {
                    case 1:
                        String novoCodComp;
                        long posNovoCodComp;
                        do {
                            System.out.print("Digite o NOVO CodComp..................: ");
                            novoCodComp = Main.leia.nextLine();
                            posNovoCodComp = pesquisarComputador(novoCodComp);
                            if (posNovoCodComp >= 0 && posNovoCodComp != posicaoRegistro) {
                                System.out.println("Novo código de computador já cadastrado, digite outro valor\n");
                            }
                        } while (posNovoCodComp >= 0 && posNovoCodComp != posicaoRegistro);
                        codComp = novoCodComp;
                        break;
                    case 2:
                        do {
                            System.out.print("Digite a NOVA marca...........: ");
                            marca = Main.leia.nextLine();
                        } while (!consistirMarca(vetMarca, marca));
                        break;
                    case 3:
                        System.out.print("Digite o NOVO modelo...........: ");
                        modelo = Main.leia.nextLine();
                        break;
                    case 4:
                        do {
                            System.out.print("Digite o NOVO processador............: ");
                            processador = Main.leia.nextLine();
                        } while (!consistirProcessador(vetProcessador, processador));
                        break;
                    case 5:
                        do {
                            System.out.print("Digite a NOVA quantidade de memória............: ");
                            quantMemoria = Main.leia.nextInt();
                        } while (!consistirMemoria(quantMemoria));
                        Main.leia.nextLine();
                        break;
                    case 6:
                        do {
                            System.out.print("Digite o NOVO tamanho de tela............: ");
                            tamanhoTela = Main.leia.nextInt();
                        } while (!consistirTamanhoTela(vetTamanhoTela, tamanhoTela));
                        Main.leia.nextLine();
                        break;
                    case 7:
                        System.out.print("Digite a NOVA quantidade do estoque............: ");
                        quantEstoque = Main.leia.nextInt();
                        Main.leia.nextLine();
                        break;
                    case 8:
                        do {
                            System.out.print("Digite o NOVO preço............: ");
                            preco = Main.leia.nextFloat();
                        } while (!consistirPreco(preco));
                        Main.leia.nextLine();
                        break;
                    case 9:
                        System.out.print("Digite a NOVA quantidade da ultima venda............: ");
                        quantUltimaVenda = Main.leia.nextInt();
                        Main.leia.nextLine();
                        break;
                    case 10:
                        do {
                            System.out.print("Digite a NOVA data da ultima venda (DD/MM/AAAA)............: ");
                            dtUltimaVenda = Main.leia.nextLine();
                        } while (!consistirData(dtUltimaVenda));
                        break;
                }
            } while (opcao != 0);

            do {
                System.out.print("\nConfirma a alteracao dos dados (S/N)? ");
                confirmacao = Main.leia.next().toUpperCase().charAt(0);
                if (confirmacao == 'S') {
                    desativarComputador(posicaoRegistro);
                    salvarComputador();
                }
            } while (confirmacao != 'S' && confirmacao != 'N');

        } while (!codComp.equalsIgnoreCase("FIM"));
    }

    // ************************ EXCLUSAO *****************************
    public void excluir() {
        String codCompChave;
        char confirmacao;
        long posicaoRegistro = -1;

        do {
            Main.leia.nextLine();
            System.out.println(" *************** EXCLUSAO DE CODCOMP  ***************** ");
            System.out.print("Digite o código que deseja excluir ( FIM para encerrar ): ");
            codCompChave = Main.leia.nextLine();
            if (codCompChave.equalsIgnoreCase("FIM")) {
                System.out.println("\n ************ PROGRAMA ENCERRADO  ************** \n");
                break;
            }

            posicaoRegistro = pesquisarComputador(codCompChave);
            if (posicaoRegistro == -1) {
                System.out.println("Código nao cadastrado no arquivo, digite outro valor\n");
                continue;
            }

            System.out.println("Nome da marca.......: " + marca);
            System.out.println("Modelo.......: " + modelo);
            System.out.println("Processador..: " + processador);
            System.out.println("Memoria: " + quantMemoria);
            System.out.println("tamanho tela.......: " + tamanhoTela);
            System.out.println("Preço.......: " + preco);

            do {
                System.out.print("\nConfirma a exclusao deste CODCOMP (S/N) ? ");
                confirmacao = Main.leia.next().toUpperCase().charAt(0);
                if (confirmacao == 'S') {
                    desativarComputador(posicaoRegistro);
                    System.out.println("Registro desativado com sucesso!\n");
                }
            } while (confirmacao != 'S' && confirmacao != 'N');

        } while (true);
    }

    // ************************ CONSULTA *****************************
    public void exibirRelatorio() {
        RandomAccessFile arqComputador;
        byte opcao;
        String codChave;
        String ano;
        float precoMax;
        float precoMin;
        float valorEstoque;


        do {
            System.out.println(" *************** RELATÓRIO DE VENDAS   ***************** ");
            System.out.println(" [1] Listar TODOS os computadores ");
            System.out.println(" [2] Listar apenas um computador por CÓDIGO ");
            System.out.println(" [3] Listar SOMENTE computadores já vendidos  ");
            System.out.println(" [4] Listar computadores cuja VENDA ocorreu em determinado ANO ");
            System.out.println(" [5] Listar Computadores por faixa de preço ");
            System.out.println(" [6] Listar Computadores cujo preço do estoque ultrapasse o valor de R$50.000,00");
            System.out.println(" [0] SAIR");
            System.out.print("\nDigite a opcao desejada: ");
            opcao = Main.leia.nextByte();
            if (opcao < 0 || opcao > 6) {
                System.out.println("opcao Invalida, digite novamente.\n");
            }
            Main.leia.nextLine();

            switch (opcao) {
                case 0:
                    System.out.println("\n ************ PROGRAMA ENCERRADO  ************** \n");
                    break;

                case 1: // imprime todos os computadores
                    System.out.print("Lista de TODOS os computadores: ");
                    try (RandomAccessFile arq = new RandomAccessFile("COMPUTADOR.DAT", "r")) {
                        imprimirCabecalho();
                        while (true) {
                            ativo = arq.readChar();
                            codComp = arq.readUTF();
                            marca = arq.readUTF();
                            modelo = arq.readUTF();
                            processador = arq.readUTF();
                            quantMemoria = arq.readInt();
                            tamanhoTela = arq.readInt();
                            quantEstoque = arq.readInt();
                            preco = arq.readFloat();
                            quantTotalVendida = arq.readInt();
                            quantUltimaVenda = arq.readInt();
                            dtUltimaVenda = arq.readUTF();
                            if (ativo == 'S') {
                                imprimirComputador();
                            }
                        }
                    } catch (EOFException e) {
                        System.out.println("\n FIM DE RELATORIO - ENTER para continuar...\n");
                        Main.leia.nextLine();
                    } catch (IOException e) {
                        System.out.println("Erro na abertura do arquivo - programa sera finalizado");
                        System.exit(0);
                    }

                    break;

                case 2: // consulta de uma unica maquina
                    System.out.println("Digite o codigo do computador que deseja pesquisar");
                    codChave = Main.leia.nextLine();

                    long posicaoRegistro = pesquisarComputador(codChave);

                    if (posicaoRegistro == -1) {
                        System.out.println("O codigo informado nao esta atribuido a nenhuma maquina");
                    } else {
                        imprimirCabecalho();
                        imprimirComputador();
                    }
                    System.out.println("\n FIM DE RELATORIO - ENTER para continuar...\n");
                    Main.leia.nextLine();
                    break;

                case 3: // imprime computadores do sexo desejado
                    try (RandomAccessFile arq = new RandomAccessFile("COMPUTADOR.DAT", "r")) {
                        imprimirCabecalho();
                        while (true) {
                            ativo = arq.readChar();
                            codComp = arq.readUTF();
                            marca = arq.readUTF();
                            modelo = arq.readUTF();
                            processador = arq.readUTF();
                            quantMemoria = arq.readInt();
                            tamanhoTela = arq.readInt();
                            quantEstoque = arq.readInt();
                            preco = arq.readFloat();
                            quantTotalVendida = arq.readInt();
                            quantUltimaVenda = arq.readInt();
                            dtUltimaVenda = arq.readUTF();
                            if (ativo == 'S' && quantTotalVendida > 0) {
                                imprimirComputador();
                            }
                        }
                    } catch (EOFException e) {
                        System.out.println("\nFIM DE RELATORIO - ENTER para continuar...\n");
                        Main.leia.nextLine();
                    } catch (IOException e) {
                        System.out.println("Erro na abertura do arquivo - programa sera finalizado");
                        System.exit(0);
                    }
                    break;

                case 4:
                    System.out.println("Digite o ano que deseja (AAAA):");
                    ano = Main.leia.nextLine();
                    try (RandomAccessFile arq = new RandomAccessFile("COMPUTADOR.DAT", "r")) {
                        imprimirCabecalho();
                        while (true) {
                            ativo = arq.readChar();
                            codComp = arq.readUTF();
                            marca = arq.readUTF();
                            modelo = arq.readUTF();
                            processador = arq.readUTF();
                            quantMemoria = arq.readInt();
                            tamanhoTela = arq.readInt();
                            quantEstoque = arq.readInt();
                            preco = arq.readFloat();
                            quantTotalVendida = arq.readInt();
                            quantUltimaVenda = arq.readInt();
                            dtUltimaVenda = arq.readUTF();
                            if (ativo == 'S' && !dtUltimaVenda.isEmpty() && dtUltimaVenda.length() >= 10 && dtUltimaVenda.substring(6, 10).equals(ano)) {
                                imprimirComputador();
                            }
                        }
                    } catch (EOFException e) {
                        System.out.println("\nFIM DE RELATORIO - ENTER para continuar...\n");
                        Main.leia.nextLine();
                    } catch (IOException e) {
                        System.out.println("Erro na abertura do arquivo - programa sera finalizado");
                        System.exit(0);
                    }
                    break;

                case 5:
                    do {
                        System.out.println("Digite o preço minimo a pesquisar (Entre 1000 e 20000): ");
                        precoMin = Main.leia.nextFloat();
                    } while (!consistirPreco(precoMin));

                    do {
                        System.out.println("Digite o preço maximo a pesquisar (Entre 1000 e 20000): ");
                        precoMax = Main.leia.nextFloat();
                        if (precoMax < precoMin) {
                            System.out.println("O preco maximo deve ser maior ou igual ao preco minimo");
                        }
                    } while (!consistirPreco(precoMax) || precoMax < precoMin);
                    Main.leia.nextLine();

                    System.out.println("\nLista de computadores por faixa de preço (R$" + precoMin + " - R$" + precoMax + "):");
                    try (RandomAccessFile arq = new RandomAccessFile("COMPUTADOR.DAT", "r")) {
                        imprimirCabecalho();
                        while (true) {
                            ativo = arq.readChar();
                            codComp = arq.readUTF();
                            marca = arq.readUTF();
                            modelo = arq.readUTF();
                            processador = arq.readUTF();
                            quantMemoria = arq.readInt();
                            tamanhoTela = arq.readInt();
                            quantEstoque = arq.readInt();
                            preco = arq.readFloat();
                            quantTotalVendida = arq.readInt();
                            quantUltimaVenda = arq.readInt();
                            dtUltimaVenda = arq.readUTF();
                            if (ativo == 'S' && (preco >= precoMin && preco <= precoMax)) {
                                imprimirComputador();
                            }
                        }
                    } catch (EOFException e) {
                        System.out.println("\n FIM DE RELATORIO - ENTER para continuar...\n");
                        Main.leia.nextLine();
                    } catch (IOException e) {
                        System.out.println("Erro na abertura do arquivo - programa sera finalizado");
                        System.exit(0);
                    }
                    break;
                case 6:
                    System.out.println("\nLista de computadores com valor de estoque acima de R$50.000,00: ");
                    try (RandomAccessFile arq = new RandomAccessFile("COMPUTADOR.DAT", "r")) {
                        imprimirCabecalho();
                        while (true) {
                            ativo = arq.readChar();
                            codComp = arq.readUTF();
                            marca = arq.readUTF();
                            modelo = arq.readUTF();
                            processador = arq.readUTF();
                            quantMemoria = arq.readInt();
                            tamanhoTela = arq.readInt();
                            quantEstoque = arq.readInt();
                            preco = arq.readFloat();
                            quantTotalVendida = arq.readInt();
                            quantUltimaVenda = arq.readInt();
                            dtUltimaVenda = arq.readUTF();

                            valorEstoque = quantEstoque * preco;

                            if (ativo == 'S' && valorEstoque > 50000) {
                                imprimirComputador();
                            }
                        }
                    } catch (EOFException e) {
                        System.out.println("\nFIM DE RELATORIO - ENTER para continuar...\n");
                        Main.leia.nextLine();
                    } catch (IOException e) {
                        System.out.println("Erro na abertura do arquivo - programa sera finalizado");
                        System.exit(0);
                    }
                    break;
            }
        } while (opcao != 0);
    }

    public void imprimirCabecalho() {
        System.out.println("CODIGO      MARCA                          MODELO   PROCESSADOR    EST.  PRECO          VEND. DATA_VENDA    VALOR_VENDA");
        System.out.println("----------- ------------------------------ -------- ------------- ----- -------------- ----- ---------- ------------------------------");
    }

    public void imprimirComputador() {
        double vlrVenda = preco * quantTotalVendida;
        System.out.println(formatarString(codComp, 11) + "  " + formatarString(marca, 30) + "  "
                + formatarString(modelo, 8) + "  " + formatarString(processador, 13) + "  "
                + String.format("%-5s", quantEstoque) + " " + String.format("%-14.2f", preco) + " "
                + String.format("%-5s", quantTotalVendida) + " " + formatarString(dtUltimaVenda, 10) + "  "
                + String.format("%-30.2f", vlrVenda));
    }

    public static String formatarString(String texto, int tamanho) {
        // retorna uma string com o numero de caracteres passado como parametro em
        // TAMANHO
        if (texto.length() > tamanho) {
            texto = texto.substring(0, tamanho);
        } else {
            while (texto.length() < tamanho) {
                texto = texto + " ";
            }
        }
        return texto;
    }

    public static boolean consistirMarca(String[] VetMarca, String marca) {
        for (int i = 0; i < VetMarca.length; i++) {
            if (VetMarca[i].equalsIgnoreCase(marca)) {
                return true;
            }
        }
        return false;
    }

    public static boolean consistirProcessador(String[] VetProcessador, String processador) {
        for (int i = 0; i < VetProcessador.length; i++) {
            if (VetProcessador[i].equalsIgnoreCase(processador)) {
                return true;
            }
        }
        return false;
    }

    public static boolean consistirTamanhoTela(int[] VetTamanhoTela, int tamanhoTela) {
        for (int i = 0; i < VetTamanhoTela.length; i++) {
            if (VetTamanhoTela[i] == tamanhoTela) {
                return true;
            }
        }
        return false;
    }
    public static boolean consistirPreco(float preco) {
        if(preco < 1000 || preco > 20000) {
            System.out.println("O preco deve estar entre 1000 e 20000");
            return false;
        }
        return true;

    }

    public static boolean consistirMemoria(int memoria) {
        if (memoria < 1 || memoria > 32) {
            System.out.println("\nERRO: A memória RAM deve estar entre 1GB e 32GB.\n");
            return false;
        }

        return true;
    }

    public static boolean consistirData(String data) {
        if (data.length() != 10 || data.charAt(2) != '/' || data.charAt(5) != '/') {
            System.out.println("\nFormato de data invalido. Use DD/MM/AAAA.\n");
            return false;
        }

        String diaStr = data.substring(0, 2);
        String mesStr = data.substring(3, 5);
        String anoStr = data.substring(6, 10);

        for (int i = 0; i < diaStr.length(); i++) {
            if (!Character.isDigit(diaStr.charAt(i))) {
                System.out.println("\nO dia na data deve conter apenas numeros.\n");
                return false;
            }
        }

        for (int i = 0; i < mesStr.length(); i++) {
            if (!Character.isDigit(mesStr.charAt(i))) {
                System.out.println("\nO mês na data deve conter apenas números.\n");
                return false;
            }
        }

        for (int i = 0; i < anoStr.length(); i++) {
            if (!Character.isDigit(anoStr.charAt(i))) {
                System.out.println("\nO ano na data deve conter apenas numeros.\n");
                return false;
            }
        }
        int dia = Integer.parseInt(diaStr);
        int mes = Integer.parseInt(mesStr);
        int ano = Integer.parseInt(anoStr);

        if (ano <= 0 || mes < 1 || mes > 12 || dia < 1) {
            System.out.println("\nEsta data de ano, mês ou dia não é possivel.\n");
            return false;
        }

        int maxDiasDoMes;
        switch (mes) {
            case 2:
                if ((ano % 4 == 0 && ano % 100 != 0) || (ano % 400 == 0)) {
                    maxDiasDoMes = 29;
                } else {
                    maxDiasDoMes = 28;
                }
                break;

            case 4:
            case 6:
            case 9:
            case 11:
                maxDiasDoMes = 30;
                break;

            default:
                maxDiasDoMes = 31;
                break;
        }

        if (dia > maxDiasDoMes) {
            System.out.println("\nO dia " + dia + " é invalido para o mes " + mes + " do ano " + ano + ".\n");
            return false;
        }
        return true;
    }

}