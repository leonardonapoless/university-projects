// Leonardo Nápoles


import java.util.*;

public class Exe_1_5 {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);

        float medidaPes;
        float medidaPolegadas;
        float medidaJardas;
        float medidaMilhas;
        float medidaCm;

        System.out.print("Digite a medida em pes: ");
        medidaPes = sc.nextFloat();

        medidaPolegadas = medidaPes * 12;
        medidaJardas = medidaPes / 3;
        medidaMilhas = (float) (medidaPes / 0.3);
        medidaCm = (float) (medidaPes * 30.48);

        System.out.println("Polegadas: " + medidaPolegadas + "\n" +
                "Centimetros: " + medidaCm + "\n" + "Jardas: " +
                medidaJardas + "\n" + "Milhas: " + medidaMilhas);
    }
}
