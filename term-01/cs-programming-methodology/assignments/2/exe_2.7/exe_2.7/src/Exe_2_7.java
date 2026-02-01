// Leonardo Nápoles

import java.util.*;

public class Exe_2_7 {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        float pesoKg;
        float alturaMetros;
        float imcCalc;
        float pesoIdealMin;
        float pesoIdealMax;

        System.out.print("Digite o peso em do atleta em KG: ");
        pesoKg = sc.nextFloat();
        System.out.print("Digite a altura do atleta em metros: ");
        alturaMetros = sc.nextFloat();

        imcCalc = pesoKg / (alturaMetros * alturaMetros);
        pesoIdealMin = 20 * (alturaMetros * alturaMetros);
        pesoIdealMax = 25 * (alturaMetros * alturaMetros);

        if(imcCalc < 20) {
            System.out.println("Situacao: abaixo do peso.");
            System.out.println("Peso Minimo = " + pesoIdealMin +
                    " e Peso Maximo = " + pesoIdealMax);
        } else if(imcCalc >= 20 && (imcCalc <= 25)){
            System.out.println("Situacao: peso ideal.");
            System.out.println("Peso Minimo = " + pesoIdealMin +
                    " e Peso Maximo = " + pesoIdealMax);
        } else {
            System.out.println("Situacao = acima do peso.");
            System.out.println("Peso Minimo = " + pesoIdealMin +
                    " e Peso Maximo = " + pesoIdealMax);
        }
    }
}