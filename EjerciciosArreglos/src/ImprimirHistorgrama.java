import java.util.Scanner;

public class ImprimirHistorgrama {
        /*
        * Escribir un programa que recorra un arreglo y genere un histograma en base a los valores de este.
        * El arreglo debe contener 12 elementos que corresponden a números enteros de rango 1 al 6.
        * Un histograma es una representación gráfica (de puntos o barra) de que tanto un elemento
        * aparece en un conjunto de datos, es decir debe mostrar la frecuencia para todos los números
        *  del 1 al 6, incluso si no están presente en el arreglo.
*/
        public static void main(String[] args) {
            Scanner scanner = new Scanner(System.in);
            int[] numeros = new int[12];
            for (int i = 0; i < numeros.length; i++) {
                System.out.print("Ingrese un numero " + (i + 1) + " de 1 a 6: ");
                numeros[i] = scanner.nextInt();
                if (numeros[i] < 1 || numeros[i] > 6) {
                    System.out.print("Reingrese un numero " + (i + 1) + " de 1 a 6: ");
                    numeros[i] = scanner.nextInt();
                }
            }


            String[] histograma = new String[6];
            for (int i = 0; i < histograma.length; i++) {
                int aux = i + 1;
                String histo = aux + ": ";
                for (int j = 0; j < numeros.length; j++) {
                    if (aux == numeros[j]) {
                        histo += "*";
                    }
                }
                histograma[i] = histo;
            }

            for (int i = 0; i < histograma.length; i++) {
                System.out.println(histograma[i]);
            }
        }
}
