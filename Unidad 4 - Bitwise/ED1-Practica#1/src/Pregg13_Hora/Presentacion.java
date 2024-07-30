
package Pregg13_Hora;

public class Presentacion {
    
    public static void main(String[] args) {
        Hora h1 = new Hora(23, 59, 59);
        
        System.out.println(h1.imprimir());
        
        //adelantar 1hora, 1minuto, 1segundo
        h1.adelantar(1, 1, 1);
        System.out.println("hora adelantada 1h,1m,1s:\n"+ h1.imprimir());
        
        //reiniciar hora a las 12:00:00
        h1.reiniciar(12, 0, 0);
        System.out.println("hora reiniciada a 12h,0m,0s :\n"+h1.imprimir());
    }
    
}
