import java.util.Scanner;

public class SistemaEstadisticoArreglo {
    public static void main(String[] args) {
        /* Leer 7 números por teclado para llenar un arreglo y
        a continuación calcular el promedio de los números positivos,
         el promedio de los negativos y contar el número de ceros.*/

        Scanner scanner = new Scanner(System.in);
        int ceros = 0, negativos = 0, positivos = 0, sumNegativo = 0, sumPositivo = 0;
        int[] numeros = new int[7];
        for (int i = 0; i<numeros.length ; i++){
            System.out.print("Escribe numero " + (i+1)+ " para el arreglo ");
            numeros[i] =  scanner.nextInt();
            if(numeros[i] == 0){
                ceros++;
            }else if(numeros[i] < 0){
                negativos++;
                sumNegativo = sumNegativo + numeros[i];
            }else {
                positivos++;
                sumPositivo = sumPositivo + numeros[i];

            }
        }

        System.out.println("Promedio de 0: " + ceros);
        System.out.println("Promedio de negativos: " + sumNegativo/negativos);
        System.out.println("Promedio de positivos: " + sumPositivo/positivos);

    }
}
