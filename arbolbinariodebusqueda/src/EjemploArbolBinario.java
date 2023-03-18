public class EjemploArbolBinario {
    public static void main(String[] args) {
        int[] num =  {5,30,2,40,25,4};
        int cont = 0;
        int padre; //rama principal;
        int c;
        int izquierda = 0;
        int derecha = 0;

        if(izquierda > 0 ){
            System.out.println("s");
        }else{
            System.out.println("aaaa");
        }

        while(cont < num.length){
            padre = num[cont];
            System.out.println(padre); //
            if(num[cont] !=  0){
                if(cont+2 != 0){
                    c = 1;
                }else{
                    c = 2;
                }
                while( c <= cont+2){
                    if(num[cont+c] < padre) {
                        //menor - izquierda
                        izquierda = num[cont+c];
                    }else{
                        //mayor - derecha
                        derecha = num[cont+c];
                    }
                    c++;
                }
                cont+=c;
                System.out.println(izquierda + "  " + derecha);
            }else{
               break;
            }
        }
    }
}
