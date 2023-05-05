package com.nikki.ejemploexcepciones;

public class DivisionPorZeroException extends Exception {
    // heredan exception osea toda las clase checked y unchecked
    public DivisionPorZeroException(String message) {
        // se crea un constructor  y se invoca al constructor de la superclase
        super(message);
    }
}
