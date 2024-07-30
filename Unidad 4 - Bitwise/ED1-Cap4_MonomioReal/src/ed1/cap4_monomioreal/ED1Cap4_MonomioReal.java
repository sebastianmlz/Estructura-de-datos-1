
package ed1.cap4_monomioreal;

import Negocio.MonomioRealBits;


public class ED1Cap4_MonomioReal {


    public static void main(String[] args) {
        MonomioRealBits m1 = new MonomioRealBits('+', 5, 2, 3, 2);
        System.out.println(m1);
        
        MonomioRealBits m2 = new MonomioRealBits('+', 10, 2, 1, 2);
        System.out.println(m2);
        
        m1.derivar();
        System.out.println(m1);
    }
    
}
