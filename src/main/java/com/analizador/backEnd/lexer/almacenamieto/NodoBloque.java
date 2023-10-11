package com.analizador.backEnd.lexer.almacenamieto;

public class NodoBloque {


    private ListaEnlazada subLista; // Referencia a otra lista enlazada
    private NodoBloque siguiente;

    public NodoBloque() {
        this.subLista = new ListaEnlazada(); // Inicializa la sublista enlazada
        this.siguiente = null;
    }

    public ListaEnlazada getSubLista() {
        return subLista;
    }

    public NodoBloque getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoBloque siguiente) {
        this.siguiente = siguiente;
    }

}
