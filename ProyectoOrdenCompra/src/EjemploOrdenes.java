public class EjemploOrdenes {
    public static void main(String[] args) {
        //Orden 1
        Cliente cliente1 = new Cliente("Karen", "Rincon");
        Producto[] producto1 = {
                new Producto("Bimbo", "Donitas", 45),
                new Producto("Barcel", "Donitas", 15),
                new Producto("Fud", "Salchichas de pavo", 30),
                new Producto("McCornic", "Mayonesa", 25),
        };
        OrdenCompra ordenCompra1 = new OrdenCompra("Verificar el estado fisico de los productos");
        ordenCompra1.setCliente(cliente1);
        ordenCompra1.addProducto(producto1);
        System.out.println("ORDEN " + ordenCompra1.getIdentificador() + "\nFecha: " + ordenCompra1.getFecha());
        for(Producto p : ordenCompra1.getProductos()){
            System.out.println("Marca = " + p.getFabricante() + "  Nombre del producto: " + p.getNombre() + "  Precio del producto: " +p.getPrecio());
        }
        System.out.println("El total de compra de " + ordenCompra1.getCliente()+ " es de: "+ ordenCompra1.sumProducto());
        System.out.println("Descripcion de compra: " + ordenCompra1.getDescripcion());


        System.out.println("\n\n\n");


        //Orden 2
        Cliente cliente2 = new Cliente("Nikki", "Merlin");
        Producto[] producto2 = new Producto[4];
        producto2[0] = new Producto("Coca-cola", "Fanta 600ml", 15);
        producto2[1] = new Producto("Sonrix", "Paleta de caramelo", 5);
        producto2[2] = new Producto("Sabritas", "Sabritas", 15);
        producto2[3] = new Producto("Bimbo", "Panque de pasas", 35);
        OrdenCompra ordenCompra2 = new OrdenCompra("Verificar el empaque de de los productos");
        ordenCompra2.setCliente(cliente2);
        ordenCompra2.addProducto(producto2);
        System.out.println("ORDEN " + ordenCompra2.getIdentificador()  + "\nFecha: " + ordenCompra1.getFecha());
        for(Producto p : ordenCompra2.getProductos()){
            System.out.println("Marca = " + p.getFabricante() + "  Nombre del producto: " + p.getNombre() + "  Precio del producto: " +p.getPrecio());
        }
        System.out.println("El total de compra de " + ordenCompra2.getCliente()+ " es de: "+ ordenCompra2.sumProducto());
        System.out.println("Descripcion de compra: " + ordenCompra2.getDescripcion());




        System.out.println("\n\n\n");
        //Orden 3
        Cliente cliente3 = new Cliente("Mari", "Domo");
        Producto[] producto3 = new Producto[4];
        producto3[0] = new Producto("Coca-cola", "Coca cola 600ml", 15);
        producto3[1] = new Producto("Fud", "1/2 kg de jamon de pavo", 55);
        producto3[2] = new Producto("Holanda", "Cornetto", 25);
        producto3[3] = new Producto("Tia rosa", "Cuernito", 15);

        OrdenCompra ordenCompra3 = new OrdenCompra("Verificar caducidades de los productos");
        ordenCompra3.setCliente(cliente3);
        ordenCompra3.addProducto(producto3);
        System.out.println("ORDEN " + ordenCompra3.getIdentificador()  + "\nFecha: " + ordenCompra1.getFecha());
        for(Producto p : ordenCompra3.getProductos()){
            System.out.println("Marca = " + p.getFabricante() + "  Nombre del producto: " + p.getNombre() + "  Precio del producto: " +p.getPrecio());
        }
        System.out.println("El total de compra de " + ordenCompra3.getCliente()+ " es de: "+ ordenCompra3.sumProducto());
        System.out.println("Descripcion de compra: " + ordenCompra3.getDescripcion());
    }
}
