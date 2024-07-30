/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lista_circular;

import Negocio.ListaC;

/**
 *
 * @author sebas
 */
public class Lista_Circular {

    public static void main(String[] args) {
        ListaC c = new ListaC();
        
        c.insertarInicio(5);
        c.insertar(7);
        c.insertar(8);
        c.insertar(6,1);
        c.eliminarInicio();
        c.insertar(10);
        c.eliminarInicio();
       
        System.out.println(c);
    }
    
}
