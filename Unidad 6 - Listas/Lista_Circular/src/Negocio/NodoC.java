/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

/**
 *
 * @author sebas
 */
public class NodoC {
   
    private Object Elemento; // el dato Puede ser cualquier tipo
    private NodoC Enlace;
    
    public NodoC(){
        Elemento=null;
        Enlace=null;
    }
    
    public void setElem(Object ele){
        Elemento = ele;
    }
    
    public Object getElem(){
        return Elemento;
    }
    
    public void setEnlace(NodoC Raux ){
        Enlace=Raux;
    }
    
    public NodoC getEnlace(){
        return Enlace;
    }

}
