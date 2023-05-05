package com.nikki.java.jdbc.modelo;

import java.util.Date;

public class Producto {
    private Long id;
    private String nomnbre;
    private Integer precio;
    private Date fechaRegistro;
    private Categoria categoria;
    private String sku;


    public Producto() {
    }

    public Producto(Long id, String nomnbre, Integer precio, Date fechaRegistro) {
        this.id = id;
        this.nomnbre = nomnbre;
        this.precio = precio;
        this.fechaRegistro = fechaRegistro;
    }

    @Override
    public String toString() {
        return id + " | " + nomnbre
                + " | " + precio
                + " | " + fechaRegistro
                + " | " + categoria.getNombre()
                + " | " + sku;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNomnbre() {
        return nomnbre;
    }

    public void setNomnbre(String nomnbre) {
        this.nomnbre = nomnbre;
    }

    public Integer getPrecio() {
        return precio;
    }

    public void setPrecio(Integer precio) {
        this.precio = precio;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }
}
