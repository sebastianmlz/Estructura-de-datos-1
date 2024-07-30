
package Pregg12_Matrices;


public class Presentacion {
    
    public static void main(String[] args) {
        
        Matriz m1 = new Matriz(2, 2);
        m1.Asignar(5, 1, 1);
        m1.Asignar(3, 2, 2);
        
        Matriz m2 = new Matriz(2, 2);
        m2.Asignar(5, 1, 2);
        m2.Asignar(10, 2, 1);
        m2.Asignar(30, 1, 1);
        
        Matriz m3 = new Matriz(2, 2);
        
        System.out.println(m1.toString());
        System.out.println(m2.toString());
        
        System.out.println("Elemento posicion f:2, c:2 de matriz1 es: "+m1.ObtenerElemento(2, 2));
        
        m3.Sumar(m1, m2);
        System.out.println("Suma de matriz m1 y m2:\n"+m3.toString());
        
    }
    
}
