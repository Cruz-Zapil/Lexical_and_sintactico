package com.analizador.frontEnd.compnents;

public class Item {
    
    private String label;
    private String[] subItems;

    public Item(String label) {
        this.label = label;
        this.subItems = new String[0];
    }

    public Item(String label, String[] subItems) {
        this.label = label;
        this.subItems = subItems;
    }

    public String getLabel() {
        return label;
    }

    public String[] getSubItems() {
        return subItems;
    }

    @Override
    public String toString() {
        return label;
    }
}