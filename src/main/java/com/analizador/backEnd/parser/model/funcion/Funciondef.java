package com.analizador.backEnd.parser.model.funcion;

import com.analizador.backEnd.lexer.Token;
import com.analizador.backEnd.lexer.almacenamieto.ListaEnlazada;
import com.analizador.backEnd.lexer.dictionary.Constante;
import com.analizador.backEnd.lexer.dictionary.simples.Delimitador;

public class Funciondef {

    int estado = 0;
    Parametros parametros = new Parametros();
    Bloque bloque = new Bloque();
    boolean pila = true;
    Token lexema;

    public boolean scanFuncionDef( ListaEnlazada listLexer) {

        this.lexema = listLexer.eliminarPrimero();
        System.out.println("se espera ID: " + this.lexema.getLexeme());

        if (this.lexema.getTokenType().equals(Constante.ID)) {

            /// obtener el siguente token
            this.lexema = listLexer.eliminarPrimero();
            System.out.println(" se espera (: " + this.lexema.getLexeme());

            /// analicisi de abierto
            if (!this.lexema.getTokenType().equals(Delimitador.PARENTESIS_ABIERTO)) {
                System.out.println(" error de sintaxys");
                /// desapilarlo y seguir con el siguente
            }

            //// enviar parametros parametros
            parametros.scanParametros(this.lexema, listLexer);

            //// analisis de cierre
            this.lexema = listLexer.eliminarPrimero();
            System.out.println(" se espera ): " + this.lexema.getLexeme());

            if (!this.lexema.getTokenType().equals(Delimitador.PARENTESIS_CIERRE)) {
                System.out.println(" error de sitaxys");
            }

            /// obtener dos puntos
            this.lexema = listLexer.eliminarPrimero();
            System.out.println(" se espera :: " + this.lexema.getLexeme());
            if (this.lexema.getTokenType().equals(Delimitador.DOS_PUNTOS)) {

                conectarBloque(listLexer);

            } else {
                System.out.println(" error de sintaxys");

            }

        } else {
            System.out.println(" error sintactico");
        }

        return false;
    }

    /// conectar con bloque

    public void conectarBloque(ListaEnlazada listLexer) {

        //// viene bloque se coniecta con bloque:
        if (!bloque.secanBloque( listLexer)) {
            
        }

    }

}
