package aula;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        // Create Object
        Pessoa aluno = new Pessoa();
        aluno.nome = "Leonardo";
        aluno.matricula = aluno.calcularMatricula(65);
        System.out.println(aluno);

        // CO
        Pessoa professor = new Pessoa("Leonardo", 12345);
        professor.nome = "Leonardo";
        System.out.println(professor);
    }
}