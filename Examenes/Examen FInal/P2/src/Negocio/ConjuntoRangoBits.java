/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

/**
 *
 * @author sebas
 */
public class ConjuntoRangoBits {
    
    public int cantidad;
    int rangoInicial, rangoFinal ;
    Bitwise c[];
    
    public ConjuntoRangoBits(int rangoInicial, int rangoFinal){
        this.rangoInicial = rangoInicial;
        this.rangoFinal = rangoFinal;
        int nbw = (rangoFinal - rangoInicial +1) / 32;
        if((rangoFinal-rangoInicial +1) % 32 !=0)
           nbw++ ;
        this.c = new Bitwise[nbw] ;
        this.cantidad = rangoFinal - rangoInicial +1;
        for(int i=0 ; i <= nbw-1 ; i++){
            c[i] = new Bitwise();
        }
    }
    
    public void insertar(int ele){
        if(ele >= rangoInicial && ele <= rangoFinal){
            int nbw = calcNBWRango(ele);
            int nbit = calcNbitRango(ele);
            c[nbw].setbit1(nbit);
        }else{
            System.out.println("Error: Insertar: elemento: "+ele+" fuera de rango");
        }
    }
    
    public void eliminar(int ele){
        if(ele >= rangoInicial && ele <= rangoFinal){
            int nbw = calcNBWRango(ele);
            int nbit = calcNbitRango(ele);
            c[nbw].setbit0(nbit);
        }else{
            System.out.println("Error: ConjuntoBit: Insertar:  fuera de rango");
        }
    }
    
    
    public int calcNBWRango(int ele){
        return ((ele-rangoInicial) / 32);
    }
    
    public int calcNbitRango(int ele){
       return (((ele-rangoInicial) % 32)+1); 
    }
    
    public boolean Pertenece(int ele){
        int nbw = calcNBWRango(ele);
        int nbit = calcNbitRango(ele);
        return c[nbw].getBit(nbit) == 1;
    }
    
    @Override
    public String toString(){
        String s = " {";
        for(int i=rangoInicial; i <= rangoFinal; i++){
            if(Pertenece(i))
                if(i < rangoFinal)
                    s = s + (i) + " , ";
                    else
                    s = s + i + " ";
        }
        s = s + "}";
        return s;
    }
    
}
