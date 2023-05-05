import java.util.Scanner;

public class MayorOcurrenciaArreglo {
    public static void main(String[] args) {
        /*Para la tarea se debe crear un arreglo con 10 elementos (enteros en el rango de 1 a 9).
         Escriba un programa que imprima el número que tiene más ocurrencias en el arreglo y
         también imprimir la cantidad de veces que aparece en el arreglo.

            Por ejemplo, para el arreglo: {1, 2, 3, 3, 4, 5, 5, 5, 6, 7}

        Como resultado debería imprimir lo siguiente:
        La mayor ocurrencias es: 3
        El elemento que mas se repite es: 5
        En el ejemplo, el elemento que más se repite en el arreglo es el número 5 con una ocurrencia de 3 veces.*/

        Scanner scanner =  new Scanner(System.in);
        int [] numero  = new int[10];
        int [] numeroCopia  = new int[10];

        for (int i = 0; i< numero.length; i++){
            System.out.print("Introduce el numero " + i + " del arreglo: ");
            numero[i] = scanner.nextInt();
            if(numero[i]<1 || numero[i]>9){
                System.out.print("Repite el numero " + i + " del arreglo: ");
                numero[i] = scanner.nextInt();
            }
        }


        int cont;
        for (int i = 0; i< numero.length; i++){
            cont = 0;
            for (int j = 0; j< numero.length; j++){
                if(numero[i] == numero[j]){
                    cont++;
                }
            }
            numeroCopia[i] = cont;
        }

        int indice = 0;
        int mayor = 0;
        for (int i = 0; i< numero.length; i++){
            if (mayor < numero[i]){
                indice = i;
            }
        }

        System.out.println("La mayor concurrencia es: " + numeroCopia[indice]);
        System.out.println("El elemento que mas se repite es: " + numero[indice]);
        System.out.println("el elemento que más se repite en el arreglo es el numero "+ numero[indice] +" con una ocurrencia de "+ numeroCopia[indice] +" veces ");



    }
}
