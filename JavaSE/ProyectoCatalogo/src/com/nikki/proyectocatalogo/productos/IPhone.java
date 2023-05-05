package com.nikki.proyectocatalogo.productos;

public class IPhone extends Electronico implements IProducto{
    private Color color;
    private String modelo;

    public IPhone(int precio, String fabricante, Color color, String modelo) {
        super(precio, fabricante);
        this.color = color;
        this.modelo = modelo;
    }

    public IPhone(int precio) {
        super(precio);
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }
}
