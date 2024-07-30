/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package negocios;

/**
 *
 * @author sebas
 */
public class Complejo {
    
    float Preal;
    int Pimag;
    
    //Construye una instancia de la class complejo
    
    public Complejo(){
        Preal = 0;
        Pimag = 0;
    }
    
    //Construye una instancia de la class complejo sobrecargado con parametros de entrada
    
    public Complejo(float Preal, int Pimag){
        this.Preal = Preal;
        this.Pimag = Pimag;
    }
    
    //introduce la parte real del complejo
    
    public void setPral(float Preal){
        this.Preal = Preal;
    }
    
    //introduce la parte imaginaria del complejo
    
    public void setPimag(int Pimag){
        this.Pimag = Pimag;
    }    
    
    //devuelve la parte real del complejo
    
    public float getPreal(){
        return Preal;
    }
    
    //devuelve la parte imaginaria de un complejo
    
    public int getImag(){
        return Pimag;
    }
    
    @Override
    public String toString(){
        String s = "C{";
        if(Preal > 0)
            s = s + "+";
        s = s + Preal+" ";
        if(Pimag > 0)
            s = s + "+";
        s = s + Pimag + " i }";
        return s;
    }
    
    public void suma(Complejo A, Complejo B){
        this.Preal = A.Preal + B.Preal;
        this.Pimag = A.getImag() + B.getImag();
    }
    
    public void resta(Complejo A, Complejo B){
        this.Preal = A.Preal - B.Preal;
        this.Pimag = A.getImag() - B.getImag();
    }
}
