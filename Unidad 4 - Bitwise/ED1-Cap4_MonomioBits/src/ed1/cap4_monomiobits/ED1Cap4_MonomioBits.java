
package ed1.cap4_monomiobits;

import Negocio.MonomioBits;
import Negocio.Monomio_NBits;

public class ED1Cap4_MonomioBits {

    public static void main(String[] args) {
        
        Monomio_NBits m1 = new Monomio_NBits('+', 65,2);
        System.out.println("M1: "+m1);
        
        Monomio_NBits m2 = new Monomio_NBits('+', 9,7);
        System.out.println("M2: "+m2);
        
        Monomio_NBits m3 = new Monomio_NBits();
        m3.Multiplicar(m1, m2);
        
        System.out.println("M3: "+m3);
        
        /*MonomioBits m1 = new MonomioBits('+', 10, 7);
        System.out.println("m1: "+ m1);
        
        MonomioBits m2 = new MonomioBits('+', 2, 4);
        System.out.println("m2: " + m2);

        MonomioBits m3 = new MonomioBits();
        m3.Dividir(m1, m2);
        System.out.println("m3: " + m3);
        
        System.out.println("Evaluar m1 con x=1 : "+m1.Evaluar(2));
        String representacionBinaria = Integer.toBinaryString(5);
        int cantidadDeBits = representacionBinaria.length();
        System.out.println("Cantidad de bits que ocupa el Nro 15: "+cantidadDeBits);*/
    }
    
}
