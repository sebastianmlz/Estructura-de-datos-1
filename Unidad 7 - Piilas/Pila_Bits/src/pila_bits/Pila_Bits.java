/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pila_bits;

import Negocio.PilaB;

/**
 *
 * @author sebas
 */
public class Pila_Bits {

    public static void main(String[] args) {
        PilaB v = new PilaB(5,4);
        
        v.push(4);
        v.push(5);
        v.push(2);
        v.push(4);
        v.push(2);
        //v.eliminar();
        
        System.out.println("Primera pila\n"+ v.toString());
        System.out.println("cima: "+ v.get());
        System.out.println("elemento retirado: "+ v.pop());
        System.out.println("Primera pila\n"+ v.toString());
        System.out.println("cima: "+ v.get());
    }
    
}
