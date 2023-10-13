package com.analizador.backEnd.lexer.dictionary.concatenables;

public enum OperadorAsignacion {

    ASIGNACION("="),
    ASIGNACION_SUMA("+="),
    ASIGNACION_RESTA("-="),
    ASIGNACION_MULTIPLICACION("*=");

    private String simbolo;

    private OperadorAsignacion(String simbolo) {
        this.simbolo = simbolo;
    }

    public String getSimbolo() {
        return this.simbolo;
    }

    public static OperadorAsignacion getAsignacion(String cadena) {
        for (OperadorAsignacion a : OperadorAsignacion.values()) {
            if (a.getSimbolo().equals(cadena)) {
         
                return a;
            }
        }
        return null;
    }

}
