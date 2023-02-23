import java.util.Scanner;

public class EjemploArregloMultiImprimirX {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Introduce el tamanio del arreglo: ");
        int n = scanner.nextInt();
        if (n == 0 ){
            System.out.println("ERROR");
            System.exit(0);
        }
        String[][] nxn = new String[n][n];

        int aux = nxn.length-1;
        int  aux2 = 0;
        for(int i = 0; i< nxn.length;i++){
            for(int j = 0; j< nxn[i].length; j++){
                if(i == j ){
                    nxn[i][j] = "x";
                }else if(i ==  aux2  && j == aux){
                    nxn[i][j] = "x";
                }else{
                    nxn[i][j] = "_";
                }
            }
            aux--;
            aux2++;
        }


        for(int i = 0; i< nxn.length;i++){
            for(int j = 0; j< nxn[i].length; j++){
                System.out.print(nxn[i][j] + " \t");
            }
            System.out.println();
        }

    }

}
