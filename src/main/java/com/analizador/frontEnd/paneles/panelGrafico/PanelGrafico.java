package com.analizador.frontEnd.paneles.panelGrafico;

import java.awt.Color;
import java.awt.Component;
import javax.swing.DefaultListCellRenderer;
import javax.swing.JList;
import com.analizador.frontEnd.compnents.ConstructorPanel;
import com.analizador.frontEnd.compnents.Item;

public class PanelGrafico extends ConstructorPanel {

    //// paneles de imagenes
    private AuxiGrafico panel2Auxi;

    public PanelGrafico() {
        super(new Color(245, 245, 220));
        panel2Auxi = new AuxiGrafico();
        this.add(panel2Auxi);

    }
}

class ItemListRenderer extends DefaultListCellRenderer {
    @Override
    public Component getListCellRendererComponent(JList<?> list, Object value, int index, boolean isSelected,
            boolean cellHasFocus) {
        if (value instanceof Item) {
            Item item = (Item) value;
            value = item.getLabel();
        }
        return super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
    }

}
