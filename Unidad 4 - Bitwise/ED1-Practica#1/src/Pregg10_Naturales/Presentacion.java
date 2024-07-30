
package Pregg10_Naturales;

public class Presentacion {
    
    public static void main(String[] args) {
        //crear
        Naturales n1 = new Naturales(3);
        Naturales n2 = new Naturales(7);
        System.out.println(n1.toString());
        System.out.println(n2.toString());
        
        //EsCero()
        System.out.println("El numero natural n1 es cero?: "+n1.EsCero());
        System.out.println("El numero natural n2 es cero?: "+n2.EsCero());
        
        //Iguales
        System.out.println("Los numeros naturales n1,n2 ingresados son iguales?: "+Naturales.igual(n1, n2));
        
        Naturales n3 = new Naturales();
        
        //Suma
        n3.Suma(n1, n2);
        System.out.println("La suma de los numeros naturales n1 y n2 es: "+n3);
        
        //Antecesor
        n3.Antecesor(n1);
        System.out.println("El antecesor del numero natural n1 es : "+n3);
        n3.Antecesor(n2);
        System.out.println("El antecesor del numero natural n2 es : "+n3);
        
         //Diferencia
        n3.Diferencia(n1, n2);
        System.out.println("La Diferencia de los numeros naturales n1 y n2 es: "+n3);
        
        //Menor
        n3.Menor(n1, n2);
        System.out.println("El numero natural menor entre n1: "+n1.getNatural()+" y n2: "+n2.getNatural()+" es: "+n3);
    }
    
}
