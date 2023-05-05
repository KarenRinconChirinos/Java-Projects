package com.nikki.poointerfaces.imprenta.modelo;

public class Pagina extends Hoja implements Imprimible  { // un libro contienevarias paginas y una pagina es una hoja

    public Pagina(String contenido) {
        super(contenido);
    }

    @Override
    public String imprimir() {
        return this.contenido;
    }
}
