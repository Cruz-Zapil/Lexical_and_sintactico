package com.analizador.backEnd.lexer.dictionary.simples;



public enum Delimitador {
    
    PARENTESIS_ABIERTO("("),
    PARENTESIS_CIERRE(")"), 
    LLAVE_ABIERTA("{"),
    LLAVE_CIERRE("}"),
    CORCHETE_ABIERTO("["),
    CORCHETE_CIERRE("]"),
    PUNTO_COMA(";"),
    DOS_PUNTOS(":"),
    PUNTO("."),
    COMA(","),
    ASIGNACION("="),
    LAMBDA("->"),
    ARROBA("@");
    
    private String simbolo;

    private Delimitador(String simbolo) {
        this.simbolo = simbolo;
    }

    public static Delimitador getDelimitador(String simbolo) {
        for (Delimitador simboloEnum : Delimitador.values()) {
            if (simboloEnum.getSimbolo().equals(simbolo)) {
                return simboloEnum;
            }
        }
        return null;
    }

    public String getSimbolo() {
        return simbolo;
    }

 

}
