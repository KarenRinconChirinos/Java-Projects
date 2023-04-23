package com.nikkianotaciones.ejemplo;

import java.lang.annotation.*;

//target - lugar donde se ocupa esta antoacion
@Target(ElementType.FIELD) //field se refiere a clase
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface JsonAtributo {
    //atributos de configuracionpropies de la metadata
    String nombre() default "";
    boolean capitalizar() default false;

}
