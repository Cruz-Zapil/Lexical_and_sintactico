package com.analizador.backEnd.parser.model.importacion;

import com.analizador.backEnd.lexer.Token;
import com.analizador.backEnd.parser.model.Raiz;

public class Importacion {

    int estado = 0;
    Modulos modulos = new Modulos();
    boolean pila = true;
    Token lexema;

    public boolean scanImport(Token lexema, Raiz raiz) {

        /// solicitar siguente lexema
        /// se envia el siguente lexema
        while (pila) {

            if (pila) {
                /// solicitar lexema
                this.lexema = lexema;

            }

            if (!modulos.scanModulos(this.lexema, this)) {
                /// solicitar siguente lexema
                pila = false;

                System.out.println(" hay problemas");
            }
        }

        return false;

    }

}
