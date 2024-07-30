
package Preg8_ConjuntoRango;


public class Presentacion {
    
    public static void main(String[] args) {
        ConjuntoRango C = new ConjuntoRango(10, 15);
        ConjuntoRango C2 = new ConjuntoRango(20, 30);
        C.insertar(10);
        C.insertar(11);
        C.insertar(12);
        C.insertar(13);
        C.insertar(14);
        C.insertar(15);
        C.insertar(16);
        C.insertar(11);
        System.out.println(C.toString());
        
        C2.insertar(20);
        C2.insertar(21);
        C2.insertar(22);
        C2.insertar(23);
        C2.insertar(27);
        C2.insertar(28);
        C2.insertar(26);
        C2.insertar(40);
        System.out.println(C2.toString());
        
        ConjuntoRango C3 = new ConjuntoRango(10, 30);
        C3.union(C, C2);
        System.out.println("C3: "+C3.toString());
    }
}
