package aula;

public class Pessoa {
    // Attributes
    private String nome;
    private int matricula;
    private boolean ativo;
    private Endereco end;

    // Constructor
    public Pessoa() {
        super();
        System.out.println("Construiu da Object.");
    }

    public Pessoa(String nome, int matricula, Endereco end) {
        super();
        this.setNome(nome);
        this.setMatricula(this.calcularMatricula(matricula));
        this.setAtivo(false);
        this.setEnd(end);
        System.out.println("Construiu da pessoa.");
    }

    // Getters and Setters
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

    public Endereco getEnd() {
        return end;
    }

    public void setEnd(Endereco end) {
        this.end = end;
    }




    @Override
    public String toString() {
        return "Pessoa [nome=" + nome +
                ", matricula=" + matricula
                + ", Cadastro ativo=" + (ativo ? "Sim" : "Não")+
                " , end=" + end
                + "]";
    }

    public int calcularMatricula(int matricula) {
        return matricula * 10;
    }
}