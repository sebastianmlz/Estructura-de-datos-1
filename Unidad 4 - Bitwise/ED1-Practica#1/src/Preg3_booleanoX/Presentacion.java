
package Preg3_booleanoX;

public class Presentacion {
    
    public static void main(String[] args) {
        
        BooleanoX b1 = new BooleanoX(1);
        BooleanoX b2 = new BooleanoX(0);
        BooleanoX b3 = new BooleanoX();
     
        
        System.out.println("b1 es: "+b1);
        System.out.println("b2 es: "+b2);
        
        System.out.println("b1 and b2 =" + b3.and(b1, b2));
        
        System.out.println("b1 or b2 =" + b3.or(b1, b2));
        
        System.out.println("not b1  =" + b3.not(b1));
        
        System.out.println("not b2  =" + b3.not(b2));
    }
    
}
