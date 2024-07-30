/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package practica_alarma;

import Negocio.Alarma;

/**
 *
 * @author sebas
 */
public class Practica_Alarma {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Alarma a = new Alarma(10);
        
        a.insertar(23, 6, 1, 13, 27, "Examen 1", 1, 2, 4, 1);
        a.insertar(31, 12, 1, 24, 59, "Examen 2", 0, 2, 4, 2);
        System.out.println(a.toString(1));
        System.out.println(a.toString(2));
    }
    
}
