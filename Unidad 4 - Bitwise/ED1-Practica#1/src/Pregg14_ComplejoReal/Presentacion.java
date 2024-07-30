
package Pregg14_ComplejoReal;


public class Presentacion {
    
    public static void main(String[] args) {
        ComplejoReal C1 = ComplejoReal.establecer(5, 3);
        ComplejoReal C2 = ComplejoReal.establecer(2, 2);
        System.out.println("Complejo C1: "+ C1.imprimir());
        System.out.println("Complejo C2: "+ C2.imprimir());
        
        C1.agregar(C2);
        System.out.println("Complejo C1 con C2 agregado: "+ C1.imprimir());
        
        C1.agregar(10, 20);
        System.out.println("Complejo C1 con valores agregados (10+20 i): "+ C1.imprimir());
        
    }
    
}
