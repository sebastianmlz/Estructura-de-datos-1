
package Preg6_Punto;

import java.awt.Color;


public class Punto {
    
    float x, y;
    Color color;
    int tamaño;
    boolean visible;

    public Punto(float x, float y) {
        this.x = x;
        this.y = y;
        this.color = Color.BLACK;   
        this.tamaño = 1;            
        this.visible = true;        
    }
    
    public Punto(float x, float y, Color color, int tamaño, boolean visible) {
        this.x = x;
        this.y = y;
        this.color = color;
        this.tamaño = tamaño;
        this.visible = visible;
    }

    public float getX() {
        return x;
    }

    public void setX(float x) {
        this.x = x;
    }

    public float getY() {
        return y;
    }

    public void setY(float y) {
        this.y = y;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public int getTamaño() {
        return tamaño;
    }

    public void setTamaño(int tamaño) {
        this.tamaño = tamaño;
    }

    public boolean isVisible() {
        return visible;
    }

    public void setVisible(boolean visible) {
        this.visible = visible;
    }
    
    
    
    public void moverPunto( float nuevoX, float nuevoY){
      this.x = nuevoX;
      this.y = nuevoY;
    }
    
    @Override
    
    public String toString() {
        String visibilityText = visible ? "visible" : "no visible";
        return String.format("Punto en (%d, %d)\nColor: %s (%s)\nTamaño: %d\nVisible: %s",
                             x, y, nombreColor(color), getColorHex(color), tamaño, visibilityText);
    }
    
    public String toString2() {
        String textoVisible;
        String s="";
        if(visible == true)
            textoVisible = "visible";
        else
            textoVisible = "mo visible";
        s = s +"Punto en ("+getX()+", "+ getY() +")\nColor: "+nombreColor(color)+"\nTamaño: "+getTamaño()+"\nVisible: "+isVisible();
        return s;
    }
    
    private String nombreColor(Color color){
        if(Color.black.equals(color))
            return "Negro";
        if(Color.BLUE.equals(color))
            return "Azul";
        if(Color.WHITE.equals(color))
            return "Blanco";
        if(Color.GREEN.equals(color))
            return "Verde";
        if(Color.RED.equals(color))
            return "Rojo";
        if(Color.YELLOW.equals(color))
            return "Amarillo";
        return "color Desconocido";
    }
/*
    private String getColorName(Color color) {
        if (Color.BLACK.equals(color)) return "Negro";
        if (Color.RED.equals(color)) return "Rojo";
        if (Color.GREEN.equals(color)) return "Verde";
        if (Color.BLUE.equals(color)) return "Azul";
        // More colors can be added
        return "Desconocido";
    }*/

    private String getColorHex(Color color) {
        return String.format("#%06X", color.getRGB() & 0xFFFFFF);
    }
    
    
}
