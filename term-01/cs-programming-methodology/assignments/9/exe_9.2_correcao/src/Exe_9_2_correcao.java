import java.util.*;

public class Exe_9_2_correcao {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        String codigo;
        boolean valido;
        do {
            System.out.print("Digite o codigo: ");
            codigo = sc.next();
            valido = true;
            if (codigo.length() != 11){
                System.out.println("Codigo invalido, digite 11 caracteres");
                valido = false;
            } else {
                for (byte x = 0; x <= 10; x++) {
                    if (codigo.charAt(x) < 'A' || codigo.charAt(x) > '9') {
                        System.out.println("Codigo invalido, digite o codigo contendo apenas numeros de 0-9");
                        valido = false;
                        break;
                    }
                }

//                for (byte x = 0; x <= 10; x++){
//                    if (Character.digit(codigo.charAt(x), 10) == -1){
//                        System.out.println("Codigo invalido, digite o codigo contendo apenas numeros de 0-9");
//                        valido = false;
//                        break;
//                    }
//
//                }
            }
        }while (!valido);


        if (calcularDigitoVerificador(codigo).equalsIgnoreCase(codigo.substring(9))){
           System.out.println("Digitos corretos!");
        } else {
            System.out.println("Digitos invalidos!");
        }



    }

    public static String calcularDigitoVerificador(String cod){
        int dig1, dig2;
        int soma = 0;
        int mult = 1;
        String multSTR;
        char dig2Char;
        for (int x = 0; x <= 8; x++){
            soma = soma + Character.digit(cod.charAt(x), 10);
            mult = mult * Character.digit(cod.charAt(x), 10);
        }

        dig1 = soma / 10;
        dig2 = mult % 10;
        return dig1 + "" + dig2;

//        multSTR = String.valueOf(mult);
//        dig2Char = multSTR.charAt(multSTR.length() - 1);
//        dig2 = Character.forDigit(dig2Char, 10);

    }
}
