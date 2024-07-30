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
    
    public int cantidad(){
        return (cant);
    }
    
    public void invertirExtremos(ColaL cola){
        if(!vacia()){
            if(!cola.Vacia()){
                int dato,tamañoP, tamañoC;
                tamañoP = cantidad()-2;
                tamañoC = cola.cantidad();
                int cabezaCola = cola.Decolar();
                for(int i=0; i<cola.cantidad()-1; i++){
                    dato = cola.Decolar();
                    cola.Encolar(dato);
                }
                cola.Encolar(cabezaCola);
                int cimaPila= pop();
                int cantVeces = cantidad()-1;
                for(int i=0; i<cantVeces; i++){
                    dato = pop();
                    cola.Encolar(dato);
                }
                for(int i=0; i<tamañoC; i++){
                    dato = cola.Decolar();
                    cola.Encolar(dato);
                }
                for(int i=0; i<tamañoP; i++){
                    dato = cola.Decolar();
                    push(dato);
                }
                push(cimaPila);
                tamañoP = cantidad();
                for(int i=0; i<tamañoP; i++){
                    dato = pop();
                    cola.Encolar(dato);
                }
                for(int i=0; i<tamañoC; i++){
                    dato = cola.Decolar();
                    cola.Encolar(dato);
                }
                for(int i=0; i<tamañoP; i++){
                    dato = cola.Decolar();
                    push(dato);
                }
            }
        }
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
