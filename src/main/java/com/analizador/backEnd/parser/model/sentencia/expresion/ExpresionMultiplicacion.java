package com.analizador.backEnd.parser.model.sentencia.expresion;

import java.util.ArrayList;

import com.analizador.backEnd.lexer.Token;
import com.analizador.backEnd.lexer.almacenamieto.ListaEnlazada;
import com.analizador.backEnd.lexer.dictionary.BloqueCodigo;
import com.analizador.backEnd.lexer.dictionary.Constante;
import com.analizador.backEnd.lexer.dictionary.concatenables.OperadorDoble;
import com.analizador.backEnd.lexer.dictionary.simples.Aritmetico;

public class ExpresionMultiplicacion {

    private FactorPrimario factorPrimario = new FactorPrimario();
    private boolean opcicion1 = false, opcicion2 = false, opcicion3 = false, opcicion4 = false;
    private ArrayList<ListaEnlazada> miArrayList = new ArrayList<>();
    private ListaEnlazada tmpListToken;

    public boolean scanExpresionMultiplicativa(ListaEnlazada tmpListToken) {

        System.out.println(" llegamos a expresoin multimplicacion");

        for (Token elem : tmpListToken.getDatos()) {
            System.out.println("*** en multi: " + elem.getTokenType());

        }

        this.tmpListToken = tmpListToken;

        /// AQUI VIENE TRES OPCIONES

        /// ADITIVA CON UN SIGNO MAS Y UNA MULTIPLICACION

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
        /// ya me enviaro el token ---->

        //// ADITIVA CON UN SIGNO MENOS Y UNA MULTIPLICACION

        /// O SIMPLEMENTE UN MULTIPLICATION

        if (primeraOpcion() && opcicion1 == true) {

            for (ListaEnlazada a : miArrayList) {

                for (Token b : a.getDatos()) {
                    System.out.println(b.toString());
                }

            }

            for (ListaEnlazada elemento : miArrayList) {

                //// ENVIAR TODOS LOS PAQUETES DE TOKENS EN LA MULTIPLICACON
                if (!elemento.getSiguiente().getTokenType().equals(Aritmetico.MULTIPLICACION)) {
                    if (!factorPrimario.scanFactorPrimario(elemento)) {
                        return false;
                    }
                }
            }
            System.out.println(" es una multiplicacion ");
            return true;

        } else if (segundaOpcion() && opcicion2 == true) {

            for (ListaEnlazada a : miArrayList) {

                for (Token b : a.getDatos()) {
                    System.out.println(b.toString());
                }

            }

            for (ListaEnlazada elemento : miArrayList) {

                if (!elemento.getSiguiente().getTokenType().equals(Aritmetico.DIVISION)) {
                    if (!factorPrimario.scanFactorPrimario(elemento)) {
                        return false;
                    }

                }
                //// ENVIAR TODOS LOS PAQUETES DE TOKENS a factor primario
            }
            System.out.println(" es una division ");
            return true;

        } else if (terceraOpcion() && opcicion3 == true) {

            for (ListaEnlazada a : miArrayList) {

                for (Token b : a.getDatos()) {
                    System.out.println(b.toString());
                }

            }

            for (ListaEnlazada elemento : miArrayList) {

                //// ENVIAR TODOS LOS PAQUETES DE token a factor primario
                if (!elemento.getSiguiente().getTokenType().equals(OperadorDoble.EXPONENTE)) {
                    if (!factorPrimario.scanFactorPrimario(elemento)) {
                        return false;
                    }
                }
            }

            System.out.println(" es una exponente");
            return true;
        } else if (cuartaOpcion() && opcicion4 == true) {

            for (ListaEnlazada a : miArrayList) {

                for (Token b : a.getDatos()) {
                    System.out.println(b.toString());
                }

            }

            for (ListaEnlazada elemento : miArrayList) {

                //// ENVIAR TODOS LOS PAQUETES DE TOKENS a factor primario
                if (!elemento.getSiguiente().getTokenType().equals(Aritmetico.MODULO)) {
                    if (!factorPrimario.scanFactorPrimario(elemento)) {
                        return false;
                    }

                }
            }

            System.out.println(" es una modulo");
            return true;

        } else {

            //// ENVIAR TODOS LOS PAQUETES DE TOKENS a factor primario

            for (ListaEnlazada a : miArrayList) {

                for (Token b : a.getDatos()) {
                    System.out.println(b.toString());
                }

            }

            for (ListaEnlazada elemento : miArrayList) {
                System.out.println(" ultima opcion mmmm");

                //// ENVIAR TODOS LOS PAQUETES DE TOKENS EN LA MULTIPLICACON
                if (!factorPrimario.scanFactorPrimario(elemento)) {
                    return false;
                }
            }
            return true;

        }

    }

    public boolean primeraOpcion() {
        this.tmpListToken.reiniciarRecorrido();

        boolean tmpSalto = true;

        while (tmpSalto) {

            boolean tmpSigno = true;

            ListaEnlazada tmplist = new ListaEnlazada();
            while (tmpSigno) {

                Token tmpToken = this.tmpListToken.obtenerSiguiente();
                if (!tmpToken.getTokenType().equals(Aritmetico.MULTIPLICACION)) {
                    if (!tmpToken.getTokenType().equals(BloqueCodigo.NEWLINE)
                            && !tmpToken.getTokenType().equals(Constante.EOF)) {
                        tmplist.insertarAlFinal(tmpToken);
                    } else {

                        if (!tmplist.estaVacia()) {
                            miArrayList.add(tmplist);
                        }
                        tmpSalto = false;
                        tmpSigno = false;
                    }
                } else {
                    if (!tmplist.estaVacia()) {
                        miArrayList.add(tmplist);
                    }
                    ListaEnlazada a = new ListaEnlazada();
                    a.insertarAlFinal(tmpToken);
                    miArrayList.add(a);
                    tmpSigno = false;
                    opcicion1 = true;
                }
            }
        }
        return miArrayList.isEmpty();
    }

    public boolean segundaOpcion() {
        this.tmpListToken.reiniciarRecorrido();

        boolean tmpSalto = true;

        while (tmpSalto) {

            boolean tmpSigno = true;

            ListaEnlazada tmplist = new ListaEnlazada();
            while (tmpSigno) {

                Token tmpToken = this.tmpListToken.obtenerSiguiente();
                if (!tmpToken.getTokenType().equals(Aritmetico.DIVISION)) {
                    if (!tmpToken.getTokenType().equals(BloqueCodigo.NEWLINE)
                            && !tmpToken.getTokenType().equals(Constante.EOF)) {
                        tmplist.insertarAlFinal(tmpToken);
                    } else {
                        if (!tmplist.estaVacia()) {
                            miArrayList.add(tmplist);
                        }
                        tmpSalto = false;
                        tmpSigno = false;
                    }
                } else {
                    if (!tmplist.estaVacia()) {
                        miArrayList.add(tmplist);
                    }
                    ListaEnlazada a = new ListaEnlazada();
                    a.insertarAlFinal(tmpToken);
                    miArrayList.add(a);
                    tmpSigno = false;
                    opcicion2 = true;
                }
            }
        }
        return miArrayList.isEmpty();
    }

    public boolean terceraOpcion() {
        this.tmpListToken.reiniciarRecorrido();

        boolean tmpSalto = true;

        while (tmpSalto) {

            boolean tmpSigno = true;

            ListaEnlazada tmplist = new ListaEnlazada();
            while (tmpSigno) {

                Token tmpToken = this.tmpListToken.obtenerSiguiente();
                if (!tmpToken.getTokenType().equals(OperadorDoble.EXPONENTE)) {
                    if (!tmpToken.getTokenType().equals(BloqueCodigo.NEWLINE)
                            && !tmpToken.getTokenType().equals(Constante.EOF)) {
                        tmplist.insertarAlFinal(tmpToken);
                    } else {

                        if (!tmplist.estaVacia()) {
                            miArrayList.add(tmplist);
                        }
                        tmpSalto = false;
                        tmpSigno = false;
                    }
                } else {
                    if (!tmplist.estaVacia()) {
                        miArrayList.add(tmplist);
                    }
                    ListaEnlazada a = new ListaEnlazada();
                    a.insertarAlFinal(tmpToken);
                    miArrayList.add(a);
                    tmpSigno = false;
                    opcicion3 = true;
                }
            }
        }
        return miArrayList.isEmpty();
    }

    public boolean cuartaOpcion() {
        this.tmpListToken.reiniciarRecorrido();
        boolean tmpSalto = true;
        while (tmpSalto) {
            boolean tmpSigno = true;
            ListaEnlazada tmplist = new ListaEnlazada();
            while (tmpSigno) {
                Token tmpToken = this.tmpListToken.obtenerSiguiente();
                if (!tmpToken.getTokenType().equals(Aritmetico.MODULO)) {
                    if (!tmpToken.getTokenType().equals(BloqueCodigo.NEWLINE)
                            && !tmpToken.getTokenType().equals(Constante.EOF)) {
                        tmplist.insertarAlFinal(tmpToken);
                    } else {

                        if (!tmplist.estaVacia()) {
                            miArrayList.add(tmplist);
                        }
                        tmpSalto = false;
                        tmpSigno = false;
                    }
                } else {
                    if (!tmplist.estaVacia()) {
                        miArrayList.add(tmplist);
                    }
                    ListaEnlazada a = new ListaEnlazada();
                    a.insertarAlFinal(tmpToken);
                    miArrayList.add(a);
                    tmpSigno = false;
                    opcicion4 = true;
                }
            }
        }
        return miArrayList.isEmpty();
    }
}
