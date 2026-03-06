package aula;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String nome;
        int matricula;
        Pessoa aluno = new Pessoa();

        do {
            System.out.print("Digite o nome do aluno: ");
            nome = sc.nextLine();
            if (nome.trim().isEmpty()) {
                System.out.println("Erro! Nome vazio, digite novamente!\n");
            } else {
                aluno.setNome(nome);
            }

            System.out.print("Digite o matricula do aluno: ");
            matricula = sc.nextInt();
            if (matricula <= 0) {
                System.out.println("Erro! Matricula invalida!\n");
            } else {
                aluno.setMatricula(matricula);
            }
        } while (nome.trim().isEmpty() && matricula <= 0);

        aluno.endereco = new Endereco("Av. do Contorno", 6061, "Sao Pedro");
        System.out.println(aluno);

        Endereco endProfessor = new Endereco("Rua Mangas", 200, "Mangabeiras");
        Pessoa professor = new Pessoa("Bob Ross", 12345, endProfessor);
        System.out.println(professor);
    }
}