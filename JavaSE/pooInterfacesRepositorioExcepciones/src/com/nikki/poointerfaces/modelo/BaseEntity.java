package com.nikki.poointerfaces.modelo;

import java.util.Objects;

public class BaseEntity {
    protected Integer id;
    private static int ultimoId;

    public BaseEntity(){
        this.id = ++ultimoId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }


    @Override
    public boolean equals(Object obj) {
        // metodo que compara los objetos por el id
        if(this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        BaseEntity base = (BaseEntity) obj;
        return Objects.equals(id, base.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}
