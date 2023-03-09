package com.nikki.poointerfaces.repositorio;

public interface OrdenablePaginableCrudRepositorio <T> extends OrdenableRepositorio <T>
,PaginableRepositorio<T>,crudRepositorio <T>, ContableRepositorio {
    //extends somport herencia multiple de interfaces
    // se evita hacer los cast en la pagia princiapk
}
