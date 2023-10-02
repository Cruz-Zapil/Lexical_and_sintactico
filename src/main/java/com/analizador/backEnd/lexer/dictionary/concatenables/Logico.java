package com.analizador.backEnd.lexer.dictionary.concatenables;

public enum Logico {

    AND("and"),
    OR("or"),
    NOT("not");

    private String simbolo;

    private Logico(String simbolo) {
        this.simbolo = simbolo;
    }

    public static Logico getLogico(String lexer) {
        for (Logico token : Logico.values()) {

            if (token.getSimbolo().equals(lexer)) {
                return token;
            }
        }
        
        return null;
    }

    public String getSimbolo() {
        return this.simbolo;
    }

}
