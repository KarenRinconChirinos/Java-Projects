package com.nikki.pooHerencia;

public final class AlumnoInternacional extends Alumno{
    /*Final - > evita modificiaciones en la clae y no va poder heredad*/
    private String pais;
    private double notaidiomas;

    public AlumnoInternacional(){
        System.out.println("Alumno Internacional:  inicializando constructor");
    }

    public AlumnoInternacional(String nombre, String apellido){
        super(nombre,apellido);
    }

    public AlumnoInternacional(String nombre, String apellido, String pais){
        this(nombre,apellido);
        this.pais =  pais;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public double getNotaidiomas() {
        return notaidiomas;
    }

    public void setNotaidiomas(double notaidiomas) {
        this.notaidiomas = notaidiomas;
    }

    @Override
    public String saludar() {
        return super.saludar() + " del pais  " + getPais() ;
    }

    @Override
    public double calcularPromedio() {
        //System.out.println("Promedio de "+AlumnoInternacional.class.getCanonicalName() +": ");
        return ((super.calcularPromedio() * 3 )+ notaidiomas)/4;
    }

    @Override
    public String toString() {
        return  super.toString() +
                "\npais='" + pais + '\'' +
                ", notaidiomas=" + notaidiomas;
    }
}
