package com.analizador.backEnd.lexer.almacenamieto;

import com.analizador.backEnd.lexer.Token;


public class Nodo {

    private Token lexema;
    private Nodo siguiente;
    
    public Nodo(Token lexema) {
        this.lexema = lexema;
        this.siguiente = null;
    }

    public Token getLexema() {
        return lexema;
    }

    public void setLexema(Token valor) {
        this.lexema= lexema;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
}
