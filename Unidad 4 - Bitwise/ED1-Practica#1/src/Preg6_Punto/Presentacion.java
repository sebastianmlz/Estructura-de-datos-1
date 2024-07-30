
package Preg6_Punto;

import java.awt.Color;

public class Presentacion {
    
    public static void main(String[] args) {
        Punto p = new Punto(5, 8);
        
        p.setColor(Color.WHITE);
        p.setTamaño(10);
        p.setVisible(true);
        System.out.println(p.toString2());
        
        p.moverPunto( 2, 9);
        System.out.println("Nueva posicion : "+p.toString2());
    }
    
}
