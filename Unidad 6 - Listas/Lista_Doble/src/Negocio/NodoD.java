/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Negocio;

/**
 *
 * @author sebas
 */
public class NodoD {
    
    int Data;
    NodoD EnlaceD;
    NodoD EnlaceI;
    
    public NodoD(int Data) {
        this.Data = Data;
        this.EnlaceD = null;
        this.EnlaceI = null;
    }
    
    public NodoD() {
        this.EnlaceD=null;
        this.EnlaceI=null;
    }
    
    public void setData(int Data) {
        this.Data = Data;
    }
    
    public int getData() {
        return (this.Data);
    }
    
    public void setEnlaceD(NodoD EnlaceD) {
        this.EnlaceD = EnlaceD;
    }
    
    public void setEnlaceI(NodoD EnlaceI) {
        this.EnlaceI = EnlaceI;
    }
    
    public NodoD getEnlaceD() {
        return EnlaceD;
    }
    
    public NodoD getEnlaceI() {
        return EnlaceI;
    }
    
    @Override   
    
    public String toString() {
        return "NodoD{" + "Data=" + Data + ", EnlaceD=" + EnlaceD + ", EnlaceI=" + EnlaceI + '}';
    }

}
