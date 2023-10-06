package com.analizador.backEnd.lexer;

import com.analizador.backEnd.lexer.dictionary.*;
import com.analizador.backEnd.lexer.dictionary.concatenables.*;
import com.analizador.backEnd.lexer.dictionary.simples.*;

public class TokenAuxi {

 

    public void comprobacion(int type, String lexeme, Token token) {

        switch (type) {

            case 0:

            Keyword keyword = Keyword.probandoKW(lexeme);
                if (keyword != null) {
                    
                    token.setClaseToken("Keyword");
                    token.setTokenType(keyword);
                } else {

                    token.setClaseToken("Constante");
                    token.setTokenType(Constante.ID);
                }
                break;
            case 1:

                OperadorDoble operador = OperadorDoble.getOperadorDoble(lexeme);

                if (operador != null) {
                    token.setClaseToken("OperadorDoble");
                    token.setTokenType(operador);

                } else {
                    throw new IllegalArgumentException("No se encontró un enum Operador doble con el símbolo: " + lexeme);
                }
                break;

            case 2:
                Aritmetico aritmetico = Aritmetico.getAritmetico(lexeme);
                if (aritmetico != null) {
                    token.setClaseToken("Artimetico");
                    token.setTokenType(aritmetico);

                } else {
                    throw new IllegalArgumentException("No se encontró un enum Artimetico con el símbolo: " + lexeme);
                }

                break;

            case 3:
                Relacional relacional = Relacional.getRelacional(lexeme);
                if (relacional != null) {
                    token.setClaseToken("Relacional");
                    token.setTokenType(relacional);
                } else {
                    throw new IllegalArgumentException("No se encontró un enum Relacional con el símbolo: " + lexeme);
                }
                break;

            case 4:
                Delimitador delimitador = Delimitador.getDelimitador(lexeme);

                if (delimitador != null) {
                    token.setClaseToken("Delimitador");
                    token.setTokenType(delimitador);
                } else {
                    throw new IllegalArgumentException("No se encontró un enum Delimitador con el símbolo: >" + lexeme+ "<");
                }
                break;

            case 5:
                Logico logico = Logico.getLogico(lexeme);
                if (logico != null) {
                    token.setClaseToken("Logico");
                    token.setTokenType(logico);
                } else {
                    throw new IllegalArgumentException("No se encontró un enum Logico con el símbolo: " + lexeme);

                }
                break;

            case 6:
                OperadorAsignacion asignacion = OperadorAsignacion.getAsignacion(lexeme);
                if (asignacion != null) {
                    token.setClaseToken("Asignacion");
                    token.setTokenType(asignacion);

                } else {
                    throw new IllegalArgumentException("No se encontró un enum Asigancion con el símbolo: " + lexeme);

                }
                break;

            default:

                throw new IllegalArgumentException("No se encontró un enum con el símbolo: " + lexeme);
        }

    }

}
