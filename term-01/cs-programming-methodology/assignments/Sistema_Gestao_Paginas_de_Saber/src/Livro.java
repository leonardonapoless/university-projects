import java.util.*;
import java.io.*;

public class Livro {
    char ativo;
    String codLivro;
    String titulo;
    String autor;
    String editora;
    String genero;
    int anoPublicacao;
    int quantEstoque;
    float preco;
    int quantTotalVendida;
    int quantUltimaVenda;
    String dtUltimaVenda;

    static String[] vetEditoras = { "Rocco", "Companhia das Letras", "Sextante", "Intrinseca", "Record", "Aleph" };
    static String[] vetGeneros = { "Ficcao Cientifica", "Fantasia", "Romance", "Suspense", "Biografia", "Autoajuda" };


    // PESQUISA
    public long pesquisarLivro(String codLivroPesquisa){
        long fileCursorPos = 0;

        try (RandomAccessFile livroFile = new RandomAccessFile("LIVROS.DAT", "rw")) {
            while (true) {
                fileCursorPos = livroFile.getFilePointer(); // posição do inicio da arquivo no registro

                ativo = livroFile.readChar();
                codLivro = livroFile.readUTF();
                titulo = livroFile.readUTF();
                autor = livroFile.readUTF();
                editora = livroFile.readUTF();
                genero = livroFile.readUTF();
                anoPublicacao = livroFile.readInt();
                quantEstoque = livroFile.readInt();
                preco = livroFile.readFloat();
                quantTotalVendida = livroFile.readInt();
                quantUltimaVenda = livroFile.readInt();
                dtUltimaVenda = livroFile.readUTF();

                if (this.codLivro.equalsIgnoreCase(codLivroPesquisa) && ativo == 'S') {
                    return fileCursorPos;
                }
            }
        } catch (EOFException e){
            return -1; // registro não foi encontrado

        } catch (IOException e) {
            System.out.println("Erro na abertura do arquivo - o programa será finalizado.");
            System.exit(0);
            return -1;
        }
    }

    public void salvarLivro(){
        try (RandomAccessFile livroFile = new RandomAccessFile("LIVROS.DAT", "rw")){
            livroFile.seek(livroFile.length());

            livroFile.writeChar(ativo);
            livroFile.writeUTF(codLivro);
            livroFile.writeUTF(titulo);
            livroFile.writeUTF(autor);
            livroFile.writeUTF(editora);
            livroFile.writeUTF(genero);
            livroFile.writeInt(anoPublicacao);
            livroFile.writeInt(quantEstoque);
            livroFile.writeFloat(preco);
            livroFile.writeInt(quantTotalVendida);
            livroFile.writeInt(quantUltimaVenda);
            livroFile.writeUTF(dtUltimaVenda);

            System.out.println("Dados salvos com sucesso!\n");

        } catch (IOException e){
            System.out.println("Errp na abertura do arquivo - o programa será finalizado.");
            System.exit(0);
        }
    }

    public void desativarLivro(long posicao){
        try (RandomAccessFile livroFile = new RandomAccessFile("LIVROS.DAT", "rw")){
            livroFile.seek(posicao);
            livroFile.writeChar('N');
        } catch (IOException e){
            System.out.println("Erro na abertura do arquivo - o programa será finalizado.");
            System.exit(0);
        }
    }

    public void incluir(){
        String codLivroChave;
        char confirmacao;
        long regPos;

        do {
            Main.sc.nextLine();
            System.out.println("\n *************** Inclusão de Livros *************** ");
            System.out.print("Digite o codigo do livro ('FIM' para encerrar): ");
            codLivroChave = Main.sc.nextLine();

            if (codLivroChave.equalsIgnoreCase("FIM")){
                break;
            }
            regPos = pesquisarLivro(codLivroChave);

            if (regPos >= 0){
                System.out.println("Livro já cadastrado, digite outro código.\n");
            }
        } while(regPos >= 0);

//        if (codLivroChave.equalsIgnoreCase("FIM")){
//            break;
//        }

        ativo = 'S';
        codLivro = codLivroChave;

        do {
            System.out.print("Digite o titulo do livro: ");
            titulo = Main.sc.nextLine();
        } while(!consistirTitulo(titulo));

        do {
            System.out.print("Digite o nome do autor: ");
            autor = Main.sc.nextLine();
        } while(!consistirAutor(autor));

        do {
            editora = Main.sc.nextLine();
        } while (!consistirEditora(editora));

        do {
            System.out.print("Digite o genero do livro: ");
            genero = Main.sc.nextLine();
        } while (!consistirGenero(genero));

        do {
            System.out.print("Digite o ano de publicação: ");
            anoPublicacao = Main.sc.nextInt();
        } while(!consistirAnoPublicacao(anoPublicacao));

        do {
            System.out.print("Digite a quantidade do livro no estoque: ");
            quantEstoque = Main.sc.nextInt();
        } while (!consistirQuantEstoque(quantEstoque));

        do {
            System.out.print("Digite o preço do livro: R$ ");
            preco = Main.sc.nextFloat();
        } while (!consistirPreco(preco));

//        do {
//            System.out.print("Digite a quantidade total vendida: ");
//            quantTotalVendida = Main.sc.nextInt();
//        } while (!consistirQuantTotalVendida(quantTotalVendida));

        do {
            System.out.print("Digite a quantidade de exemplares vendidos na ultima transação: ");
            quantUltimaVenda = Main.sc.nextInt();
        } while(!consistirQuantUltimaVenda(quantUltimaVenda));

        do {
            System.out.print("Digite a data da ultima venda (DD/MM/AAAA): ");
            dtUltimaVenda = Main.sc.nextLine();
        } while (!consistirData(dtUltimaVenda));


    }



    public void alterar(){
        String codLivroChave;
        char confirmacao;
        long regPos= -1;
        byte opcao;




    }

    public void consultar(){

    }

    public void excluir(){

    }









    public static boolean consistirTitulo(String titulo){
        if (titulo == null || titulo.isEmpty()){
            return false;
        }

        return true;
    }

    public static boolean consistirEditora(String editora){
        if (editora == null || editora.trim().isEmpty()){
            return false;
        }

        for (String editoraList : vetEditoras){
            if (!editora.equalsIgnoreCase(editoraList)){
                return false;
            }
        }

        return true;
    }

    public static boolean consistirAutor(String autor){
        if (autor == null || autor.trim().isEmpty() || autor.length() < 10){
            return false;
        }

        return true;
    }

    public static boolean consistirGenero(String genero){
        if (genero == null || genero.trim().isEmpty()){
            return false;
        }

        for (String generoList : vetGeneros){
            if (!genero.equalsIgnoreCase(generoList)){
                System.out.println("Genero do livro invalido, digite: Ficcao Cientifica, " +
                        "Fantasia, Romance, Suspense, Biografia ou Autoajuda");
                return false;
            }
        }

        return true;
    }

    public static boolean consistirAnoPublicacao(int ano){
        if (ano < 1800 && ano > 2025){
            System.out.println("\nAno invalido, digite um ano entre 1800 e 2025.\n");
            return false;
        }

        return true;
    }

    public static boolean consistirQuantEstoque(int quant){
        if (quant < 1){
            System.out.println("\nA quantidade no estoque deve ser maior que 0.\n");
            return false;
        }

        return true;
    }

    public static boolean consistirQuantUltimaVenda(int quant){
        if (quant < 1){
            System.out.println("Quantidade invalida, deve ser maior que 0.");
            return false;
        }

        return true;
    }

    public static boolean consistirPreco(float preco){
        if (preco < 10 && preco > 500){
            System.out.println("\nValor invalido, o preço deve estar entre R$10 e R$500.");
            return false;
        }

        return true;
    }

    public static boolean consistirData(String data){
        // --- PASSO 1: CHECAR O FORMATO BÁSICO ---

        // Se o texto for nulo ou vazio, já é inválido.
        if (data == null || data.trim().isEmpty()){
            return false;
        }

        // O formato "DD/MM/AAAA" deve ter exatamente 10 caracteres.
        if (data.length() != 10){
            return false;
        }

        // As barras devem estar nas posições corretas (posição 2 e 5).
        if (data.charAt(2) != '/' || data.charAt(5) != '/'){
            return false;
        }

        // --- PASSO 2: EXTRAIR DIA, MÊS E ANO COMO NÚMEROS ---
        int dia, mes, ano;

        // Usamos "try-catch" como uma rede de segurança.
        // Se tentarmos converter um texto como "ab" para número, um erro acontece.
        // O "catch" impede que o programa quebre e nos deixa retornar 'false'.
        try {
            // Usamos "substring" para pegar cada pedaço da data.
            dia = Integer.parseInt(data.substring(0,2)); // pega o dia DD
            mes = Integer.parseInt(data.substring(3,5)); // pega o mes MM
            ano = Integer.parseInt(data.substring(6,10)); // pega o ano AAAA
        } catch (NumberFormatException e){
            // Se a conversão falhar, os caracteres não eram números.
            return false;
        }


        // --- PASSO 3: VALIDAR AS REGRAS DO CALENDÁRIO ---

        // O ano não pode ser zero ou negativo.
        if (ano <= 0){
            return false;
        }

        // O mês deve estar entre 1 e 12.
        if (mes < 1 || mes > 12){
            return false;
        }

        // O dia deve estar entre 1 e 31.
        if (dia < 1 || dia > 31) {
            return false;
        }

        // Verificando a quantidade de dias para meses específicos.
        // Meses com 30 dias: Abril (4), Junho (6), Setembro (9), Novembro (11).
        if ((mes == 4 || mes == 6 || mes == 9 || mes == 11) && dia != 30) {
            return false;
        }

        // Verificação para o mês de Fevereiro (mês 2).
        // A lógica do ano bissexto está embutida aqui.
        if (mes == 2){
            // A regra do ano bissexto é: (divisível por 4 E não por 100) OU (divisível por 400).
            boolean isAnoBissexto = ((ano % 4 == 0) && (ano % 100 != 0) || (ano % 400 == 0));

            if (isAnoBissexto){
                // Se for bissexto, Fevereiro pode ter até 29 dias.
                if (dia > 29){
                    return false;
                }
            } else {
                // Se não for bissexto, Fevereiro só pode ter até 28 dias.
                if (dia > 28){
                    return false;
                }
            }

        }

        return true;
    }
}
