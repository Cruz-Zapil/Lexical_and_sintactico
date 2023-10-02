package com.analizador.backEnd.lexer.dictionary.concatenables;

public enum OperadorDoble {

    
    INCREMENTO("++"),
    EXPONENTE("**"),
    DECREMENTO("--");

    private String simbolo;

    private OperadorDoble(String simbolo) {
        this.simbolo = simbolo;
    }

    public static OperadorDoble getOperadorDoble(String simbolo) {
        for (OperadorDoble operador : OperadorDoble.values()) {
            if (operador.getSimbolo().equals(simbolo)) {
                return operador;
            }
        }
        // Si no se encuentra, puedes devolver un valor por defecto o lanzar una excepción, según tus necesidades.
        throw new IllegalArgumentException("No se encontró un enum con el símbolo: " + simbolo);
    }

    public String getSimbolo() {
        return simbolo;
    }  

 

}
