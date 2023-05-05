package com.nikki.AlmacenVentas;

public class ArticulosLimpieza  extends  Productos{
    private double litros;
    private String componentes;

    public ArticulosLimpieza(String lugar) {
        super(lugar);
    }

    public ArticulosLimpieza(String lugar, String nombre, int cantidad, String descripcion, double precio, double litros, String componentes) {
        super(lugar, nombre, cantidad, descripcion, precio);
        this.litros = litros;
        this.componentes = componentes;
    }

    public double getLitros() {
        return litros;
    }

    public void setLitros(double litros) {
        this.litros = litros;
    }

    public String getComponentes() {
        return componentes;
    }

    public void setComponentes(String componentes) {
        this.componentes = componentes;
    }
}
