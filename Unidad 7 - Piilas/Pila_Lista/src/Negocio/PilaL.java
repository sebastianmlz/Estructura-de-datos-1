/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

/**
 *
 * @author sebas
 */
public class PilaL {
    Nodo cima;
    int cant;
    
    public PilaL(){
       this.cima = null;
       this.cant = 0;
    }
    
    public boolean vacia(){
        return (cima == null);
    }
    
    public void push(int ele){
        Nodo p = new Nodo();
        p.setDato(ele);
        p.setEnlace(cima);
        cima = p;
        cant++;
    }
    
    public int pop(){
        int x = cima.getDato();
        cima = cima.getEnlace();
        cant--;
        return x;
    }
    
    public int get(){
        return (cima.getDato());
    }
    
    @Override
    
    public String toString(){
        String s = "";
        Nodo aux = cima;
        while(aux != null){
            s = s + "[" +aux.getDato() + "]\n";
            aux = aux.getEnlace();
        }
        s = s + "p";
        return s;
    }
            
    
}
