package com.nikki.poointerfaces.repositorio;

public interface OrdenablePaginableCrudRepositorio extends OrdenableRepositorio
,PaginableRepositorio,crudRepositorio, ContableRepositorio {
    //extends somport herencia multiple de interfaces
    // se evita hacer los cast en la pagia princiapk
}
