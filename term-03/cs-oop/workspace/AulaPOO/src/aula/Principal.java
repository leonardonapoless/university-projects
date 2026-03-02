package aula;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // Create Object
        Pessoa aluno = new Pessoa();
        aluno.nome = "Leonardo";
        aluno.matricula = aluno.calcularMatricula(65);
        aluno.endereco = new Endereco("Av. do Contorno", 6061, "Sao Pedro");
        System.out.println(aluno);

        Endereco endProfessor = new Endereco("Rua Mangas", 200, "Mangabeiras");
        Pessoa professor = new Pessoa("Leonardo", 12345, endProfessor);
        System.out.println(professor);
    }
}