package com.analizador.backEnd.parser.model.sentenciaVaraible;

import com.analizador.backEnd.lexer.Token;
import com.analizador.backEnd.lexer.dictionary.concatenables.OperadorAsignacion;
import com.analizador.backEnd.parser.model.importacion.Modulos;

public class ExpresionV {

    int estado = 0;
    Modulos modulos = new Modulos();
    boolean pila = true;
    Token lexema;

    public boolean scanExpresion(Token lexema, SentenciaV sentencia) {

        /// solicitar siguente lexema

        if (lexema.getClaseToken().equals("Asignacion")) {
            

        }

        return pila;

    }

}
