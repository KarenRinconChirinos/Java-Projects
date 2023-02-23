import java.util.Scanner;

public class EjemploArreglosDesplazarPosicion {
    public static void main(String[] args) {
        int[] elementos = new int[7];
        Scanner scanner = new Scanner(System.in);

        //introducir numeros
        for(int i = 0; i<elementos.length-1; i++){
            System.out.print("Introduce el numero " + i +" del arreglo: ");
            elementos[i] = scanner.nextInt();
        }

        //acomodar
        for(int i = 0; i< elementos.length-1; i++){
            for(int j = i+1; j<elementos.length-1; j++){
                if(elementos[i] > elementos[j]){
                    int anteriori, anteriorj;
                    anteriori = elementos[i];
                    anteriorj = elementos[j];
                    elementos[i] = anteriorj;
                    elementos[j] = anteriori;

                }else{
                    continue;
                }
            }
        }

        //imprimir
        for(int i = 0; i<elementos.length-1; i++) {
            System.out.println(elementos[i]);
        }

        int insertarElemento, posicion;
        System.out.println("Ingresa el numero: ");
        insertarElemento = scanner.nextInt();


        //buscar posicion
        int i = 0;
        for(; i<elementos.length-1; i++){
            if(insertarElemento <= elementos[i]){
                break;
            }
        }
        System.out.println("posicion = " + i);

        //meter en posicion y recorrer
        for(int j = elementos.length-2; j>= i ; j--){
            elementos[j+1] = elementos[j];
        }
        elementos[i] = insertarElemento;

        //imprimir
        for(int k = 0; k<elementos.length; k++) {
            System.out.println(elementos[k]);
        }

    }
}
