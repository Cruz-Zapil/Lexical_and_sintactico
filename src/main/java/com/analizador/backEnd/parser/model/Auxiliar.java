package com.analizador.backEnd.parser.model;

public class Auxiliar {

    private static int posicionLexema =-1;


    public static int getSiguente() {
       
        posicionLexema++;
        System.out.println("poscion del lexema a enviar: " + posicionLexema);
        return posicionLexema;
    }
    /*
     * 
     public static void setLexema(int posicion, String mensaje){
         System.out.println(" set posicion: "+ posicion + mensaje);
         posicionLexema = posicion; 
        }
        */
}
