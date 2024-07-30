/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica_covid;

import Negocio.Covid;

/**
 *
 * @author sebas
 */
public class Practica_Covid {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Covid formu = new Covid(100);
        
        formu.insertar(100, "Sebastian Mendez",99, 1, 120.5f, 1, 1, 0, 1, 0, 1, 1, 1, 0);
        System.out.println(formu.toString(1));
    }
    
}
