package com.analizador.backEnd.lexer.almacenamieto;

public class ListaEnlazadaBloque {
    private NodoBloque primero;
    private NodoBloque ultimo;

    public ListaEnlazadaBloque() {
        this.primero = null;
        this.ultimo = null;
    }

    /// crear una sub lista

    public void crearSubLista() {
        NodoBloque nuevoNodo = new NodoBloque();
        if (ultimo == null) {
            primero = nuevoNodo;
            ultimo = nuevoNodo;
        } else {
            ultimo.setSiguiente(nuevoNodo);
            ultimo = nuevoNodo;
        }

    }

    /// insertar en una sub lista
    


}