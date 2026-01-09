import java.io.*;

public class Computador {

    char ativo;
    String codComp;
    String marca;
    String modelo;
    String processador;
    int quantMem;
    String tamanhoTela;
    int quantEstoque;
    float preco;
    int quantTotalVendida;
    int quantUltimaVenda;
    String dataUltimaVenda;
    RandomAccessFile arqComputador;

    public final String[] vetMarca = {"Dell", "Lenovo", "HP", "Positivo", "Asus", "Apple", "IBM"};
    public final String[] vetProcessador = {"Intel Core Ultra 3", "Intel Core Ultra 5", "Intel Core Ultra 7", "Intel Core Ultra 9",
            "AMD Ryzen 5", "AMD Ryzen 7", "AMD Ryzen 9"};
    public final String[] vetTamanhoTela = {"10", "12", "15", "20", "25", "28"};

    public static void alterar() {
    }

    public static void consultar() {
    }

    public static void excluir() {
    }

    public long pesquisarComputador(String codCompPesquisa) {
        long cursorFilePos = 0;

        try (RandomAccessFile arqComputador = new RandomAccessFile("COMPUTADOR.DAT", "rw")) {

            while (true) {
                cursorFilePos = arqComputador.getFilePointer();
                ativo = arqComputador.readChar();
                codComp = arqComputador.readUTF();
                marca = arqComputador.readUTF();
                modelo = arqComputador.readUTF();
                processador = arqComputador.readUTF();
                quantMem = arqComputador.readInt();
                tamanhoTela = arqComputador.readUTF();
                quantEstoque = arqComputador.readInt();
                preco = arqComputador.readFloat();
                quantTotalVendida = arqComputador.readInt();
                quantUltimaVenda = arqComputador.readInt();
                dataUltimaVenda = arqComputador.readUTF();
                if (this.codComp.equalsIgnoreCase(codCompPesquisa) && ativo == 'S') {
                    return cursorFilePos;
                }
            }

        } catch (EOFException e) {
            return -1; // registro não encontrado
        } catch (IOException e) {
            System.out.println("ERRO: não foi possível abrir o arquivo - o programa será encerrado.");
            System.exit(0);
            return -1;
        }

    }

    public void salvarComputador() {

        try (RandomAccessFile arqComputador = new RandomAccessFile("COMPUTADOR.DAT", "rw")) {
            arqComputador.seek(arqComputador.length()); // coloca ponteiro no final do arquivo EOF
            arqComputador.writeChar(ativo);
            arqComputador.writeUTF(codComp);
            arqComputador.writeUTF(marca);
            arqComputador.writeUTF(modelo);
            arqComputador.writeUTF(processador);
            arqComputador.writeInt(quantMem);
            arqComputador.writeUTF(tamanhoTela);
            arqComputador.writeInt(quantEstoque);
            arqComputador.writeFloat(preco);
            arqComputador.writeInt(quantTotalVendida);
            arqComputador.writeInt(quantUltimaVenda);
            arqComputador.writeUTF(dataUltimaVenda);
            System.out.println("Dados gravados com sucesso.");
        } catch (IOException e) {
            System.out.println("Erro na abertura do arquivo - o programa será finalizado.");
            System.exit(0);
        }
    }

    public void desativarComputador(long pos) {
        try (RandomAccessFile arqComputador = new RandomAccessFile("COMPUTADOR.DAT", "rw")) {
            arqComputador.seek(pos);
            arqComputador.writeChar('N'); // desativar o registro antigo
        } catch (IOException e) {
            System.out.println("Erro na abertura do arquivo - o programa será finalizado.");
            System.exit(0);
        }
    }

    // ---------------------------- INCLUSAO ------------------------------

    public void incluir() {
        String codCompChave;
        char confirmacao;
        long regPos;

        do {
            Main.sc.nextLine();
            System.out.println("-".repeat(30) + "INCLUSAO DE COMPUTADOR" + "-".repeat(30));

            do {
                System.out.print("Digite o codigo do computador (ou 'FIM' para encerrar): ");
                codCompChave = Main.sc.nextLine();
                if (codCompChave.equalsIgnoreCase("FIM")) {
                    break;
                }
                regPos = pesquisarComputador(codCompChave);
                if (regPos >= 0) {
                    System.out.println("\nCodigo ja cadastrado, digite outro valor.\n");
                }
            } while (!consistirCodComp(codCompChave));

            ativo = 'S';
            codComp = codCompChave;

            do {
                System.out.print("Digite a marca do computador" + ".".repeat(12) + ": ");
                marca = Main.sc.nextLine();
                if (marca.equalsIgnoreCase("FIM")) {
                    break;
                }
            } while (!consistirMarca(marca, vetMarca));

            do {
                System.out.print("Digite a marca do computador" + ".".repeat(12) + ": ");
                modelo = Main.sc.nextLine();
            } while (!consistirModelo(modelo));

            do {
                System.out.print("Digite a marca do computador" + ".".repeat(12) + ": ");
                processador = Main.sc.nextLine();
            } while (!consistirProcessador(processador, vetProcessador));

            do {
                System.out.print("Digite a marca do computador" + ".".repeat(12) + ": ");
                quantMem = Main.sc.nextInt();
            } while (!consistirQuantMem(quantMem));

            do {
                System.out.print("Digite a marca do computador" + ".".repeat(12) + ": ");
                tamanhoTela = Main.sc.nextLine();
            } while (!consistirTamanhoTela(tamanhoTela, vetTamanhoTela));

            do {
                System.out.print("Digite a marca do computador" + ".".repeat(12) + ": ");
                quantEstoque = Main.sc.nextInt();
            } while (!consistirQuantEstoque(quantEstoque));

            do {
                System.out.print("Digite a marca do computador" + ".".repeat(12) + ": ");
                preco = Main.sc.nextFloat();
            } while (!consistirPreco(preco));

            quantTotalVendida = 0;
            quantUltimaVenda = 0;
            dataUltimaVenda = "";

            do {
                System.out.print("Confirma a gravação dos dados? (S/N)");
                confirmacao = Main.sc.next().toUpperCase().charAt(0);
                if (confirmacao == 'S') {
                    salvarComputador();
                }
            } while (confirmacao != 'S' && confirmacao != 'N');
        } while (!codCompChave.equalsIgnoreCase("FIM"));

    }


    public static boolean consistirCodComp(String codComp) {
       if (codComp == null || codComp.isEmpty()){
           System.out.println("Codigo invalido, não pode ser vazio.");
           return false;
       }

       for (int i = 0; i < codComp.length(); i++){
           if (Character.isDigit(codComp.charAt(i))){
               return true;
           } else {
               System.out.println("\nCodigo invalido, deve conter apenas numeros.");
               return false;
           }
       }

       return true;
    }

    public static boolean consistirMarca(String marca, String[] vetMarca){
        if (marca == null || marca.isEmpty()){
            System.out.println("Marca invalida, não pode ser vazia.");
            return false;
        }

        for (int i = 0; i < vetMarca.length; i++){
            if (marca.equalsIgnoreCase(vetMarca[i])){
                return true;
            } else {
                System.out.println("Marca inválida, deve ser: Dell, Lenovo, HP, Positivo, Asus, Apple ou IBM");
                return false;
            }

        }

        return true;

    }

    public static boolean consistirProcessador(String processador, String[] vetProcessador){
        if (processador == null || processador.isEmpty()){
            System.out.println("\nProcessador invalido, não pode ser vazio.\n");
            return false;
        }

        for (int i = 0; i < vetProcessador.length; i++){
            if (processador.equalsIgnoreCase(vetProcessador[i])){
                return true;
            } else {
                System.out.println("\nProcessador invalido, deve um dos seguintes processadores: Intel Core Ultra 3, Intel Core Ultra 5, Intel Core Ultra 7, Intel Core Ultra 9," +
                        "AMD Ryzen 5, AMD Ryzen 7, AMD Ryzen 9\n");
                return false;
            }
        }

        return false;
    }

    public static boolean consistirModelo(String modelo){
        if (!modelo.isEmpty()){
            return true;
        } else {
            return false;
        }
    }

    public static boolean consistirQuantMem(int quantMem){
        if (quantMem > 0 && quantMem <= 32){
            return true;
        } else {
            System.out.println("\nQuantidade de memória RAM invalida, deve ser entre 1 e 32.\n");
            return false;
        }

    }

    public static boolean consistirTamanhoTela(String tamanhoTela, String[] vetTamanhoTela){
        if (tamanhoTela == null || tamanhoTela.isEmpty()){
            System.out.println("Codigo invalido, não pode ser vazio.");
            return false;
        }

        for (int i = 0; i < tamanhoTela.length(); i++){
            if (Character.isDigit(tamanhoTela.charAt(i))){
                return true;
            } else {
                System.out.println("\nCodigo invalido, deve conter apenas numeros.");
                return false;
            }
        }

        for (int x = 0; x < vetTamanhoTela.length; x++){
            if (tamanhoTela.equalsIgnoreCase(vetTamanhoTela[x])){
                return true;
            } else {
                System.out.println("\nTamanho invalido, deve ser: 10, 12, 15, 20, 25, 28.\n");
                return false;
            }
        }

        return false;
    }

    public static boolean consistirQuantEstoque(int quantEstoque){
        if (quantEstoque > 0){
            return true;
        } else {
            System.out.println("\nQuantidade invalida, deve ser acima de 0.");
            return false;
        }
    }

    public static boolean consistirPreco(float preco){
        if (preco >= 1000 && preco <= 20000){
            return true;
        } else {
            System.out.println("\nPreço invalido, deve ser entre R$ 1,000 e 20,000.\n");
            return false;
        }
    }

    public static boolean consistirQuantUltimaVenda(int quantUltimaVenda, int quantEstoque){
        if (quantUltimaVenda <= quantEstoque){
            return true;
        } else {
            System.out.println("\nQuantidade invalida, deve ser menor ou igual a quantidade do estoque.\n");
            return false;
        }

    }

    public static boolean consistirData(String data) {
        // 1. Validação de Formato: Verifica se a data é nula ou se o formato básico está errado.
        //    Note o uso de '!=' e '&&' para as barras, pois ambas devem estar corretas.
        if (data == null || data.length() != 10 || data.charAt(2) != '/' || data.charAt(5) != '/') {
            System.out.println("\nFormato inválido. A data deve ser no formato DD/MM/AAAA.\n");
            return false;
        }

        // 2. Validação Numérica: Verifica se todas as partes da data contêm apenas dígitos.
        String diaStr = data.substring(0, 2);
        String mesStr = data.substring(3, 5);
        String anoStr = data.substring(6, 10);

        String digitosData = diaStr + mesStr + anoStr;
        for (int i = 0; i < digitosData.length(); i++) {
            if (!Character.isDigit(digitosData.charAt(i))) {
                System.out.println("\nData inválida. Dia, mês e ano devem conter apenas números.\n");
                return false;
            }
        }

        // 3. Conversão e Validação de Intervalos Básicos
        // Como já sabemos que são números, podemos converter com segurança.
        int dia = Integer.parseInt(diaStr);
        int mes = Integer.parseInt(mesStr);
        int ano = Integer.parseInt(anoStr);

        // Verifica se os valores são plausíveis (ex: mês não pode ser 13, dia não pode ser 0).
        if (ano <= 0 || mes < 1 || mes > 12 || dia < 1) {
            System.out.println("\nData impossível. Verifique os valores de dia, mês ou ano.\n");
            return false;
        }

        // 4. Validação do Dia do Mês (incluindo Anos Bissextos)
        // Esta lógica agora é alcançável e será executada.
        int maxDiaMes;
        switch (mes) {
            case 2: // Fevereiro
                if ((ano % 4 == 0 && ano % 100 != 0) || (ano % 400 == 0)) {
                    maxDiaMes = 29;
                } else {
                    maxDiaMes = 28;
                }
                break;
            case 4:
            case 6:
            case 9:
            case 11:
                maxDiaMes = 30;
                break;
            default:
                maxDiaMes = 31;
                break;
        }

        // Compara o dia fornecido com o máximo de dias calculado para aquele mês/ano.
        if (dia > maxDiaMes) {
            System.out.println("\nO dia " + dia + " não é válido para o mês " + mes + " do ano " + ano + ".\n");
            return false;
        }

        // 5. Sucesso!
        // Se o código chegou até aqui, significa que passou por todas as validações.
        return true;
    }

}