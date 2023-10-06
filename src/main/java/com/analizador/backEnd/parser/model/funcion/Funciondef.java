package com.analizador.backEnd.parser.model.funcion;

import org.stringtemplate.v4.compiler.CodeGenerator.region_return;

import com.analizador.backEnd.lexer.Token;
import com.analizador.backEnd.lexer.almacenamieto.ListaEnlazada;
import com.analizador.backEnd.lexer.dictionary.Constante;
import com.analizador.backEnd.lexer.dictionary.simples.Delimitador;
import com.analizador.backEnd.parser.model.Raiz;

public class Funciondef {

    int estado = 0;
    Parametros parametros = new Parametros();
    Bloque bloque = new Bloque();
    boolean pila = true;
    Token lexema;

    public boolean scanFuncionDef(Token lexema, Raiz Raiz, ListaEnlazada listLexer) {

        this.lexema = listLexer.eliminarPrimero();
        System.out.println("se espera ID: " + this.lexema.getLexeme());

        if (this.lexema.getTokenType().equals(Constante.ID)) {

            /// obtener el siguente token
            this.lexema = listLexer.eliminarPrimero();
            System.out.println(" se espera (: " + this.lexema.getLexeme());

            /// analicisi de abierto
            if (!this.lexema.getTokenType().equals(Delimitador.PARENTESIS_ABIERTO)) {
                System.out.println(" error de sintaxys");
            }

            //// parametros

            this.lexema = listLexer.eliminarPrimero();
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

                //// viene bloque se coniecta con bloque:
                if (!bloque.secanBloque(this.lexema, listLexer)) {

                    return false;

                }

            } else {
                System.out.println(" error de sintaxys");

            }

        } else {
            System.out.println(" error sintactico");
        }

        return false;
    }

}
