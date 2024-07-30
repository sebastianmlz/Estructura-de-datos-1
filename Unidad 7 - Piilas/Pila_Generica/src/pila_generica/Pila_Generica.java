/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package pila_generica;

import Negocio.PilaArray;

/**
 *
 * @author sebas
 */
public class Pila_Generica {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        PilaArray<Integer> pila = new PilaArray<>(5);
        
        pila.apilar(10);
        pila.apilar(20);
        pila.apilar(30);
        
        System.out.println("Cima de la pila: "+ pila.cima());
        System.out.println("Tamanio de la pila: "+ pila.tamaño());
        
        while(!pila.estaVacia()){
            System.out.println("Desapilando: "+ pila.desapilar());
        }
        System.out.println("tamanio de la pila: "+ pila.tamaño());
    }
    
}
