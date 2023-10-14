package com.analizador.backEnd.parser.model.sentencia;

import com.analizador.backEnd.lexer.Token;
import com.analizador.backEnd.lexer.almacenamieto.ListaEnlazada;
import com.analizador.backEnd.lexer.dictionary.Constante;
import com.analizador.backEnd.lexer.dictionary.concatenables.Keyword;
import com.analizador.backEnd.lexer.dictionary.simples.Delimitador;
import com.analizador.backEnd.parser.model.sentencia.expresion.ExpresionRaiz;

public class SentenciaBucle {

    private Token lexema;
    private ExpresionRaiz expresionRaiz = new ExpresionRaiz();

    public boolean scanBucle(ListaEnlazada tmpListTokens) {

this.lexema = tmpListTokens.getPrimerElemento();
        System.out.println(this.lexema.getTokenType());

        this.lexema = tmpListTokens.eliminarPrimero();
        if (this.lexema.getTokenType().equals(Keyword.WHILE)) {

            if (expresionRaiz.scanExpresion(0, tmpListTokens)) {
                this.lexema = tmpListTokens.eliminarPrimero();
                if (this.lexema.getTokenType().equals(Delimitador.DOS_PUNTOS)) {

                    System.out.println(" ++++ se tiene que conectar con bloque ----");

                } else {
                    System.out.println(" se esperaba dos puntos en while ");
                    return false;
                }

            } else {
                System.out.println(" se esperaba una expresion en while");
                return false;
            }

        } else if (this.lexema.getTokenType().equals(Keyword.FOR)) {

            this.lexema = tmpListTokens.eliminarPrimero();
            if (this.lexema.getTokenType().equals(Constante.ID)) {

                this.lexema = tmpListTokens.eliminarPrimero();

                if (this.lexema.getTokenType().equals(Keyword.IN)) {

                    if (expresionRaiz.scanExpresion(0, tmpListTokens)) {
                        this.lexema = tmpListTokens.eliminarPrimero();

                        if (this.lexema.getTokenType().equals(Delimitador.DOS_PUNTOS)) {
                            /// viene bloque

                            System.out.println("+++ se tiene que concetar con bloque ++++");
                        } else {
                            /// se esperaba dos puntos
                            System.out.println(" se esperado dos puntos desde for ");
                            return false;
                        }
                    } else {
                        System.out.println(" se experaba una expresion bucle for ");
                        return false;
                    }
                } else {
                    System.out.println(" se esperaba un in for");

                    return false;
                }

            } else {
                System.out.println(" se esperaba una id ");
                return false;
            }

        } else {
            System.out.println(" no es bucle");
        }

        return false;
    }

}
