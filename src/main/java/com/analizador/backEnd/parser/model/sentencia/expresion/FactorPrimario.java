package com.analizador.backEnd.parser.model.sentencia.expresion;

import com.analizador.backEnd.lexer.Token;
import com.analizador.backEnd.lexer.almacenamieto.ListaEnlazada;
import com.analizador.backEnd.lexer.dictionary.Constante;
import com.analizador.backEnd.lexer.dictionary.concatenables.Keyword;

public class FactorPrimario {

   private Token lexema;
   private int nivelIdentacion;

   public boolean scanFactorPrimario(ListaEnlazada tmpListToken) {

      System.out.println(" llegando a factor primario ");

      // AQUI VIEN MAS OPCIONES

      /*
       * factor_primario ::= identificador
       * | literal
       * | llamada_funcion
       * | acceso_atributo
       * | acceso_indice
       * | expresion_generador
       * | expresion_comprension_lista
       * | expresion_comprension_diccionario
       * | "(" expresion ")"
       * | "[" lista_elementos "]"
       * | "{" diccionario_elementos "}"
       * 
       * 
       */

      this.lexema = tmpListToken.eliminarPrimero();
      System.out.println(this.lexema.getTokenType()+"++++ ");
      /// COMENZAREMOS CON IDENTIFICADOR
      if (this.lexema.getTokenType().equals(Constante.ID)) {
         System.out.println(" es un ID desde fator primario");
         return true;

      }

      /// se analiza si es una literal
      else if (this.lexema.getTokenType().equals(Constante.STRING)) {
         System.out.println(" es una cadena desde factor primario ");
         return true;
      } else if (this.lexema.getTokenType().equals(Constante.INT)) {

         System.out.println(" es una int desde factor primario");
         return true;

      } else if (this.lexema.getTokenType().equals(Constante.DOUBLE)) {

         System.out.println(" es una dooble  desde factor primario ");
         return true;

      } else if (this.lexema.getTokenType().equals(Keyword.TRUE)) {

         System.out.println(" es una true desde factor primario ");
         return true;
      } else if (this.lexema.getTokenType().equals(Keyword.FALSE)) {

         System.out.println(" es un falce desde facotor primario ");

         return true;
      } else {
         System.out.println(" puede que sea otra situacion desde factor primario ");
         return false;
      }

      /*
       * else if (){
       * 
       * /// se analiza si es una llamada de fucnion
       * }else if (){
       * //// se analiza si es una acceso a atributo
       * }else if (){
       * // se analiza si es una expresion generador
       * }else if(){
       * // se analiza si es una expresion generador
       * }else if (){
       * /// "(" expresion ")"
       * }
       */

   }

   public int getNivelIdentacion() {
      return nivelIdentacion;
   }

   public void setNivelIdentacion(int nivelIdentacion) {
      this.nivelIdentacion = nivelIdentacion;
   }

}
