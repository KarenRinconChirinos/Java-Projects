package com.nikki.AlmacenVentas;

public class Productos extends  Almacen{
    private String nombre;
    private int cantidad;
    private String descripcion;
    private double precio;

    public Productos(String lugar) {
        super(lugar);
    }

    public Productos(String lugar, String nombre, int cantidad, String descripcion, double precio) {
        super(lugar);
        this.nombre = nombre;
        this.cantidad = cantidad;
        this.descripcion = descripcion;
        this.precio = precio;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }
}
