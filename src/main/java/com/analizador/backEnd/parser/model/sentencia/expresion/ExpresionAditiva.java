package com.analizador.backEnd.parser.model.sentencia.expresion;

import java.util.ArrayList;

import com.analizador.backEnd.lexer.Token;
import com.analizador.backEnd.lexer.almacenamieto.ListaEnlazada;
import com.analizador.backEnd.lexer.dictionary.BloqueCodigo;
import com.analizador.backEnd.lexer.dictionary.Constante;
import com.analizador.backEnd.lexer.dictionary.simples.Aritmetico;

public class ExpresionAditiva {

    private ExpresionMultiplicacion expresionMultiplicacion = new ExpresionMultiplicacion();
    private boolean opcicion1 = false, opcicion2 = false;
    private ArrayList<ListaEnlazada> miArrayList = new ArrayList<>();
    private ListaEnlazada tmpListToken;

    public boolean scanExpresionAditiva(ListaEnlazada tmpListToken) {

        this.tmpListToken = tmpListToken;

        System.out.println(" expresion relacional aditiva ");

        /// AQUI VIENE TRES OPCIONES

        /// ADITIVA CON UN SIGNO MAS Y UNA MULTIPLICACION

        /// ya me enviaro el token ---->

        //// ADITIVA CON UN SIGNO MENOS Y UNA MULTIPLICACION

        /// O SIMPLEMENTE UN MULTIPLICATION


        if (primeraOpcion() && opcicion1 == true) {
            System.out.println(" primera opcion en aditiva ");

            for (ListaEnlazada elemento : miArrayList) {

                //// ENVIAR TODOS LOS PAQUETES DE TOKENS EN LA MULTIPLICACON
                eliminala();
                if (!elemento.getSiguiente().getTokenType().equals(Aritmetico.SUMA)) {
                    expresionMultiplicacion.scanExpresionMultiplicativa(elemento);
                }

            }

        } else if (segundaOpcion() && opcicion2 == true) {
            System.out.println(" seguanda opcion en aditiva");
            eliminala();
            for (ListaEnlazada elemento : miArrayList) {

                if (!elemento.getSiguiente().getTokenType().equals(Aritmetico.RESTA)) {
                    expresionMultiplicacion.scanExpresionMultiplicativa(elemento);
                }

            }

        } else {

            System.out.println(" ultima opion aditiva ");
            eliminala();
            for (ListaEnlazada elemento : miArrayList) {
                if (expresionMultiplicacion.scanExpresionMultiplicativa(elemento) ) {
                    return true;                    
                }else {
                    return false;
                }
                
            }

        }

        return false;

    }



    public boolean primeraOpcion() {
        this.tmpListToken.reiniciarRecorrido();
        boolean tmpSalto = true;

        while (tmpSalto) {

            boolean tmpSigno = true;
            ListaEnlazada tmplist = new ListaEnlazada();

            while (tmpSigno) {

                Token tmpToken = this.tmpListToken.obtenerSiguiente();
                if (!tmpToken.getTokenType().equals(Aritmetico.SUMA)) {

                    if (!tmpToken.getTokenType().equals(BloqueCodigo.NEWLINE)
                            && !tmpToken.getTokenType().equals(Constante.EOF)) {
                        System.out.println(tmpToken.getTokenType() + " primera opcion a");
                        tmplist.insertarAlFinal(tmpToken);

                    } else {
                        tmpSalto = false;
                        tmpSigno = false;

                    }
                } else {

                    ListaEnlazada a = new ListaEnlazada();
                    a.insertarAlFinal(tmpToken);
                    miArrayList.add(a);
                    opcicion1 = true;

                    tmpSigno = false;
                }

            }
            if (!tmplist.estaVacia()) {
                miArrayList.add(tmplist);
            }
        }
        if (!miArrayList.isEmpty()) {
            return true;
        }

        return false;

    }

    public boolean segundaOpcion() {
        this.tmpListToken.reiniciarRecorrido();

        System.out.println( " segunda opcion 2");
        boolean tmpSalto = true;

        while (tmpSalto) {

            boolean tmpSigno = true;
            ListaEnlazada tmplist = new ListaEnlazada();

            while (tmpSigno) {

                Token tmpToken = this.tmpListToken.obtenerSiguiente();
                if (!tmpToken.getTokenType().equals(Aritmetico.RESTA)) {
                    if (!tmpToken.getTokenType().equals(BloqueCodigo.NEWLINE)
                            && !tmpToken.getTokenType().equals(Constante.EOF)) {
                        System.out.println(tmpToken.getTokenType() + " desde segunda opcion de a");
                        tmplist.insertarAlFinal(tmpToken);
                    } else {
                        tmpSalto = false;
                        tmpSigno = false;
                    }
                } else {
                    ListaEnlazada a = new ListaEnlazada();
                    a.insertarAlFinal(tmpToken);
                    miArrayList.add(a);
                    tmpSigno = false;
                    opcicion2 = true;
                }

            }
            if (!tmplist.estaVacia()) {

                miArrayList.add(tmplist);
            }
        }

        if (!miArrayList.isEmpty()) {
            return true;
        }

        return false;

    }

    public void eliminala() {
        boolean tmp= true;
        while (tmp) {

            Token tmps = this.tmpListToken.eliminarPrimero();
            
            if (tmps.getTokenType().equals(BloqueCodigo.NEWLINE)) {
                break;                
            }
        }

    }

}
