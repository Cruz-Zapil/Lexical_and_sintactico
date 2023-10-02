package com.analizador.backEnd.parser.model.estados;

import com.analizador.backEnd.lexer.Token;
import com.analizador.backEnd.lexer.dictionary.Constante;

public class Def {

    boolean pila = false;
    int estado = 0;
    Parametros parametros = new Parametros();

    public boolean probando(Token lexema) {

        switch (estado) {
            case 0:

                if (lexema.getLexeme().equals(Constante.ID)) {
                    estado++;
                    return true;
                }

                break;

            case 1:

                if (lexema.getLexeme().equals("(")) {
                    estado++;
                    return true;
                }

                break;

            case 2:
                if (parametros.scanParametros(lexema, this)) {
                    pila = true;
                    estado++;
                    return true;
                }

                break;

            case 4:

                break;

            case 5:

            default:
                break;
        }
        return false;

    }

    public boolean isPila() {
        return pila;
    }

    public void setPila(boolean pila) {
        this.pila = pila;
    }

    public int getEstado() {
        return estado;
    }

    public void setEstado(int estado) {
        this.estado = estado;
    }

}
