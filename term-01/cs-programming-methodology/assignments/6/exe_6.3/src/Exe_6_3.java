import java.util.*;

public class Exe_6_3 {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);

        float custoProduto[] = new float[3];
        int quantProd[][] = new int[3][3];
        int contCusto;
        int contArmazem;
        int contProduto = 0;
        int armMaiorNumProd = 0;
        int maiorNumProd = 0;
        int totalArmazem = 0;
        float custoTotal = 0;

        for (contCusto = 0; contCusto < 3; contCusto++){
            System.out.print("Digite o custo do produto " + (contCusto+1) + ": ");
            custoProduto[contCusto] = sc.nextFloat();

            for(contArmazem = 0; contArmazem < 3; contArmazem++){
                System.out.print("Digite a quantidade do produto " + (contProduto+1) +
                        " no armazem " + (contArmazem+1) + ": ");
                quantProd[contArmazem][contProduto] = sc.nextInt();
            }
        }



        for (contArmazem = 0; contArmazem < 3; contArmazem++){
            totalArmazem = 0;

            for (contProduto = 0; contProduto < 3; contProduto++){
                totalArmazem = totalArmazem + quantProd[contArmazem][contProduto];
            }

            if (totalArmazem > maiorNumProd){
                maiorNumProd = totalArmazem;
                armMaiorNumProd = contArmazem + 1;
            }

        }

        for (contArmazem = 0; contArmazem < 3; contArmazem++){
            for (contProduto = 0; contProduto < 3; contProduto++){
                custoTotal = quantProd[contArmazem][contProduto] * custoProduto[contProduto];

            }
        }

        System.out.println("\nArmazem com maior numero de produtos: " + armMaiorNumProd);
        System.out.println("Custo total do estoque: R$" + custoTotal);

        System.out.println("            | Produto 1 | Produto 2 | Produto 3 |  ");
        System.out.println("-----------------------------------------------------------");
        for (contArmazem = 0; contArmazem < 3; contArmazem++){
            System.out.print("\nArmazem " + (contArmazem+1) + " | ");
            System.out.print("----- ");
            for (contProduto = 0; contProduto < 3; contProduto++){
                System.out.print(quantProd[contArmazem][contProduto] + "  -------  ");
            }

            System.out.println();
        }

        }
    }