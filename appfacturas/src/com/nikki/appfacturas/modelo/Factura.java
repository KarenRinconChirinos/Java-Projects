package com.nikki.appfacturas.modelo;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Factura {
    private int folio;
    private String descripcion;
    private Date fecha;
    private Cliente cliente;
    private static final int MAX_ITEMS = 10;
    private ItemFactura[] itemFacturas;
    private int indiceItemFactura; // nos ayuda a incrementar los indices del arreglo
    private static int ultimoFolio;

    public Factura(String descripcion, Cliente cliente) {
        this.descripcion = descripcion;
        this.cliente = cliente;
        this.itemFacturas = new ItemFactura[MAX_ITEMS];
        this.folio = ++ultimoFolio;
        this.fecha = new Date();
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public int getFolio() {
        return folio;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public ItemFactura[] getItemFacturas() {
        return itemFacturas;
    }

    public void addItemFactura(ItemFactura itemFactura){
        if (indiceItemFactura < MAX_ITEMS) {
            this.itemFacturas[indiceItemFactura++] = itemFactura;
        }
    }

    public float calcularTotal(){
        float total = 0.0f;
        for(int i = 0; i<this.itemFacturas.length; i++ ){
            if(itemFacturas[i] == null){
                continue;
            }
            total+= itemFacturas[i].calcularImporte();
        }
        return total;
    }

    public String generarDetalle(){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd  MMMM, yyyy");
        String detalle = "\nFactura No°: " + folio;
        detalle += "\nfolio: " + folio;
        detalle += "\nCliente: " + cliente.getNombre();
        detalle += "\nNumero fiscal: " + cliente.getNumFiscal();
        detalle += "\nDescripcion: " + descripcion;
        detalle += "\n";
        detalle += "\n";
        detalle += "\n#\tNombre\t$\tCant.\tTotal\n";

        for(ItemFactura item: this.itemFacturas){
            if(item == null){
                continue;
            }
            /*
                    detalle += "\n"+ item.getProducto().getCodigo()+"\t"+
                    item.getProducto().getNombre()+"\t"+
                    item.getProducto().getPrecio()+"\t"+
                    item.getCantidad()+"\t"+
                    item.calcularImporte()+"\n";*/
            detalle += item + "\n"; //invoca a los metodos string
        }

        detalle += "\n\nFecha de emision: " + simpleDateFormat.format(this.fecha);
        detalle += "\nTotal de compra: " + calcularTotal();
        return detalle;
    }

    @Override
    public String toString() {
        return generarDetalle();
    }
}

