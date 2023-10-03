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
            return ultimo.getLexema();
        }
    }

    public Nodo getPrimero() {
        if (primero == null) {
            return null;
        }else {

            return primero;
        }
    }

    public Token obtenerTokenEnPosicion(int posicion) {
        Nodo current = primero;
        int indice = 0;
    
        while (current != null) {
            if (indice == posicion) {
                return current.getLexema(); // Accede al token utilizando el método getToken
            }
            current = current.getSiguiente();
            indice++;
        }
    
        return null;  // La posición no se encontró en la lista
    }

    public int obtenerPosicionDeToken(Token tokenBuscado) {
        Nodo current = primero;
        int posicion = 0;
        
        while (current != null) {
            if (current.getLexema().equals(tokenBuscado)) {
                return posicion; // Token encontrado, devuelve la posición actual
            }
            current = current.getSiguiente();
            posicion++;
        }
        
        return -1;  // El token no se encontró en la lista
    }
    


    

}
