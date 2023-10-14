package com.analizador.frontEnd.accionesBotton;


import com.analizador.backEnd.lexer.almacenamieto.ListaEnlazada;
import com.analizador.backEnd.parser.model.Raiz;
import com.analizador.frontEnd.accionesBotton.utils.Message;

public class ConectarSintactico {
    
    private Raiz raizSintactico = new Raiz();

    public void enviarAModel(ListaEnlazada listaTokens){

        
        if (!listaTokens.estaVacia()) {            
            System.out.println(" se envio los tokens");
            raizSintactico.scanRaiz(listaTokens);
        }else {
            Message.mostrarMensajeError(" No hay lista de Tokens", " Error!!!!");
        }



    } 
    

}
