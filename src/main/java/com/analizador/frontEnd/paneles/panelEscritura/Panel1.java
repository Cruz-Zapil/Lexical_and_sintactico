package com.analizador.frontEnd.paneles.panelEscritura;


import com.analizador.frontEnd.compnents.ConstructorPanel;
import java.awt.Color;


public class Panel1 extends ConstructorPanel {

    //// panel de lot text area 

    private Panel1Escritura panel1Escritura;

    public Panel1() {
        
        super(new Color(245, 245, 220));
      
        panel1Escritura = new Panel1Escritura();
        this.add(panel1Escritura);
       // setcomponentes1();
    }


}
