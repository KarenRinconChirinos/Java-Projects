import java.util.Date;

public class OrdenCompra {
    private int identificador;
    private static int idUltimo;
    private String descripcion;
    private Date fecha;
    private Cliente cliente;
    private Producto[] productos;

    public OrdenCompra(String descripcion) {
        this.descripcion = descripcion;
        this.identificador = ++idUltimo;
        this.productos = new Producto[4];
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getFecha() {
        fecha = new Date();
        return fecha;
    }

    public String getCliente() {
        return cliente.getApellido()+ " " + cliente.getNombre();
    }

    public Producto[] getProductos() {
        return productos;
    }

    public Integer getIdentificador() {
        return identificador;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void addProducto( Producto[] productos){ //va agregar un arreglo de productos
        this.productos = productos;
    }

    public int  sumProducto(){
        int total = 0;
        for (int i = 0; i<productos.length; i++){
            total +=productos[i].getPrecio();
        }
        return total;
    }
}


