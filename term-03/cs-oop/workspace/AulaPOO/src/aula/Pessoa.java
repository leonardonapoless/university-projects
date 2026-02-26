package aula;

public class Pessoa {
    // Attributes
    public String nome;
    public int matricula = 1226;
    public boolean ativo;

    // Constructor
    public Pessoa() {
        super();
        System.out.println("Construiu da Object.");
    }

    public Pessoa(String nome, int matricula) {
        super();
        this.nome = nome;
        this.matricula = matricula;
        this.ativo = true;
        System.out.println("Construiu da pessoa.");
    }

    // Methods
    @Override
    public String toString() {
        return "Pessoa [nome=" + nome + ", matricula=" + matricula + ", ativo=" + ativo + "]";
    }

    public int calcularMatricula(int matricula) {
        return matricula * 10;
    }
}