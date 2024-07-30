/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package colas;

import Negocio.ColaB;
import Negocio.ColaL;
import Negocio.ColaV;

/**
 *
 * @author sebas
 */
public class Colas {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        ColaV q = new ColaV(7);
        q.encolarBicola(10);
        q.encolarBicola(2);
        q.encolarBicola(4);
        q.encolarBicola(6);
        q.encolarBicola(8);
        q.encolarBicola(11);
        q.encolarBicola(20);
        
        //System.out.println("longitud de la cola: " + q.longitud());
        
        System.out.println("-------------------------------");

        System.out.println("cola q: "+ q.toStringBicola());
        
        
        
    }
    
}
