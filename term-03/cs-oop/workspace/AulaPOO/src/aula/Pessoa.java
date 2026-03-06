package aula;

public class Pessoa {
    // Attributes
    private String nome;
    public int matricula;
    public boolean ativo;
    public Endereco endereco;

    // Constructor
    public Pessoa() {
        super();
        System.out.println("Construiu da Object.");
    }

    public Pessoa(String nome, int matricula, Endereco endereco) {
        super();
        this.nome = nome;
        this.matricula = matricula;
        this.ativo = true;
        this.endereco = endereco;
        System.out.println("Construiu da pessoa.");
    }

    // Methods
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getMatricula() {
        return matricula;
    }

    public void setMatricula(int matricula) {
        this.matricula = matricula;
    }

    public boolean isAtivo() {
        return ativo;
    }

    public void setAtivo(boolean ativo) {
        this.ativo = ativo;
    }

    @Override
    public String toString() {
        return "Pessoa [nome=" + nome + ", matricula=" + matricula + ", ativo=" + ativo + " , endereco=" + endereco
                + "]";
    }

    public int calcularMatricula(int matricula) {
        return matricula * 10;
    }
}