import java.util.*;

public class exe_1_4 {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);

        float distKm;
        float tempoHoras;
        float velocidade;

        System.out.print("Digite a distancia em KM: ");
        distKm = sc.nextFloat();

        System.out.print("Digite o tempo em horas: ");
        tempoHoras = sc.nextFloat();

        velocidade = distKm / tempoHoras;

        System.out.println("A velocidade do veiculo e: " + velocidade + "km/h.");
    }
}
