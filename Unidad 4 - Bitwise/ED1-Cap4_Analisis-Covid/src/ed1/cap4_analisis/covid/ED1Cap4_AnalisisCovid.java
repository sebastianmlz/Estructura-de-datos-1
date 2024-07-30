
package ed1.cap4_analisis.covid;

import Negocio.Formu_Analisis_Covid;


public class ED1Cap4_AnalisisCovid {

    public static void main(String[] args) {
        Formu_Analisis_Covid f = new Formu_Analisis_Covid();
        
        f.insertar(13398272, 19, 1, 74, "Sebastian Mendez", 0, 0, 1, 1, 0, 1, 0, 0, 0);
        f.insertar(11111111, 20, 0, 60, "Laura Gomez", 1, 0, 0, 0,0, 1, 0, 0, 0);
        System.out.println(f);
    }
    
}
