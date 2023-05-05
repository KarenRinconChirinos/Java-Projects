package com.nikki.almacenverduleria;

public class Lacteo extends  Producto{
    private int cantidad;
    private int proteinas;

    public Lacteo(int cantidad, int proteinas) {
        this.cantidad = cantidad;
        this.proteinas = proteinas;
    }

    public Lacteo(int cantidad, int proteinas, String nombre, double precio) {
        this(cantidad,proteinas);
        this.nombre = nombre;
        this.precio = precio;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public int getProteinas() {
        return proteinas;
    }

    public void setProteinas(int proteinas) {
        this.proteinas = proteinas;
    }
}
