
package Preg5_Periodo;

public class Presentacion {
    
    public static void main(String[] args) {
        
        Periodo p1 = new Periodo(10);
        System.out.println("Trabaje en la empresa "+p1.dias+" dias");
        
        Periodo p2 = new Periodo(2, 10);
        System.out.println("Trabaje en la empresa "+p2.meses+" meses y "+p2.dias+" dias");
        
        Periodo p3 = new Periodo(1, 2, 10);
        System.out.println("Trabaje en la empresa "+p3.anios+" años, "+p3.meses+" meses y "+p3.dias+" dias");
        
        System.out.println("\nTiempo en dias que se trabajo cada periodo: ");
        System.out.println("Periodo 1 trabajo: "+Periodo.traducirADias(p1)+" dias");
        System.out.println("Periodo 2 trabajo: "+Periodo.traducirADias(p2)+" dias");
        System.out.println("Periodo 3 trabajo: "+Periodo.traducirADias(p3)+" dias");
    }
    
}
