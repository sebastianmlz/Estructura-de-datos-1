/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

/**
 *
 * @author sebas
 */
public class ColaL {
    
    Nodo Frente;
    Nodo Atras;
    int cant;
    
    public ColaL() {
        this.Frente = null;
        this.Atras = null;
        this.cant = 0;
    }
    
    public boolean Vacia(){
        return Frente==null;
    }
    
    public void Encolar(int ele){
        Nodo p=new Nodo();
        p.setDato(ele);
        if (Vacia()){
            Frente=p;
            Atras=p;
            cant++;
        }else{ 
            Atras.setEnlace(p);
            Atras=p;
            cant++;
        }
    }
    
    public int Decolar(){
        int x=Frente.getDato();
        if(Frente==Atras){
            Frente=null;
            Atras=null;
            cant--;
        }else{ Frente=Frente.getEnlace();
            cant--;
        }
        return(x);
    }
    
    public int Get(){
        return Atras.getDato();
    }
    
    public int cantidad(){
        return (cant);
    }
    
    public void intercambiarContenido( ColaL q2){
        int tamaq1 = cantidad() ;
        int tamaq2 = q2.cantidad() ;
        for(int i=0; i<tamaq2; i++){
            Encolar(q2.Decolar());
        }
        for(int i=0; i<tamaq1; i++){
            q2.Encolar(Decolar());
        }
        
    }
    
    @Override
    public String toString() {
        String S=" | ";
        Nodo aux=Frente;
        while (aux!=null){
            S=S+aux.getDato()+" | ";
            aux=aux.getEnlace();
        }
        return S ;
    }
    

}
