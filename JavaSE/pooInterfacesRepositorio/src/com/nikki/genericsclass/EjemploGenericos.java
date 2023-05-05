package com.nikki.genericsclass;

public class EjemploGenericos {
    public  static <T> void imprimirCamion(Camion<T> camion){
        for (T o: camion){
            if( o instanceof Automovil){
                System.out.println("Marca: " + ((Automovil) o).getMarca());
            }else if(o instanceof Animal){
                System.out.println("Nombre: " + ((Animal) o).getNombre() + "\nTipo: " + ((Animal) o).getTipo());
            }else if(o instanceof Maquinaria){
                System.out.println("Tipo: " + ((Maquinaria) o).getTipo());
            }
        }
    }

    public static void main(String[] args) {
        Camion<Animal> transportarCaballos = new Camion<>(5);
        transportarCaballos.add(new Animal("Guapo", "Caballo"));
        transportarCaballos.add(new Animal("Milagroso", "Caballo"));
        transportarCaballos.add(new Animal("Rapi", "Caballo"));
        transportarCaballos.add(new Animal("Tiro al blanco", "Caballo"));
        transportarCaballos.add(new Animal("Azabache", "Caballo"));
        imprimirCamion(transportarCaballos);

        Camion<Maquinaria> transportarMaquinaria = new Camion<>(3);
        transportarMaquinaria.add(new Maquinaria("Bulldozer"));
        transportarMaquinaria.add(new Maquinaria("Perfordora"));
        transportarMaquinaria.add(new Maquinaria("Grua Horquilla"));
        imprimirCamion(transportarMaquinaria);


        Camion<Automovil> transportarAutos = new Camion<>(3);
        transportarAutos.add(new Automovil("Mazda"));
        transportarAutos.add(new Automovil("Chevrolet"));
        transportarAutos.add(new Automovil("Toyota"));
        /*
        for (Automovil o: transportarAutos){
            //Automovil a = (Automovil) o; // s epodria equivocar en algun tipo lo que ocaionari errores e
        }*/
        imprimirCamion(transportarAutos);
    }
}
