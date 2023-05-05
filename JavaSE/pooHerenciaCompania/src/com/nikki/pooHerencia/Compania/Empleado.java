package com.nikki.pooHerencia.Compania;

public class Empleado extends Persona{
    private Double remuneracion;
    private int empleadoId;
    private static int id = 0;

    public Empleado(String nombre, String apellido, Double remuneracion){
        super(nombre,apellido);
        this.remuneracion = remuneracion;
        this.empleadoId = id++ ;
    }


    public Double getRemuneracion() {
        return remuneracion;
    }

    public void setRemuneracion(Double remuneracion) {
        this.remuneracion = remuneracion;
    }

    public int getEmpleadoId() {
        return empleadoId;
    }

    public void setEmpleadoId(int empleadoId) {
        this.empleadoId = empleadoId;
    }

    public void aumentarRemuneracion (int porcentaje){
        this.remuneracion +=  remuneracion * porcentaje/100;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nMi remuneracion = " + remuneracion +
                "\nEmpleadoId = " + empleadoId ;
    }
}
