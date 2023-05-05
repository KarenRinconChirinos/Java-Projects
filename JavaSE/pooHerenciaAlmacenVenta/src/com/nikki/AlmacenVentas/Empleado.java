package com.nikki.AlmacenVentas;

public class Empleado extends Persona {
    private String rfc;
    private String area;
    private double sueldo;

    public Empleado(String nombre, int edad) {
        super(nombre, edad);
    }

    public Empleado(String nombre, int edad, String rfc, String area, double sueldo) {
        super(nombre, edad);
        this.rfc = rfc;
        this.area = area;
        this.sueldo = sueldo;
    }

    public String getRfc() {
        return rfc;
    }

    public void setRfc(String rfc) {
        this.rfc = rfc;
    }

    public String getArea() {
        return area;
    }

    public void setArea(String area) {
        this.area = area;
    }

    public double getSueldo() {
        return sueldo;
    }

    public void setSueldo(double sueldo) {
        this.sueldo = sueldo;
    }
}
