package com.nikki.pooHerencia.Compania;

public class Gerente extends Empleado{
    private Double presupuesto;

    public Gerente(String nombre, String apellido, Double remuneracion){
        super(nombre, apellido, remuneracion);
    }

    public Double getPresupuesto() {
        return presupuesto;
    }

    public void setPresupuesto(Double presupuesto) {
        this.presupuesto = presupuesto;
    }

    @Override
    public String toString() {
        return super.toString() +
                "\nPresupuesto = " + presupuesto ;
    }
}
