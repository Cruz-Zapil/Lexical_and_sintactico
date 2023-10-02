package com.analizador.backEnd.parser.model;

import com.analizador.backEnd.lexer.Token;

public class Madre {

    boolean pila = false;
    int estaodo =0;
    Token lexema;

    public Madre (Token lexema){
        
        this.lexema = lexema;
    }


    public boolean isPila() {
        return pila;
    }
    public void setPila(boolean pila) {
        this.pila = pila;
    }
    public int getEstaodo() {
        return estaodo;
    }
    public void setEstaodo(int estaodo) {
        this.estaodo = estaodo;
    }

    
}
