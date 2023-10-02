package com.analizador.backEnd.lexer.almacenamieto;

import com.analizador.backEnd.lexer.Token;

public class ListaEnlazada {
    private Nodo primero;
    private Nodo ultimo;

    public ListaEnlazada() {
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
            return null;
        } else if (primero == ultimo) {
            Token valor = ultimo.getValor();
            primero = null;
            ultimo = null;
            return valor;
        } else if (primero.getSiguiente() == ultimo) {
            Token valor = ultimo.getValor();
            primero.setSiguiente(null);
            ultimo = primero;
            return valor;

        } else {
            Nodo nodoActual = primero;
            while (nodoActual.getSiguiente() != ultimo) {
                nodoActual = nodoActual.getSiguiente();
            }
            Token valor = ultimo.getValor();
            nodoActual.setSiguiente(null);
            ultimo = nodoActual;
            return valor;
        }
    }

    public void eliminarAlFinal1() {
        if (ultimo == null) {
            System.out.println(" Erroooooor : ya no hay mas objetos");
        } else if (primero == ultimo) {
            primero = null;
            ultimo = null;

        } else {
            Nodo nodoActual = primero;
            while (nodoActual.getSiguiente() != ultimo) {
                nodoActual = nodoActual.getSiguiente();
            }
            nodoActual.setSiguiente(null);
            ultimo = nodoActual;

        }
    }

    public Token obtenerUltimo() {
        if (ultimo == null) {
            return null;
        } else {
            return ultimo.getValor();
        }
    }

    public Nodo getPrimero() {
        if (primero == null) {
            return null;
        }else {

            return primero;
        }
    }

}
