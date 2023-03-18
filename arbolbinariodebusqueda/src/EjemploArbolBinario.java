public class EjemploArbolBinario {
    public static void main(String[] args) {
        int[] num =  {5,30,2,40,25,4};
        int cont = 0;
        int padre; //rama principal;
        int c;
        int izquierda = 0;
        int derecha = 0;

        while(cont < num.length){
            padre = num[cont];
            c = 1;
            System.out.println(padre); //
            if(num[cont] !=  0){
                while( c <= cont+2){
                    if(padre < num[cont+c]) {
                        //menor - izquierda
                        izquierda = num[cont+c];
                    }else{
                        //mayor - derecha
                        derecha = num[cont+c];
                    }
                    if(num[cont+c] > num[cont+3]){
                        padre = num[cont+c];
                    }
                    c++;
                }
                System.out.println(izquierda + "  " + derecha);
            }else{
               break;
            }
            cont++;
        }
    }
}
