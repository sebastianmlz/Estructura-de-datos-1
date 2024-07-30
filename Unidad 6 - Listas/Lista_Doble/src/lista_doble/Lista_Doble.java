/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lista_doble;

import Negocio.ListaD;

/**
 *
 * @author sebas
 */
public class Lista_Doble {

    public static void main(String[] args) {
        ListaD c = new ListaD();
        
        c.insertar(1);
        c.insertar(2);
        c.insertar(3);
        c.insertar(4);
        c.insertar(5);
        System.out.println(c); 
        System.out.println(c.cantNodos());
        c.invertirDe2();
        System.out.println(c);        
        System.out.println(c.cantNodos());
        
    }
    
}
