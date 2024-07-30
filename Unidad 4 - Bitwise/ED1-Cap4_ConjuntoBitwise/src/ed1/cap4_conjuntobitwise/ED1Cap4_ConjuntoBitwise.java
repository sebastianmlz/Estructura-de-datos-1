
package ed1.cap4_conjuntobitwise;

import Negocio.ConjuntoBtw;
import Negocio.ConjuntoDinamicoBtw;
import Negocio.ConjuntoRangoBtw;

public class ED1Cap4_ConjuntoBitwise {

    public static void main(String[] args) {
        ConjuntoBtw cb = new ConjuntoBtw(20);
        
        cb.insertar(2);
        cb.insertar(10);
        cb.insertar(18);
        cb.insertar(12);
        cb.insertar(17);
        cb.insertar(19);
        cb.insertar(1);
        cb.insertar(3);
        cb.insertar(7);
        cb.insertar(9);
        cb.insertar(14);
        cb.insertar(4);


        System.out.println(cb.toString());
        System.out.println("cantidad de elementos: "+cb.cant);
        System.out.println("cantidad de Bitwise: "+cb.cantBitwise());
        
        cb.eliminar(64);
        System.out.println(cb.toString());
        System.out.println("cantidad de elementos: "+cb.cant);
        System.out.println("cantidad de Bitwise: "+cb.cantBitwise());
        
    }
    
}
