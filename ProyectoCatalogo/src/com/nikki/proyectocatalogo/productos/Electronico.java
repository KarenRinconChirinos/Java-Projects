package com.nikki.proyectocatalogo.productos;

abstract public class Electronico extends Productos implements IElectronico{
    private String fabricante;

    public Electronico(int precio) {
        super(precio);
    }

    public Electronico(int precio, String fabricante) {
        super(precio);
        this.fabricante = fabricante;
    }

    @Override
    public double getPrecioVenta() {
        return super.getPrecioVenta();
    }

    @Override
    public String getFabricante() {
        return fabricante;
    }

    public void setFabricante(String fabricante) {
        this.fabricante = fabricante;
    }

}
