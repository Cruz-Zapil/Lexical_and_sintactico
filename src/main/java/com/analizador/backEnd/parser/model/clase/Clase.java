package com.analizador.backEnd.parser.model.clase;

import com.analizador.backEnd.lexer.Token;
import com.analizador.backEnd.lexer.almacenamieto.ListaEnlazada;
import com.analizador.backEnd.parser.model.Raiz;

public class Clase {
    int estado =0;

    boolean pila = true;
    Token lexema;
    int poscionToken;

    

    public void scanClase(Token lexema, Raiz raiz, ListaEnlazada listaLexema) {
        
        /// se solicito el siguente lexema
        
        while(pila){
            
            this.lexema = listaLexema.eliminarPrimero();

            if (pila) {
                
            }

        }

    }
    
}
