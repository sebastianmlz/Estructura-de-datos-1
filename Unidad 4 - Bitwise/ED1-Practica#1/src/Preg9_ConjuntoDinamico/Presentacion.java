
package Preg9_ConjuntoDinamico;


public class Presentacion {
    
    public static void main(String[] args) {
        ConjuntoDinamico c1 = new ConjuntoDinamico();
        
        c1.agregar(10);
        c1.agregar(5);
        c1.agregar(3);
        
        System.out.println(c1.toString());
        
        c1.eliminar(5);
        System.out.println(c1.toString());
        
        System.out.println("El conjunto contiene el elemento 3: "+c1.contieneElemtento(3));
        
        System.out.println("Tamaño del conjunto: "+c1.tamaño());
    }
    
}
