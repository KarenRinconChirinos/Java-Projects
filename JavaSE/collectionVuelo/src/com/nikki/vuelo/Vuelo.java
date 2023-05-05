package com.nikki.vuelo;

import java.util.Date;

public class Vuelo {
    private String nombre;
    private String origen;
    private String destino;
    private Date fechaLlegada;
    private Integer cantidadPasajeros;

    public Vuelo() {
    }

    public Vuelo(String nombre, String origen, String destino, Date fechaLlegada, Integer cantidadPasajeros) {
        this.nombre = nombre;
        this.origen = origen;
        this.destino = destino;
        this.fechaLlegada = fechaLlegada;
        this.cantidadPasajeros = cantidadPasajeros;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getOrigen() {
        return origen;
    }

    public void setOrigen(String origen) {
        this.origen = origen;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public Date getFechaLlegada() {
        return fechaLlegada;
    }

    public void setFechaLlegada(Date fechaLlegada) {
        this.fechaLlegada = fechaLlegada;
    }

    public Integer getCantidadPasajeros() {
        return cantidadPasajeros;
    }

    public void setCantidadPasajeros(Integer cantidadPasajeros) {
        this.cantidadPasajeros = cantidadPasajeros;
    }

    @Override
    public String toString() {
        return "Vuelo: " + nombre +
                " Origen: " + origen +
                " Destino: " + destino +
                " FechaLlegada: " + fechaLlegada +
                " Cantidad de Pasajeros: " + cantidadPasajeros;
    }
}
