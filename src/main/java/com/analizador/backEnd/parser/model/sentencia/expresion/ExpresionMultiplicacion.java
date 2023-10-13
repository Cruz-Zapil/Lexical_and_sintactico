package com.analizador.backEnd.parser.model.sentencia.expresion;

import java.util.ArrayList;

import com.analizador.backEnd.lexer.Token;
import com.analizador.backEnd.lexer.almacenamieto.ListaEnlazada;
import com.analizador.backEnd.lexer.dictionary.BloqueCodigo;
import com.analizador.backEnd.lexer.dictionary.Constante;
import com.analizador.backEnd.lexer.dictionary.simples.Aritmetico;

public class ExpresionMultiplicacion {

    private FactorPrimario factorPrimario = new FactorPrimario();
    private boolean aditiva = false;
    private boolean multiplicatica = false;
    private ArrayList<ListaEnlazada> miArrayList = new ArrayList<>();
    private ListaEnlazada tmpListToken;

    public void scanExpresionMultiplicativa(ListaEnlazada tmpListToken) {

        System.out.println(" llegamos a expresoin multimplicacion");

        this.tmpListToken = tmpListToken;

        /// AQUI VIENE TRES OPCIONES

        /// ADITIVA CON UN SIGNO MAS Y UNA MULTIPLICACION

        /// ya me enviaro el token ---->

        //// ADITIVA CON UN SIGNO MENOS Y UNA MULTIPLICACION

        /// O SIMPLEMENTE UN MULTIPLICATION

        if (primeraOpcion()) {

            for (ListaEnlazada elemento : miArrayList) {

                //// ENVIAR TODOS LOS PAQUETES DE TOKENS EN LA MULTIPLICACON

                if(!elemento.getSiguiente().getTokenType().equals(Aritmetico.SUMA)){
                    

                    
                }


            }

        } else if (segundaOpcion()) {

            for (ListaEnlazada elemento : miArrayList) {

                //// ENVIAR TODOS LOS PAQUETES DE TOKENS EN LA MULTIPLICACON
            }

        } else {

            // tercera opocion
            //// ENVIAR TODO LOS TOKEN NE LA MUTIPLICATION

        }

    }

    public boolean primeraOpcion() {

        boolean tmpSalto = true;

        while (tmpSalto) {

            boolean tmpSigno = true;
            ListaEnlazada tmplist = new ListaEnlazada();

            while (tmpSigno) {

                Token tmpToken = this.tmpListToken.eliminarPrimero();
                if (!tmpToken.getTokenType().equals(Aritmetico.SUMA)) {
                    if (!tmpToken.getTokenType().equals(BloqueCodigo.NEWLINE)
                            || !tmpToken.getTokenType().equals(Constante.EOF)) {
                        tmplist.insertarAlFinal(tmpToken);

                    } else {

                        tmpSalto = false;
                    }
                } else {
                    ListaEnlazada a = new ListaEnlazada();
                    a.insertarAlFinal(tmpToken);
                    miArrayList.add(a);

                    tmpSigno = false;
                }

            }
            miArrayList.add(tmplist);
        }
        if (!miArrayList.isEmpty()) {
            return true;
        }

        return false;

    }

    public boolean segundaOpcion() {

        boolean tmpSalto = true;

        while (tmpSalto) {

            boolean tmpSigno = true;
            ListaEnlazada tmplist = new ListaEnlazada();

            while (tmpSigno) {

                Token tmpToken = this.tmpListToken.eliminarPrimero();
                if (!tmpToken.getTokenType().equals(Aritmetico.RESTA)) {
                    if (!tmpToken.getTokenType().equals(BloqueCodigo.NEWLINE)
                            || !tmpToken.getTokenType().equals(Constante.EOF)) {
                        tmplist.insertarAlFinal(tmpToken);
                    } else {
                        tmpSalto = false;
                    }
                } else {
                    ListaEnlazada a = new ListaEnlazada();
                    a.insertarAlFinal(tmpToken);
                    miArrayList.add(a);
                    tmpSigno = false;
                }

            }
            miArrayList.add(tmplist);
        }
        if (!miArrayList.isEmpty()) {
            return true;
        }

        return false;

    }

    public void expresionMultiplicativa() {

        /// AQUI VIENE MAS OPCIONES 5 CINCO

        /*
         * 
         * expresion_multiplicativa ::= expresion_multiplicativa "*" factor_primario
         * | expresion_multiplicativa "/" factor_primario
         * | expresion_multiplicativa "//" factor_primario
         * | expresion_multiplicativa "%" factor_primario
         * | factor_primario
         * 
         * 
         */

    }

    public boolean isAditiva() {
        return aditiva;
    }

    public void setAditiva(boolean aditiva) {
        this.aditiva = aditiva;
    }

    public boolean isMultiplicatica() {
        return multiplicatica;
    }

    public void setMultiplicatica(boolean multiplicatica) {
        this.multiplicatica = multiplicatica;
    }
    


}
