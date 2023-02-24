package com.nikki.pooHerencia;

public class Alumno extends Persona{
    private String institucion;
    private double notaMatematica;
    private double notaCastellano;
    private double notaHistoria;

    public Alumno(){
        super(); // se invoca de forma explicita  pero ya lo realiza de fomra no visible e implicita
        System.out.println("Alumno:  inicializando constructor");
    }

    public Alumno(String nombre , String apellido){
        super(nombre,apellido); //se llama al constructor del padre
    }

    public Alumno(String nombre, String apellido, int edad){
        super(nombre,apellido,edad); // de forma explicita
    }

    public Alumno(String nombre, String apellido, int edad, String institucion){
        this(nombre,apellido,edad); //invoca a un construcotr de la propia clase o podria llamarse directmente con el super
        this.institucion = institucion;
    }

    public Alumno(String nombre, String apellido, int edad, String institucion,
                  double notaCastellano, double notaHistoria, double notaMatematica){
        this(nombre,apellido,edad,institucion);
        this.notaCastellano =  notaCastellano;
        this.notaHistoria = notaHistoria;
        this.notaMatematica =  notaMatematica;
    }

    public String getInstitucion() {
        return institucion;
    }

    public void setInstitucion(String institucion) {
        this.institucion = institucion;
    }

    public double getNotaMatematica() {
        return notaMatematica;
    }

    public void setNotaMatematica(double notaMatematica) {
        this.notaMatematica = notaMatematica;
    }

    public double getNotaCastellano() {
        return notaCastellano;
    }

    public void setNotaCastellano(double notaCastellano) {
        this.notaCastellano = notaCastellano;
    }

    public double getNotaHistoria() {
        return notaHistoria;
    }

    public void setNotaHistoria(double notaHistoria) {
        this.notaHistoria = notaHistoria;
    }

    @Override
    public String saludar() {
        String saludarSuper = super.saludar(); //metodo invocado de la clase padre
        return saludarSuper + "\n Soy un alumno y mi nombre es " + getNombre();
    }

    public double calcularPromedio(){
        System.out.println("Promedio de "+Alumno.class.getCanonicalName() +": ");
        return (notaMatematica + notaHistoria + notaCastellano)/3;
    }

    @Override
    public String toString() {
        return super.toString() + "\ninstitucion='" + institucion + '\'' +
                ", notaMatematica=" + notaMatematica +
                ", notaCastellano=" + notaCastellano +
                ", notaHistoria=" + notaHistoria +
                ",promedio=" + this.calcularPromedio();
    }
}
