package com.analizador.backEnd.lexer.almacenamieto;

import com.analizador.backEnd.lexer.Token;

public class ListaEnlazadaBloque {
    private Nodo primero;
    private Nodo ultimo;

    public ListaEnlazadaBloque() {
        this.primero = null;
        this.ultimo = null;
    }

    public void insertarAlFinal(Token lexema) {
        Nodo nuevoNodo = new Nodo(lexema);
        if (ultimo == null) {
            primero = nuevoNodo;
            ultimo = nuevoNodo;
        } else {
            ultimo.setSiguiente(nuevoNodo);
            ultimo = nuevoNodo;
        }
    }

    public Token eliminarAlFinal() {
        if (ultimo == null) {
            System.out.println(" error ya no hay mas lexemas");
            return null;
        } else if (primero == ultimo) {
            Token valor = ultimo.getLexema();
            primero = null;
            ultimo = null;
            return valor;
        } else if (primero.getSiguiente() == ultimo) {
            Token valor = ultimo.getLexema();
            primero.setSiguiente(null);
            ultimo = primero;
            return valor;

        } else {
            Nodo nodoActual = primero;
            while (nodoActual.getSiguiente() != ultimo) {
                nodoActual = nodoActual.getSiguiente();
            }
            Token valor = ultimo.getLexema();
            nodoActual.setSiguiente(null);
            ultimo = nodoActual;
            return valor;
        }
    }

    public Token getUtltimo() {
        if (ultimo == null) {
            return null;
        } else {
            return ultimo.getLexema();
        }
    }

    public Nodo getPrimero() {
        if (primero == null) {
            return null;
        } else {

            return primero;
        }
    }

    public Token eliminarPrimero() {
        if (primero == null) {
            System.out.println("Error: La lista está vacía");
            return null;
        } else {
            Token valor = primero.getLexema();
            primero = primero.getSiguiente();
            if (primero == null) {
                ultimo = null; // Si la lista queda vacía después de eliminar el primero, también se actualiza
                               // 'ultimo'
            }
            return valor;
        }
    }

    public Token getSiguiente() {
        if (primero == null || primero.getSiguiente() == null) {
            // Si la lista está vacía o solo hay un elemento, no hay siguiente
            System.out.println(" lista vacia ");
            return null;
        } else {
            return primero.getSiguiente().getLexema();
        }
    }


}