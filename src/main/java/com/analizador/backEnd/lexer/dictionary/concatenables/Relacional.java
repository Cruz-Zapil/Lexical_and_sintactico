package com.analizador.backEnd.lexer.dictionary.concatenables;

public enum Relacional {

    IGUAL("=="),
    DIFERENTE("!="),
    MAYOR(">"),
    MENOR("<"),
    MAYOR_IGUAL(">="),
    MENOR_IGUAL("<=");


    private String simbolo;

    private Relacional(String simbolo) {
        this.simbolo = simbolo;
    }

    public String getSimbolo() {
        return this.simbolo;
    }

    public static Relacional getRelacional(String lexer) {
        for (Relacional token : Relacional.values()) {
            if (token.getSimbolo().equals(lexer)) {
    
                return token;
            }
        }

        return null;
    }



}
