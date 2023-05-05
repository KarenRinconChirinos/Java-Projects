import java.util.Scanner;

public class ImprimirNumeroAltoArreglo {
    /*Escriba un programa que imprima el número más alto de un arreglo de
     7 elementos (de rango 11 a 99), por ejemplo {14, 33, 15, 36, 78, 21, 43}
     , si se repite un valor considerar uno solo.*/
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] numeros = new int[7];
        for (int i = 0; i<numeros.length ; i++){
            noPermitido:

            System.out.print("Escribe numero " + (i+1)+ " que sea de un rango entre 11 a 99: ");
            numeros[i] =  scanner.nextInt();
            if(numeros[i]<=11 || numeros[i]>=99){
                System.out.println("Numero no permitido");
                System.out.print("Escribe numero " + i + " que sea de un rango entre 11 a 99: ");
                numeros[i] =  scanner.nextInt();
            }else{
                continue;
            }
        }

        int mayor = numeros[0];
        for (int i = 1; i < numeros.length; i++){
            if(numeros[i] >= mayor){
                mayor = numeros[i];
            }
        }
        System.out.println("El numero mas grande del arreglo es: " + mayor);
    }
}
