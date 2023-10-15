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

                if (!elemento.getSiguiente().getTokenType().equals(Aritmetico.SUMA)) {
                    System.out.println("---" + elemento.getSiguiente().getTokenType());
                    expresionMultiplicacion.scanExpresionMultiplicativa(elemento);
                }

            }

        } else if (segundaOpcion() && opcicion2 == true) {
            System.out.println(" seguanda opcion en aditiva");

            for (ListaEnlazada elemento : miArrayList) {

                if (!elemento.getSiguiente().getTokenType().equals(Aritmetico.RESTA)) {
                    System.out.println("---" + elemento.getSiguiente().getTokenType());
                    expresionMultiplicacion.scanExpresionMultiplicativa(elemento);
                }

            }

        } else {

            System.out.println(" ultima opion aditiva ");

            for (ListaEnlazada elemento : miArrayList) {
                if (expresionMultiplicacion.scanExpresionMultiplicativa(elemento)) {
                    return true;
                } else {
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
                if (!tmpToken.getTokenType().equals(Aritmetico.RESTA)) {
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
}
