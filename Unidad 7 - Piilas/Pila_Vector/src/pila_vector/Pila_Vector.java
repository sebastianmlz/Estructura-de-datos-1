/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pila_vector;

import Negocio.PilaV;

/**
 *
 * @author sebas
 */
public class Pila_Vector {

    public static void main(String[] args) {
        PilaV v = new PilaV(8);
        
        v.push(1);
        v.push(2);
        v.push(3);
        v.push(4);
        
        PilaV q = new PilaV(8);
        
        q.push(4);
        q.push(5);
        q.push(6);

        System.out.println("pila v: "+ v.toString());
        //System.out.println("pila q: "+ q.toString());
        System.out.println("------------------------------------------------");
        
        v.invertirRecursivo();
        System.out.println("pila v: "+ v.toString());
        //System.out.println("pila q: "+ q.toString());

    }
    
}
