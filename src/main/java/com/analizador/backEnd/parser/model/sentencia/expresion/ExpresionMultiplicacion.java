package com.analizador.backEnd.parser.model.sentencia.expresion;

import java.util.ArrayList;

import com.analizador.backEnd.lexer.Token;
import com.analizador.backEnd.lexer.almacenamieto.ListaEnlazada;
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

            for (ListaEnlazada elemento : miArrayList) {

                //// ENVIAR TODOS LOS PAQUETES DE TOKENS EN LA MULTIPLICACON
                if (!elemento.getSiguiente().getTokenType().equals(Aritmetico.MULTIPLICACION)) {
                      if (!factorPrimario.scanFactorPrimario(tmpListToken)) {
                    return false;
                }

                }

            }

        } else if (segundaOpcion() && opcicion2 == true) {

            for (ListaEnlazada elemento : miArrayList) {

                if (!elemento.getSiguiente().getTokenType().equals(Aritmetico.DIVISION)) {
                     if (!factorPrimario.scanFactorPrimario(tmpListToken)) {
                    return false;
                }

                }
                //// ENVIAR TODOS LOS PAQUETES DE TOKENS a factor primario
            }

        } else if (terceraOpcion() && opcicion3 == true) {
            for (ListaEnlazada elemento : miArrayList) {

                //// ENVIAR TODOS LOS PAQUETES DE token a factor primario
                if (!elemento.getSiguiente().getTokenType().equals(OperadorDoble.EXPONENTE)) {
                     if (!factorPrimario.scanFactorPrimario(tmpListToken)) {
                    return false;
                }
                }
            }

        } else if (cuartaOpcion() && opcicion4 == true) {
            for (ListaEnlazada elemento : miArrayList) {

                //// ENVIAR TODOS LOS PAQUETES DE TOKENS a factor primario
                if (!elemento.getSiguiente().getTokenType().equals(Aritmetico.MODULO)) {
                    if (!factorPrimario.scanFactorPrimario(tmpListToken)) {
                    return false;
                }

                }
            }

        } else {

            //// ENVIAR TODOS LOS PAQUETES DE TOKENS a factor primario

            System.out.println(" ultima opcion mmmm");
            for (ListaEnlazada elemento : miArrayList) {

                //// ENVIAR TODOS LOS PAQUETES DE TOKENS EN LA MULTIPLICACON
                if (!factorPrimario.scanFactorPrimario(tmpListToken)) {
                    return false;
                }
                

            }

        }

        return false;

    }

    public boolean primeraOpcion() {
        System.out.println("Primera opción");
        
        boolean tmpSalto = true;
        while (tmpSalto) {
            ListaEnlazada tmplist = new ListaEnlazada();
    
            // Hacer una copia temporal de la lista original
            for (Token elemento : this.tmpListToken.getDatos()) {
                
                if(!elemento.getTokenType().equals(Aritmetico.MULTIPLICACION)){
                    
                    System.out.println(elemento.getTokenType() + " desde primera opcion de m");
                    tmplist.insertarAlFinal(elemento);                    
                }else {
                    ListaEnlazada a = new ListaEnlazada();
                    a.insertarAlFinal(elemento);
                    miArrayList.add(a);
                    opcicion1 = true;
                    break;
                }                               
            }
            tmpSalto= false;
            if (!tmplist.estaVacia()) {
                miArrayList.add(tmplist);
            }  
        }
        return !miArrayList.isEmpty();
    }

        public boolean segundaOpcion() {
        System.out.println("Segunda opción");
        
        boolean tmpSalto = true;
        while (tmpSalto) {
            ListaEnlazada tmplist = new ListaEnlazada();
    
            // Hacer una copia temporal de la lista original
            for (Token elemento : this.tmpListToken.getDatos()) {
                
                if(!elemento.getTokenType().equals(Aritmetico.DIVISION)){
                    
                    System.out.println(elemento.getTokenType() + " desde Segunda opcion de m");
                    tmplist.insertarAlFinal(elemento);                    
                }else {
                    ListaEnlazada a = new ListaEnlazada();
                    a.insertarAlFinal(elemento);
                    miArrayList.add(a);
                    opcicion2 = true;
                    break;
                }                               
            } tmpSalto= false;
            if (!tmplist.estaVacia()) {
                miArrayList.add(tmplist);
            }  
        }
        return !miArrayList.isEmpty();
    }
    public boolean terceraOpcion() {
        System.out.println("Tercera opción");
        
        boolean tmpSalto = true;
        while (tmpSalto) {
            ListaEnlazada tmplist = new ListaEnlazada();
    
            // Hacer una copia temporal de la lista original
            for (Token elemento : this.tmpListToken.getDatos()) {
                
                if(!elemento.getTokenType().equals(OperadorDoble.EXPONENTE)){
                    
                    System.out.println(elemento.getTokenType() + " desde tercera opcion de m");
                    tmplist.insertarAlFinal(elemento);                    
                }else {
                    ListaEnlazada a = new ListaEnlazada();
                    a.insertarAlFinal(elemento);
                    miArrayList.add(a);
                    opcicion3 = true;
                    break;
                }                               
            } tmpSalto= false;
            if (!tmplist.estaVacia()) {
                miArrayList.add(tmplist);
            }  
        }
        return !miArrayList.isEmpty();
    }

        public boolean cuartaOpcion() {
        System.out.println("cuarta opción");
        
        boolean tmpSalto = true;
        while (tmpSalto) {
            ListaEnlazada tmplist = new ListaEnlazada();
    
            // Hacer una copia temporal de la lista original
            for (Token elemento : this.tmpListToken.getDatos()) {
                
                if(!elemento.getTokenType().equals(Aritmetico.MODULO)){
                    
                    System.out.println(elemento.getTokenType() + " desde cuarta opcion de m");
                    tmplist.insertarAlFinal(elemento);                    
                }else {
                    ListaEnlazada a = new ListaEnlazada();
                    a.insertarAlFinal(elemento);
                    miArrayList.add(a);
                    opcicion4 = true;
                    break;
                }                               
            } tmpSalto= false;
            if (!tmplist.estaVacia()) {
                miArrayList.add(tmplist);
            }  
        }
        return !miArrayList.isEmpty();
    }



}
