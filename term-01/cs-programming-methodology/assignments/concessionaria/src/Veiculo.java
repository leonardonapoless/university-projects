// concessionaria/src/Veiculo.java

import java.io.EOFException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class Veiculo {

    // --- Atributos do Veículo ---
    char ativo;
    String placa;
    String marca;
    String modelo;
    int anoFabricacao;
    int anoModelo;
    float preco;
    int quilometragem;

    // --- MÉTODOS DE MANIPULAÇÃO DO ARQUIVO (PRIVADOS) ---

    private long pesquisarPosicao(String placaPesquisa) {
        long posicao = -1;
        long posAtual;
        char ativoLido;
        String placaLida;

        try (RandomAccessFile arq = new RandomAccessFile("VEICULOS.DAT", "r")) {
            while (arq.getFilePointer() < arq.length()) {
                posAtual = arq.getFilePointer();
                ativoLido = arq.readChar();
                placaLida = arq.readUTF();
                if (ativoLido == 'S' && placaLida.equalsIgnoreCase(placaPesquisa)) {
                    posicao = posAtual;
                    break;
                }
                arq.readUTF(); arq.readUTF(); arq.readInt(); arq.readInt(); arq.readFloat(); arq.readInt();
            }
        } catch (EOFException e) {
            // Fim do arquivo, normal.
        } catch (IOException e) {
            // MUDANÇA: Mensagem de erro genérica.
            System.out.println("Ocorreu um erro de arquivo ao pesquisar.");
        }
        return posicao;
    }

    private void lerRegistro(RandomAccessFile arq) throws IOException {
        this.ativo = arq.readChar();
        this.placa = arq.readUTF();
        this.marca = arq.readUTF();
        this.modelo = arq.readUTF();
        this.anoFabricacao = arq.readInt();
        this.anoModelo = arq.readInt();
        this.preco = arq.readFloat();
        this.quilometragem = arq.readInt();
    }

    private void salvarNoArquivo() {
        try (RandomAccessFile arq = new RandomAccessFile("VEICULOS.DAT", "rw")) {
            arq.seek(arq.length());
            arq.writeChar(this.ativo);
            arq.writeUTF(this.placa);
            arq.writeUTF(this.marca);
            arq.writeUTF(this.modelo);
            arq.writeInt(this.anoFabricacao);
            arq.writeInt(this.anoModelo);
            arq.writeFloat(this.preco);
            arq.writeInt(this.quilometragem);
            System.out.println("Dados gravados com sucesso!");
        } catch (IOException e) {
            // MUDANÇA: Mensagem de erro genérica.
            System.out.println("Ocorreu um erro de arquivo ao salvar.");
        }
    }

    private void desativarNoArquivo(long posicao) {
        try (RandomAccessFile arq = new RandomAccessFile("VEICULOS.DAT", "rw")) {
            arq.seek(posicao);
            arq.writeChar('N');
            System.out.println("Registro desativado com sucesso!");
        } catch (IOException e) {
            // MUDANÇA: Mensagem de erro genérica.
            System.out.println("Ocorreu um erro de arquivo ao desativar.");
        }
    }

    // --- MÉTODOS DO CRUD (NÃO PRECISAM DE MUDANÇAS AQUI) ---

    public void incluir() {
        // --- Declaração de Variáveis ---
        String placaChave;
        long posicao;
        String marcaLida;
        String modeloLido;
        int anoFabLido;
        int anoModLido;
        float precoLido;
        int kmLida;
        char confirmacao;

        // --- Início da Lógica ---
        do {
            System.out.println("\n--- INCLUSÃO DE VEÍCULO ---");
            System.out.print("Digite a Placa (ou FIM para voltar): ");
            placaChave = Main.leia.nextLine().toUpperCase();
            if (placaChave.equalsIgnoreCase("FIM")) break;
            posicao = pesquisarPosicao(placaChave);
            if (posicao != -1) {
                System.out.println("ERRO: Placa já cadastrada no sistema.");
            } else {
                System.out.print("Digite a Marca: ");
                marcaLida = Main.leia.nextLine();
                System.out.print("Digite o Modelo: ");
                modeloLido = Main.leia.nextLine();
                System.out.print("Digite o Ano de Fabricação: ");
                anoFabLido = Integer.parseInt(Main.leia.nextLine());
                System.out.print("Digite o Ano do Modelo: ");
                anoModLido = Integer.parseInt(Main.leia.nextLine());
                System.out.print("Digite o Preço: ");
                precoLido = Float.parseFloat(Main.leia.nextLine());
                System.out.print("Digite a Quilometragem: ");
                kmLida = Integer.parseInt(Main.leia.nextLine());
                System.out.print("Confirma a inclusão (S/N)? ");
                confirmacao = Main.leia.nextLine().toUpperCase().charAt(0);
                if (confirmacao == 'S') {
                    this.ativo = 'S';
                    this.placa = placaChave;
                    this.marca = marcaLida;
                    this.modelo = modeloLido;
                    this.anoFabricacao = anoFabLido;
                    this.anoModelo = anoModLido;
                    this.preco = precoLido;
                    this.quilometragem = kmLida;
                    salvarNoArquivo();
                } else {
                    System.out.println("Inclusão cancelada.");
                }
            }
        } while (true);
    }

    public void alterar() {
        // --- Declaração de Variáveis ---
        String placaChave;
        long posicao;
        float novoPreco;
        int novaKm;
        char confirmacao;

        // --- Início da Lógica ---
        System.out.println("\n--- ALTERAÇÃO DE VEÍCULO ---");
        System.out.print("Digite a Placa do veículo a alterar: ");
        placaChave = Main.leia.nextLine().toUpperCase();
        posicao = pesquisarPosicao(placaChave);
        if (posicao == -1) {
            System.out.println("Placa não encontrada.");
            return;
        }
        try (RandomAccessFile arq = new RandomAccessFile("VEICULOS.DAT", "r")) {
            arq.seek(posicao);
            lerRegistro(arq);
        } catch (IOException e) {
            // MUDANÇA: Mensagem de erro genérica.
            System.out.println("Ocorreu um erro ao ler o arquivo para alteração.");
            return;
        }
        System.out.println("Dados atuais:");
        System.out.println("Marca: " + this.marca + ", Modelo: " + this.modelo + ", Preço: " + this.preco);
        System.out.print("Digite o NOVO preço: ");
        novoPreco = Float.parseFloat(Main.leia.nextLine());
        System.out.print("Digite a NOVA quilometragem: ");
        novaKm = Integer.parseInt(Main.leia.nextLine());
        System.out.print("Confirma a alteração (S/N)? ");
        confirmacao = Main.leia.nextLine().toUpperCase().charAt(0);
        if (confirmacao == 'S') {
            desativarNoArquivo(posicao);
            this.preco = novoPreco;
            this.quilometragem = novaKm;
            this.ativo = 'S';
            salvarNoArquivo();
            System.out.println("Veículo alterado com sucesso.");
        } else {
            System.out.println("Alteração cancelada.");
        }
    }

    public void excluir() {
        // --- Declaração de Variáveis ---
        String placaChave;
        long posicao;
        char confirmacao;

        // --- Início da Lógica ---
        System.out.println("\n--- EXCLUSÃO DE VEÍCULO ---");
        System.out.print("Digite a Placa do veículo a excluir: ");
        placaChave = Main.leia.nextLine().toUpperCase();
        posicao = pesquisarPosicao(placaChave);
        if (posicao == -1) {
            System.out.println("Placa não encontrada.");
            return;
        }
        System.out.print("Confirma a exclusão deste veículo (S/N)? ");
        confirmacao = Main.leia.nextLine().toUpperCase().charAt(0);
        if (confirmacao == 'S') {
            desativarNoArquivo(posicao);
        } else {
            System.out.println("Exclusão cancelada.");
        }
    }

    public void consultar() {
        // --- Declaração de Variáveis ---
        String cabecalho;
        String linha;
        String anoFormatado;
        String precoFormatado;
        String kmFormatada;

        // --- Início da Lógica ---
        System.out.println("\n--- LISTA DE VEÍCULOS CADASTRADOS ---");
        cabecalho = formatarTexto("PLACA", 10) + " | " + formatarTexto("MARCA", 15) + " | " + formatarTexto("MODELO", 15) + " | " + formatarTexto("ANO", 10) + " | " + formatarTexto("PREÇO (R$)", 15) + " | " + formatarTexto("KM", 10);
        System.out.println(cabecalho);
        System.out.println("-".repeat(90));
        try (RandomAccessFile arq = new RandomAccessFile("VEICULOS.DAT", "r")) {
            while (arq.getFilePointer() < arq.length()) {
                lerRegistro(arq);
                if (this.ativo == 'S') {
                    anoFormatado = this.anoFabricacao + "/" + this.anoModelo;
                    precoFormatado = String.valueOf(this.preco);
                    kmFormatada = String.valueOf(this.quilometragem);
                    linha = formatarTexto(this.placa, 10) + " | " + formatarTexto(this.marca, 15) + " | " + formatarTexto(this.modelo, 15) + " | " + formatarTexto(anoFormatado, 10) + " | " + formatarTexto(precoFormatado, 15) + " | " + formatarTexto(kmFormatada, 10);
                    System.out.println(linha);
                }
            }
        } catch (EOFException e) {
            // Fim de arquivo
        } catch (IOException e) {
            // MUDANÇA: Mensagem de erro genérica.
            System.out.println("Ocorreu um erro de arquivo ao consultar.");
        }
        System.out.println("-".repeat(90));
        System.out.print("\nPressione Enter para continuar...");
        Main.leia.nextLine();
    }

    private String formatarTexto(String texto, int tamanho) {
        if (texto.length() > tamanho) {
            return texto.substring(0, tamanho);
        }
        while (texto.length() < tamanho) {
            texto = texto + " ";
        }
        return texto;
    }
}