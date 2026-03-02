package aula;

public class Endereco {
    public String rua;
    public int numero;
    public String bairro;

    public Endereco(String rua, int numero, String bairro) {
        super();
        this.rua = rua;
        this.numero = numero;
        this.bairro = bairro;
    }

    @Override
    public String toString() {
        return "Endereco [rua=" + rua + ", numero=" + numero + ", bairro=" + bairro + "]";
    }
}
