package com.analizador.backEnd.lexer.almacenamieto;

public class NodoBloque {
    private ListaEnlazada subLista; // Referencia a otra lista enlazada
    private Nodo siguiente;

    public NodoBloque() {
        this.subLista = new ListaEnlazada(); // Inicializa la sublista enlazada
        this.siguiente = null;
    }

    public ListaEnlazada getSubLista() {
        return subLista;
    }

    public Nodo getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(Nodo siguiente) {
        this.siguiente = siguiente;
    }
}
