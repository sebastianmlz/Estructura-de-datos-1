
package Preg7_Dupla;

public class Presentacion {
    
    public static void main(String[] args) {
        Dupla d1 = new Dupla(5, 10);
        Dupla d2 = new Dupla(6,2);
        System.out.println("Dupla 1: "+ d1.toString());
        System.out.println("Dupla 2: "+d2.toString());
        Dupla d3 = new Dupla();
        //d1.multiplicar(d1, 5);
        d3.multiplicarD(d1, d2);
        System.out.println(d3.toString());
        d1.multiplicar(3);
        System.out.println("Dupla1 x 3: "+d1.toString());
    }
    
}
