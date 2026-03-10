package aula;

public class Endereco {
    private String rua;
    private int numero;
    private String bairro;

    public Endereco(String rua, int numero, String bairro) {
        super();
        this.setRua(rua);
        this.setNumero(numero);
        this.setBairro(bairro);
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        if (rua.isBlank())
            System.out.println("Rua vazia. Digite novamente.");
        else
            this.rua = rua;
    }

    public int getNumero() {
        return numero;
    }

    public void setNumero(int numero) {
        if (numero < 0)
            System.out.println("Número inválido, não pode ser negativo. Digite Novamente!");
        else
            this.numero = numero;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    @Override
    public String toString() {
        return "Endereco{" +
                "rua='" + rua + '\'' +
                ", numero=" + numero +
                ", bairro='" + bairro + '\'' +
                '}';
    }
}