/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pila_lista;

import Negocio.PilaL;

/**
 *
 * @author sebas
 */
public class Pila_Lista {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PilaL v = new PilaL();
        
        v.push(4);
        v.push(5);
        v.push(2);
        v.push(4);
        v.push(2);
        
        System.out.println("Primera pila\n"+ v.toString());
        System.out.println("cima: "+ v.get());
        System.out.println("elemento : "+ v.pop());
        System.out.println("Primera pila\n"+ v.toString());
        System.out.println("cima: "+ v.get());
        

    }
    
}
