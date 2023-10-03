package com.analizador.backEnd.parser.model.importacion;

import com.analizador.backEnd.lexer.Token;
import com.analizador.backEnd.lexer.almacenamieto.ListaEnlazada;
import com.analizador.backEnd.parser.model.Auxiliar;
import com.analizador.backEnd.parser.model.Raiz;

public class Importacion {

    int estado = 0;
    Modulos modulos = new Modulos();
    boolean pila = true;
    Token lexema;

    ListaEnlazada lista;

    public boolean scanImport(Token lexema, Raiz raiz, ListaEnlazada listaLexema) {

        /// solicitar siguente lexema
        /// se envia el siguente lexema
        while (pila) {

            if (pila) {
                /// solicitar lexema

                Auxiliar.siguenteLexema()

                this.lexema = lexema;

            }

            if (!modulos.scanModulos(this.lexema, this)) {
                /// solicitar siguente lexema
                pila = false;

                
            }
        }

        return false;

    }

}
