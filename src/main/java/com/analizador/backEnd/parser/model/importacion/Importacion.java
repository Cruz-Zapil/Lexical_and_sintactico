package com.analizador.backEnd.parser.model.importacion;

import com.analizador.backEnd.lexer.Token;
import com.analizador.backEnd.lexer.almacenamieto.ListaEnlazada;

public class Importacion {

    int estado = 0;
    Modulos modulos = new Modulos();
    boolean pila = true;
    Token lexema;
    int poscionToken;

    public boolean scanImport(  ListaEnlazada listaLexema) {

        while (pila) {

                /// solicitar lexema
                this.lexema = listaLexema.eliminarPrimero();
              //  System.out.println(" deber ir un id: "+ this.lexema.getLexeme());              

            if (!modulos.scanModulos(this.lexema, this, listaLexema)) {
                /// solicitar siguente lexema
                return  false;
            }
        }
        return false;
    }
}
