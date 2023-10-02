package com.analizador.backEnd.lexer.dictionary.simples;

public enum Aritmetico {

    SUMA("+"),
    RESTA("-"),
    EXPONENTE("^"),
    MODULO("%"),
    MULTIPLICACION("*"),
    DIVISION("/");

    private String simbolo;

    private Aritmetico(String simbolo) {
        this.simbolo = simbolo;
    }

    public static Aritmetico getAritmetico(String lexer) {
        for (Aritmetico aritmetico : Aritmetico.values()) {
            if (aritmetico.getSimbolo().equals(lexer)) {
                return aritmetico;
            }
        }
        // Si no se encuentra, puedes devolver un valor por defecto o lanzar una
        // excepción, según tus necesidades.
        throw new IllegalArgumentException("No se encontró un enum con el símbolo: " 
        + lexer);
    }

    public String getSimbolo() {
        return simbolo;
    }

}
