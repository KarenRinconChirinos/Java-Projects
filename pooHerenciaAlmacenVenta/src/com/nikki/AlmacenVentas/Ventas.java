package com.nikki.AlmacenVentas;

import java.util.Date;

public class Ventas extends Empleado {
    private int idVenta;
    private Date fecha;

    public Ventas(String nombre, int edad, String rfc, String area, double sueldo) {
        super(nombre, edad, rfc, area, sueldo);
    }

    public int getIdVenta() {
        return idVenta;
    }

    public void setIdVenta(int idVenta) {
        this.idVenta = idVenta;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
}
