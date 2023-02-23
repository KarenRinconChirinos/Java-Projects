import java.util.Scanner;

public class Ordenarelarregloúltimoprimero {
    public static void main(String[] args) {
        /*
            Leer 10 números enteros desde el teclado para llenar un arreglo de 10
            elementos. Luego debemos mostrarlos en el siguiente orden: el último,
            el primero, el penúltimo, el segundo, el antepenúltimo, el tercero,
            y así sucesivamente.
        */
        int[] numeros = new int[10];
        Scanner scanner = new Scanner(System.in);
        for(int i = 0; i < numeros.length; i++){
            System.out.print("Ingresa el numero " + i +": ");
            numeros[i] = scanner.nextInt();
        }

        int primero, ultimo;
        int a,j;
        j = 1;
        a = 0;
        while(a <= numeros.length/2 ){
            ultimo = numeros[numeros.length-1];
            primero = numeros[a];
            for(int m = numeros.length-1; m>=j ; m--){
                numeros[m+1] = numeros[m];
            }
            numeros[a] = ultimo;
            numeros[a+1] = primero;
            j++;
            a+=2;
        }

        for(int i = 0; i< numeros.length; i++){
            System.out.println(numeros[i]);
        }
    }
}
