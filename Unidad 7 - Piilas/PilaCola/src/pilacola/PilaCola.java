/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pilacola;

import Negocio.ColaL;
import Negocio.PilaL;

/**
 *
 * @author sebas
 */
public class PilaCola {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        ColaL q1 = new ColaL();
        q1.Encolar(10);
        q1.Encolar(20);
        q1.Encolar(30);
        q1.Encolar(40);

        System.out.println("cola q1: "+ q1);
        
        ColaL q2 = new ColaL();
        q2.Encolar(10);
        q2.Encolar(20);
        q2.Encolar(30);
        q2.Encolar(40);

        
        System.out.println("cola q2: "+ q2);

        System.out.println("----------metodo: intercambiar contenido-------------------------------------");

        System.out.println("identicas: "+ q1.identicas(q2));
        System.out.println("cola q1: "+ q1);
        System.out.println("cola q2: "+ q2);
    }
    
}
