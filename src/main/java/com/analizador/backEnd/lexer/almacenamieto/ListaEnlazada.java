package com.analizador.backEnd.lexer.almacenamieto;

import java.util.ArrayList;
import java.util.List;

import com.analizador.backEnd.lexer.Token;

public class ListaEnlazada {
    private Nodo primero;
    private Nodo ultimo;
    private Nodo nodoActual;

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

    /// obtener el primero y eliminala de la lista

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



    public List<Token> getDatos() {
        List<Token> datos = new ArrayList<>();
        Nodo nodoActual = primero; // Comenzamos desde el primer nodo (cabeza)
        
        while (nodoActual != null) {
            // Agregar el valor del nodo actual a la lista de datos
            datos.add(nodoActual.getLexema());

            // Mover al siguiente nodo
            nodoActual = nodoActual.getSiguiente();
        }

        return datos;
    }

    public boolean estaVacia() {
        return primero == null;
    }
    
    public Token getPrimerElemento() {
        if (estaVacia()) {
            System.out.println("La lista está vacía, no hay elementos para obtener.");
            return null;
        }
    
        return getPrimero().getLexema();
    }


public void reiniciarRecorrido() {
    nodoActual = primero;
}

public Token obtenerSiguiente() {
    if (nodoActual == null) {
        System.out.println("La lista está vacía o no hay un siguiente token disponible.");
        return null;
    } else {
        Token siguienteToken = nodoActual.getLexema();
        nodoActual = nodoActual.getSiguiente();
        return siguienteToken;
    }
}

    

}
